package com.virtue.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 4.19	资产维修 表名：maintain
 * @TableName maintain
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("maintain")
public class Maintain implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer maid;

    /**
     * 维修单号
     */
    private String maorder;

    /**
     * 资产编码
     */
    private Integer waid;

    /**
     * 报修人id
     */
    private Integer repairerpeid;

    /**
     * 报修原因
     */
    private String cause;

    /**
     * 维修单位
     */
    private String unit;

    /**
     * 修复日期
     */
    private String repair;

    /**
     * 维修费用
     */
    private BigDecimal expense;

    private String faultde;
    private String gname;
    private String  genrecode;
    private String jobnub;
    private String pename;
    private String waname;
    private String bdate;
    private static final long serialVersionUID = 1L;
}