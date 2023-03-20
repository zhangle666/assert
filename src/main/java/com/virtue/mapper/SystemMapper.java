package com.virtue.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virtue.pojo.Perms;
import com.virtue.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
public interface SystemMapper extends BaseMapper<User> {


    int register(User user);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
   User  findByUserName(String username);

    /**
     * 根据用户名查询角色
     * @param username
     * @return
     */

    User findRolesByUserName(String username);

    /**
     * 根据角色查询权限
     * @param id
     * @return
     */
    List<Perms> findPermsByRole(String id);

    /**
     * 查询用户是否存在
     * @param confirmCode
     * @return
     */
    @Select("select email,activation_time from user where confirm_code=#{confirmCode} and is_valid=0")
   User  selectUserByConfirmCode(@Param("confirmCode") String confirmCode);

    /**
     * 修改用户的状态
     * @return
     */
    @Update("update user set is_valid=1 where confirm_code=#{confirmCode}")
  int  updateUserByConfirmCode(@Param("confirmCode") String confirmCode);
    @Select("select jobid,username,dept from user")
    List<User> findUserBasic();


        User selectByJobid(String jobid);
}
