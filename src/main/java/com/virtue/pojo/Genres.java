package com.virtue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("genre")
public class Genres implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer gid;
    private String genrecode;
    private String gname;
    private Integer isValid;
    private String createTime;


}
