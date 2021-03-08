package myfirstlogin.login.Repository;

import myfirstlogin.login.Model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
 *
 * 需要注意的是：这个接口中不可以定义同名的方法，因为会生成相同的id
 * 也就是说这个接口是不支持重载的
 */
@Mapper
@Repository
public interface UserRepository { //操作数据库的都是接口类
    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value)若value与可变参数相同，注解可省略
     * 注解@Results 列名和字段名相同，注解可省略
     *
     * @param accountNumber
     * @return
     */
    @Select(value = "select u.account_number,u.password from user u where u.account_number=#{accountNumber}")
    @Results({@Result(property = "accountNumber", column = "account_number"),
            @Result(property = "password", column = "password")})
    public User findUserByName(@Param("accountNumber") String accountNumber) ;

    /**
     *注册 插入一条user记录
     *
     * @param
     * @return
     */
    @Select(value = "insert into user values(#{id},#{accountNumber},#{password},#{phone})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void register(User user) ;

    /**
     *
     * @param user
     * @return
     */
    //注意语法不敲错
    @Select(value = "select u.id from user u where u.account_number=#{accountNumber} && u.password=#{password}")
    public Long login(User user);



}
