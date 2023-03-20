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
 * 人员管理表
 * @TableName personnel
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("personnel")
public class Personnel implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer peid;

    /**
     * 姓名
     */
    private String pename;

    /**
     * 工号
     */
    private String jobnub;

    /**
     * 所属部门
     */
    private String dename;

    private static final long serialVersionUID = 1L;
}