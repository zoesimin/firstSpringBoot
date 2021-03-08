package myfirstlogin.login.Service;

import myfirstlogin.login.Model.Result;
import myfirstlogin.login.Model.User;
import myfirstlogin.login.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 注册
     *
     * @param user 参数封装
     * @return Result
     */
    public Result register(User user){
        Result result = new Result();
        result.setCode(-1);
        result.setDetail(null);
        try{
            User exitUser = userRepository.findUserByName(user.getAccountNumber());
            if(exitUser != null){
                result.setCode(-1);
                result.setMsg("该用户已存在");
            }else {
                result.setMsg("注册成功");
                result.setCode(200);
                result.setDetail(user);
                userRepository.register(user);
            }

        }catch(Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 登录
     *
     *
     */
    public Result login(User user) {
        Result result = new Result();
        result.setCode(-1);
        result.setDetail(null);
        try{
            Long userId = userRepository.login(user);
            result.setCode(-1);
            result.setDetail(null);
            if(userId == null){
                result.setCode(-1);
                result.setMsg("用户名或密码错误");
            }else {
                result.setCode(200);
                result.setMsg("登录成功");
                user.setId(userId);
                result.setDetail(user);
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}
