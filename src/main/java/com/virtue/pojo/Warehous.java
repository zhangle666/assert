package com.virtue.pojo;

import java.io.Serializable;
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
 * 4.15	资产入库 表名：warehous
 * @TableName warehous
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("warehous")
public class Warehous implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer waid;

    /**
     * zc编码
     */
    @TableField(exist = false)
    private String genrecode;

    /**
     * 资产名称
     */
    private String waname;

    /**
     * 资产类别名称
     */
    private String gname;

    /**
     * 供应商
     */
    private String supname;

    /**
     * 品牌
     */
    private String brname;

    /**
     * 取得方式
     */
    private String acname;

    /**
     * 入库日期
     */
    private String wadate;

    /**
     * 存放地点
     */
    private String stname;

    /**
     * 资产状态
     */
    private Integer isValid;

    /**
     * 资产图片
     */
    private String waimg;
    @TableField(exist = false)
    private Integer brid;
    @TableField(exist = false)
    private Integer gid;
    @TableField(exist = false)
    private Integer acid;
    @TableField(exist = false)
    private Integer supid;
    @TableField(exist = false)
    private Integer stid;
    private static final long serialVersionUID = 1L;
}