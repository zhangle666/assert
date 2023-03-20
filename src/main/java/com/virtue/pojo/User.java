package com.virtue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {
    @TableId
    private String jobid;
    private String username;
    private String password;
    private String salt;
    private String gender;
    private Integer age;
    private String tel;
    private String address;
    private Integer isValid;
    private LocalDateTime activationTime;
    private Double salary;
    private String confirmCode;
    private String email;
    private String dename;
    private String photo;
    private String details;
    @TableField(exist = false)
    private List<Role> roles;
}
