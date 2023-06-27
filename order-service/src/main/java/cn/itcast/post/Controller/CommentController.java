package cn.itcast.post.Controller;

import cn.itcast.post.Service.CommentService;
import cn.itcast.post.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @CrossOrigin
    @PostMapping
    public Result AddComment(@RequestBody Comment comment){
        boolean flag = commentService.addComment(comment);
        return new Result(flag ? Code.ADD_OK : Code.ADD_ERR, flag ? comment.getCommentId() : false, flag ? "添加成功！" : "添加失败！" );
    }

    @CrossOrigin
    @DeleteMapping
    public Result deleteCommentById(@RequestParam Long commentId){
        boolean flag = commentService.deleteComment(commentId);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag,flag ? "删除成功！" : "删除失败！" );
    }

    @CrossOrigin
    @GetMapping
    public Result getCommentById(@RequestParam Long commentId){
        Comment comment = commentService.selectCommentById(commentId);
        boolean flag = comment.equals(null) ? false : true;
        if(flag){
            return new Result(Code.SELECT_OK, comment, "查找成功！");
        } else {
            return new Result(Code.SELECT_ERR, comment, "查找失败");
        }
    }

    @CrossOrigin
    @GetMapping(value = "/1")
    public Result getCommentByUser(@RequestParam Long id){
        List<Comment> comments = commentService.selectCommentByUser(id);
        boolean flag = comments.isEmpty() ? false : true;
        if(flag){
            return new Result(Code.SELECT_OK, comments, "查找成功！");
        } else {
            return new Result(Code.SELECT_ERR, comments, "查找失败");
        }
    }

    @CrossOrigin
    @PutMapping
    public Result updateComment(Comment comment){
        if(commentService.updateComment(comment)){
            return new Result(Code.UPDATE_OK, "更新成功！");
        } else {
            return new Result(Code.UPDATE_ERR, "更新失败");
        }
    }
}
