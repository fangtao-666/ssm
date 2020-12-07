package come.test.dao;

import come.test.entity.Account;
import come.test.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IuserDao {
    @Select("select count(*) from user where (username,password) = (#{username},#{password})")
    int select(User user);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void insert(User user);

    //根据username和password修改密码
    @Update("update user set password= #{pwd} where username=#{username} and password=#{password};")
    void modify(@Param("username") String username,@Param("password") Double password ,@Param("pwd") Double pwd);

    //查询account信息列表
    @Select("select * from account")
    List<Account> findAll();

    //添加Account信息

    @Insert("insert into account(name,money) values(#{username},#{money})")
    void AddAccount(@Param("username") String username,@Param("money") Double money);

    //删除Account
    @Delete("delete from account where id = #{id}")
    void deleteAccount(@Param("id") int id);

    //批量删除Account数据
    @Delete("delete from account where id in #{param} ")
    void deleteAccountmore();
}
