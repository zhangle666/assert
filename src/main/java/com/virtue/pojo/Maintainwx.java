package com.virtue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 4.19	资产维修 表名：maintain
 * @TableName maintain
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("maintainwx")
public class Maintainwx implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer maid;
    private Integer waid;
    private Integer ref;
    private BigDecimal repr;
    private String genrecode;
    private String waname;
    private static final long serialVersionUID = 1L;
}