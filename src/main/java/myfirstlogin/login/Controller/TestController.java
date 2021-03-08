package myfirstlogin.login.Controller;

import myfirstlogin.login.Model.Result;
import myfirstlogin.login.Model.User;
import myfirstlogin.login.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Controller+@RequestBody
@RestController
//访问目录
@RequestMapping("/user")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @PostMapping(value = "/register")
//    public Result register(@RequestBody Map params){ //直接拿到前端给的json串，不用写对应的User类
//        System.out.println(user.getAccount_number());
//        Result register = userService.register(user);
//        return register;
//    }
    //加了@RequestBody，用postman测试使用raw-json的格式//要是用表单形式来提交数据，不需要用@RequestBody
    public Result register( User user){ //必须加@RequestBody，不然为null，接收不到json串数据（前提是提交数据的方式是application/json的形式）；
        System.out.println(user.getAccountNumber());
        Result register = userService.register(user);
        return register;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @PostMapping(value = "/login")
    public Result login( User user){
        return userService.login(user);
    }

}
