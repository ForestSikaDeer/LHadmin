package com.jz.mapper.user;

import com.jz.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM user")
    public User login(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
