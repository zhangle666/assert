package com.virtue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 4.15	资产入库 表名：warehous
 * @TableName warehous
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("borrowed")
public class Borrowed implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer boid;

    /**
     * 入库id
     */
//    @TableField(exist = false)
    private Integer waid;

    /**
     * 借用日期
     */
    private String bodate;

    /**
     * 使用人id
     */
    private Integer peid;

    /**
     * 借用原因
     */
    private String bocause;

    /**
     * 归还日期
     */
    private String returndate;

    /**
     * 归还状态
     */
    private String isValid;

    /**
     * 借用单号
     */
    private String genrecode;
    private String boorder;
    private String waname;
    private String gname;
    private String pename;
    private String dename;
    private String jobnub;
     private String bz;

    private static final long serialVersionUID = 1L;
}