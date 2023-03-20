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
 * 
 * @TableName store
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("store")
public class Store implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer stid;

    /**
     * 存放地点名称
     */
    private String stname;

    /**
     * 类型
     */
    private String sttype;

    /**
     * 状态
     */
    private Integer isValid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private String createTime;

    private static final long serialVersionUID = 1L;
}