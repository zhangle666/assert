package com.virtue.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 品牌表
 * @TableName brand
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("brand")
public class Brand implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer brid;

    /**
     * 品牌编码
     */
    private String brnub;

    /**
     * 品牌名称
     */
    private String brname;

    /**
     * 状态
     */
    private Integer isValid;

    /**
     * 创建时间
     */
    private String brtime;

    private static final long serialVersionUID = 1L;

}