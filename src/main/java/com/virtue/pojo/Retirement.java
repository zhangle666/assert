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
4.20	资产报废 表名：retirement
 * @TableName retirement
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("retirement")
public class Retirement implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer reid;

    /**
     * 资产编码
     */
    private Integer waid;

    /**
     * 申请人
     */
    private String peid;

    /**
     * 报废日期
     */
    private String redate;

    /**
     * 报废方式  4.12报废方式 表名：scrap
     */
    private String scid;

    /**
     * 报废原因
     */
    private String reason;

    private String gname;
    private String  genrecode;
    private String jobnub;
    private String pename;
    private String waname;
    private String scnames;
    private Integer isValid;
    private String approvalre;
    private static final long serialVersionUID = 1L;
}