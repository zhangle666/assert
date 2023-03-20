package com.virtue.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.BorrowedMapper;
import com.virtue.mapper.TransferMapper;
import com.virtue.pojo.Borrowed;
import com.virtue.pojo.Transfer;
import com.virtue.service.BorrowedService;
import com.virtue.service.TransferService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Resource
    private TransferMapper mapper;
    @Resource
    private BorrowedService borrowedService;
    @Override
    public List<Transfer> findAll() {

        return mapper.selectList(null);
    }

    @Override
    public Boolean save(Transfer transfer) {
        DateFormat format=new SimpleDateFormat("yyyyMMdd");
        String s=format.format(new Date());
       transfer.setTrorder("TR"+s+ RandomUtil.randomNumbers(5));

            int insert = mapper.insert(transfer);
            if (insert>0){
                Borrowed borrowed=new Borrowed();
                borrowed.setReturndate(s);
                borrowed.setIsValid("1");
                Integer wornpeid = transfer.getWornpeid();
                borrowed.setBoid(wornpeid);
                borrowedService.update(borrowed);


                //增加
                DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                String date=format.format(new Date());
                Borrowed borrowed1=new Borrowed();
                borrowed1.setIsValid("0");
                borrowed1.setBoorder("BO"+s+ RandomUtil.randomNumbers(5));
                borrowed1.setBocause(transfer.getCause());
                borrowed1.setBodate(date);
                Borrowed selectWaidByBoid = borrowedService.selectWaidByBoid(transfer.getWornpeid());
                borrowed1.setWaid(selectWaidByBoid.getWaid());
                borrowed1.setPeid(transfer.getNewpeid());
                borrowedService.save(borrowed1);
            }
            return insert>0;

    }
    @Override
    public Transfer getById(Integer trid) {
        return mapper.findOneByTrid(trid);
    }

    @Override
    public boolean update(Transfer transfer) {
        return mapper.updateruturndate(transfer)>0;
    }

    @Override
    public Boolean deleteById(Integer trid) {
        return mapper.deleteById(trid)>0;
    }



    @Override
    public IPage<Transfer> getPage(int currenPage, int pageSize, Transfer transfer) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Transfer> wrapper = new QueryWrapper<>();
        String trorder = transfer.getTrorder();
        String genrecode = transfer.getGenrecode();
        String waname = transfer.getWaname();
        String gname = transfer.getGname();
        if (!StringUtils.isEmpty(gname)){
            wrapper.like("g.gname",gname);
        }
        if (!StringUtils.isEmpty(genrecode)){
            wrapper.like("p.genrecode",genrecode);
        }
        if (!StringUtils.isEmpty(trorder)){
            wrapper.like("t.trorder",trorder);
        }
        if (!StringUtils.isEmpty(waname)){
            wrapper.like("w.waname",waname);
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
        Transfer scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }


}
