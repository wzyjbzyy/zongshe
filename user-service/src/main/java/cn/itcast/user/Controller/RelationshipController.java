package cn.itcast.user.Controller;

import cn.itcast.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/1")
    public Result selectFansByuserId(@RequestParam("userId") Long userId){
        List<Long> fans = userService.selectFans(userId);
        return new Result(Code.SELECT_OK, fans, "查找成功");
    }

    @GetMapping("/2")
    public Result selectLikesByuserId(@RequestParam("userId") Long userId){
        List<Long> likes = userService.selectLikes(userId);
        return new Result(Code.SELECT_OK, likes, "查找成功");
    }

    @PostMapping
    public Result addRelationship(@RequestParam("userId") Long userId, @RequestParam("fanId") Long fanId){
        boolean flag = userService.addRelationship(userId, fanId);
        return new Result(Code.ADD_OK, flag, "查找成功");
    }

    @DeleteMapping
    public Result DeleteRelationship(@RequestParam("userId") Long userId, @RequestParam("fanId") Long fanId){
        boolean flag = userService.deleteRelationship(userId, fanId);
        return new Result(Code.DELETE_OK, flag, "删除成功");
    }
}
