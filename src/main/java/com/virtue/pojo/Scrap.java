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
 * 报废方式表
 * @TableName scrap
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("scrap")
public class Scrap implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer scid;

    /**
     * 报废方式编码
     */
    private String scnubs;

    /**
     * 报废方式名称
     */
    private String scnames;

    /**
     * 状态
     */
    private Integer isValid;

    private static final long serialVersionUID = 1L;
}