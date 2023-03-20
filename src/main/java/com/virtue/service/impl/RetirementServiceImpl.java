package com.virtue.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.RetirementMapper;
import com.virtue.mapper.WarehousMapper;
import com.virtue.pojo.Retirement;
import com.virtue.service.RetirementService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RetirementServiceImpl implements RetirementService {
    @Resource
    private RetirementMapper mapper;
    @Resource
    private WarehousMapper warehousMapper;

    @Override
    public List<Retirement> findAll() {

        return mapper.findAll();
    }

    @Override
    public Boolean save(Retirement retirement) {
        DateFormat format=new SimpleDateFormat("yyyyMMdd");
        String s=format.format(new Date());
            int insert = mapper.insert(retirement);
            if (insert>0){
                Integer validByWaid = warehousMapper.updateIsValidByWaid(retirement.getWaid());
                return validByWaid>0;
            }
            return insert>0;

    }
    @Override
    public Retirement getById(Integer reid) {
        return mapper.findOneByReid(reid);
    }

    @Override
    public boolean update(Retirement retirement) {
        return mapper.updateruturndate(retirement)>0;
    }

    @Override
    public Boolean deleteById(Integer reid) {
        return mapper.deleteById(reid)>0;
    }



    @Override
    public IPage<Retirement> getPage(int currenPage, int pageSize, Retirement retirement) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Retirement> wrapper = new QueryWrapper<>();
        String pename = retirement.getPename();
        String waname = retirement.getWaname();
        Integer isValid = retirement.getIsValid();
        String gname = retirement.getGname();
        String scnames = retirement.getScnames();
        if (!StringUtils.isEmpty(scnames)){
            wrapper.like("s.scnames",scnames);
        }
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("w.is_valid",isValid);
        }
        if (!StringUtils.isEmpty(gname)){
            wrapper.like("g.gname",gname);
        }
        if (!StringUtils.isEmpty(pename)){
            wrapper.like("p.pename",pename);
        }
        if (!StringUtils.isEmpty(waname)){
            wrapper.like("w.waname",waname);
        }
        mapper.findByPage(page,wrapper);
        return page;
    }


    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Retirement scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }

    @Override
    public Retirement selectWaidByBoid(Integer reid) {
        return null;
    }

    @Override
    public Boolean updateIsvalid(Integer reid) {
        return mapper.updateIsvalid(reid)>0;
    }

    @Override
    public void downloadAllRetirement(HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("报废信息表");
        List<Retirement> lists = mapper.findAll();

        String fileName = "Retirement" + ".xls";
        int rowNum = 1;
        String[] headers = {"资产编码", "资产名称", "资产类别", "申请人", "报废日期", "报废方式", "报废原因", "报废申请结果"};
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell rowCell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            rowCell.setCellValue(text);
        }
        for (Retirement list : lists) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(list.getGenrecode());
            row1.createCell(1).setCellValue(list.getWaname());
            row1.createCell(2).setCellValue(list.getGname());
            row1.createCell(3).setCellValue(list.getPename());
            row1.createCell(4).setCellValue(list.getRedate());
            row1.createCell(5).setCellValue(list.getScnames());
            row1.createCell(6).setCellValue(list.getReason());
            row1.createCell(7).setCellValue(list.getApprovalre());
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
