package com.virtue;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.mapper.BorrowedMapper;
import com.virtue.pojo.Achieve;
import com.virtue.pojo.Borrowed;
import com.virtue.pojo.Genres;
import com.virtue.pojo.User;
import com.virtue.service.*;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringbootAssetsApplicationTests {
    private byte[] waimg;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BorrowedMapper service;
    @Test
    void contextLoads() {
//        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String s=format.format(new Date());
//        ValueOperations operations = redisTemplate.opsForValue();
//        operations.set("elvt",s);
//        System.out.println(operations.get("elvt"));
    //    System.out.println(RandomUtil.randomNumbers(6));
//        List<Genres> all = genresService.findAll();
//        System.out.println(all);
//
//        List<Achieve> achieves = service.fuzzyByAcnub("e");
//        System.out.println(achieves);


        }
    @Test
    void test1() {
        Borrowed borrowed = service.selectByPeid(1);
        System.out.println(borrowed);
    }
    @Test
    void test2() {
        DateFormat format=new SimpleDateFormat("yyyyMMdd");
        String s=format.format(new Date());
        System.out.println(s);
    }
    }


