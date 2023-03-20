package com.virtue.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.WarehousMapper;
import com.virtue.pojo.Retirement;
import com.virtue.pojo.Warehous;

import com.virtue.service.WarehousService;
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
public class WarehousServiceImpl implements WarehousService {
    @Resource
    private WarehousMapper mapper;

    @Override
    public List<Warehous> findAll() {

        return mapper.findWaname();
    }

    @Override
    public Boolean save(Warehous warehous) {
        warehous.setIsValid(1);
       if (mapper.selectByWaname(warehous.getWaname())==null){

           return mapper.saveWarehous(warehous)>0;
       }
       return false;




    }
    @Override
    public Warehous getById(Integer waid) {
        return mapper.getByWaidWarehous(waid);
    }

    @Override
    public boolean update(Warehous warehous) {
        return mapper.updateById(warehous)>0;
    }

    @Override
    public Boolean deleteById(Integer suid) {
        return mapper.deleteById(suid)>0;
    }



    @Override
    public IPage<Warehous> getPage(int currenPage, int pageSize, Warehous warehous) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Warehous> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("wadate");
        String waname = warehous.getWaname();
        String gname = warehous.getGname();
        String genrecode = warehous.getGenrecode();
        Integer isValid = warehous.getIsValid();
        if (!StringUtils.isEmpty(genrecode)){
            wrapper.like("g.genrecode",genrecode);
        }
        if (!StringUtils.isEmpty(waname)){
            wrapper.like("w.waname",waname);
        }
        if (!StringUtils.isEmpty(gname)){
            wrapper.like("g.gname",gname);
        }
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("g.is_valid",isValid);
        }
        mapper.findByPage(page,wrapper);
        return page;
    }


    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Warehous scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }

    @Override
    public void downloadAllWarehous(HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("入库信息表");
        List<Warehous> lists = mapper.findAll();
          DateFormat format=new SimpleDateFormat("yyyy-MM-dd ");
        String s=format.format(new Date());
        String fileName = s+"Warehous" + ".xls";
        int rowNum = 1;
        String[] headers = {"资产编码", "资产名称", "资产类别", "供应商", "品牌", "取得方式", "入库日期", "存放地点","图片"};
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell rowCell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            rowCell.setCellValue(text);
        }
        for (Warehous list : lists) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(list.getGenrecode());
            row1.createCell(1).setCellValue(list.getWaname());
            row1.createCell(2).setCellValue(list.getGname());
            row1.createCell(3).setCellValue(list.getSupname());
            row1.createCell(4).setCellValue(list.getBrname());
            row1.createCell(5).setCellValue(list.getAcname());
            row1.createCell(6).setCellValue(list.getWadate());
            row1.createCell(7).setCellValue(list.getStname());
            row1.createCell(8).setCellValue(list.getWaimg());
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
