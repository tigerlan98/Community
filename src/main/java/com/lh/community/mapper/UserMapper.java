package com.lh.community.mapper;

import com.lh.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lanhu
 * @create 2020-01-20 20:26
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void saveUser(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
