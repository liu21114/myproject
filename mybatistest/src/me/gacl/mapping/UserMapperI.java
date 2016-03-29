 package me.gacl.mapping;

import java.util.List;
import me.gacl.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author gacl
 * 定义sql映射的接口，使用注解指明方法要执行的SQL
 */
public interface UserMapperI {

    //使用@Insert注解指明add方法要执行的SQL
    @Insert("insert into users(name, age) values(#{name}, #{age})")
    public int add(User user);
    
    //使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from users where id=#{id}")
    public int deleteById(int id);
    
    //使用@Update注解指明update方法要执行的SQL
    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    public int update(User user);
    
    //使用@Select注解指明getById方法要执行的SQL
    @Select("select * from users where id=#{id}")
    public User getById(int id);
    
    //使用@Select注解指明getAll方法要执行的SQL
    @Select("select * from users")
    public List<User> getAll();
}