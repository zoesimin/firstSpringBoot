package myfirstlogin.login.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //自动生成get 、set方法
@AllArgsConstructor //全参构造方法注解
@NoArgsConstructor  //无参构造方法注解
public class User {
    //数据库主键
    private long id;
    //用户名，不能重复
    private String accountNumber;
    //用户密码
    private String password;
    //手机号
    private String phone;

}
