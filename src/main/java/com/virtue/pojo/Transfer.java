package com.virtue.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName transfer
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("transfer")
public class Transfer implements Serializable {
    /**
     * 
     */

    @TableId(type = IdType.AUTO)
    private Integer trid;

    /**
     * 转移单号
     */
    private String trorder;

    /**
     *  原使用人
     */
    private Integer wornpeid;

    /**
     * 新使用人
     */
    private Integer newpeid;

    /**
     * 转移日期
     */
    private String trdate;

    /**
     * 备注
     */
    private String cause;

    private String genrecode;
    private String gname;
    private String waname;
    private String worn;
    private String newname;
    private String waid;
    /**
     *  新使用人的工号
     */
    private String newjobup;
    /**
     * 原使用人的工号
     */
    private String wornjobub;
    /**
     * 新使用人的部门
     */
    private String newdename;
    /**
     * 原使用人部门
     */
    private String worndename;
    private static final long serialVersionUID = 1L;
}