package com.lh.community.mapper;

import com.lh.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author lanhu
 * @create 2020-01-20 20:26
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void saveUser(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer creator);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(String accountId);

    @Update("update user set name = #{name}, token = #{token}, gmt_modified = #{gmtModified}, avatar_url = #{avatarUrl} where account_id = #{accountId}")
    void updateUser(User user);
}
