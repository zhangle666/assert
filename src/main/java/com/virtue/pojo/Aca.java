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
 * 资产盘点：新增盘点单>“添加盘点资产”窗口。表名：aca
 * @TableName aca
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("aca")
public class Aca implements Serializable {
    /**
     * 盘点id
     */
    @TableId(type = IdType.AUTO)
    private Integer adid;

    /**
     * 盘点单号
     */
    private String adorder;

    /**
     * 盘点说明
     */
    private String adexalpain;

    /**
     * 盘点状态
     */
    private Integer isValid;

    /**
     * 品牌开始日期
     */
    private String begindate;

    /**
     * 盘点结束日期
     */
    private String enddate;

    private static final long serialVersionUID = 1L;
}