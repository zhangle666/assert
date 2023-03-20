package com.virtue.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName supplier
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("supplier")
public class Supplier implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer supid;

    /**
     * 供应商名称
     */
    private String supname;

    /**
     * 供应商类型
     */
    private String suptype;

    /**
     * 状态（禁用、启用）
     */
    private Integer isValid;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建时间
     */
    private String createTime;

    private static final long serialVersionUID = 1L;
}