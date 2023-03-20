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
 * 部门管理表
 * @TableName department
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("department")
public class Department implements Serializable {
    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Integer deid;

    /**
     * 部门编码
     */
    private String denub;

    /**
     * 名称
     */
    private String dename;

    /**
     * 更新时间
     */
    private String uptime;
    private Integer isValid;

    private static final long serialVersionUID = 1L;
}