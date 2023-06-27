package cn.itcast.user.Controller;

import cn.itcast.user.pojo.BasicUser;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.Impl.UserService;
import cn.itcast.user.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public BasicUser queryByuserId(@RequestParam("userId") Long userId) {
        return userService.selectBasicUserById(userId);
    }

    @PostMapping("/sign")//注册
    public Result AddUser(@RequestBody BasicUser basicUser) {
        Date date = new Date(System.currentTimeMillis());
        basicUser.setAccountSince(date);
        boolean flag = false;
        String phone = basicUser.getPhoneNum();
        if (!(userService.selectBasicUserByPhoneNum(phone).equals(null))) {
            flag = userService.addUser(basicUser);
        }
        return new Result(flag ? Code.ADD_OK : Code.ADD_ERR, flag, flag ? "添加成功" : "添加失败");
    }

    @PostMapping("/login")
    public Result Login(@RequestParam String phoneNum, @RequestParam String password){
        BasicUser user = userService.selectBasicUserByPhoneNum(phoneNum);
        if(user.equals(null)){
            return new Result(Code.LOGIN_ERR, "不存在此用户");
        }
        if(!user.getPassword().equals(password)){
            return new Result(Code.DELETE_ERR, "密码错误");
        } else{
            return new Result(Code.LOGIN_OK, "登录成功");
        }
    }

    @DeleteMapping
    public Result DeleteUserById(@RequestParam("userId") Long userId){
        BasicUser basicUser = userService.selectBasicUserById(userId);
        if(basicUser.equals(null))
            return new Result(Code.DELETE_ERR, false, "用户不存在");
        else {
            userService.deleteUserById(userId);
            return new Result(Code.DELETE_OK, true, "删除成功");
        }
    }

    @PutMapping("/1")
    public Result UpdateBasicUser(@RequestBody BasicUser basicUser){
        boolean flag = userService.updateBasicUser(basicUser);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag,flag?"更新成功":"更新失败");
    }

    @PutMapping
    public Result UpdateUser(@RequestBody User user){
        boolean flag = userService.updateUser(user);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag,flag?"更新成功":"更新失败");
    }
}
