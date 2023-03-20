package com.virtue.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 资产申购表
 * @TableName subscribe
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("subscribe")
public class Subscribe implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer suid;

    /**
     * 申购单号
     */
    private String suorder;

    /**
     * 申购资产
     */
    private String suass;

    /**
     * 资产类别(asscat)表
     */
    private String genrecode;

    /**
     * 申购数量
     */
    private Integer sunub;

    /**
     * 预计价格
     */
    private BigDecimal suprice;

    /**
     * 申请人
     */
    private String pename;

    /**
     * 所属部门（部门名称）
     */
    @TableField(exist = false)
    private String dename;

    /**
     * 申请日期
     */
    private String sudate;
    /**
     * 申请理由
     */
    private String reason;
    /**
     * 申请建议
     */
    private String suggest;
    private String beginTime;
    private String endTime;
    private String  jobnub;
    private Integer peid;
    private Integer gid;
    private Integer isValid;

    private String auditres;
    private static final long serialVersionUID = 1L;
}