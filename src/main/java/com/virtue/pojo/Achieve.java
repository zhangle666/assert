package com.virtue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("achieve")
public class Achieve implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer acid;
    private String acnub;
    private String acname;
    private Integer isValid;
    private String actime;

}
