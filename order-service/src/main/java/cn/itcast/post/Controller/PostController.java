package cn.itcast.post.Controller;

import cn.itcast.post.Service.PostService;
import cn.itcast.post.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @CrossOrigin
    @PostMapping
    public Result AddPost(@RequestBody Post post){
        boolean flag = postService.addPost(post);
        return new Result(flag ? Code.ADD_OK : Code.ADD_ERR, flag ? post.getPostId() : false, flag ? "添加成功！" : "添加失败！" );
    }

    @CrossOrigin
    @DeleteMapping
    public Result deletePostById(@RequestParam Long postId){
        boolean flag = postService.deletePost(postId);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag,flag ? "删除成功！" : "删除失败！" );
    }

    @CrossOrigin
    @GetMapping
    public Result getPostById(@RequestParam Long postId){
        Post post = postService.selectPostById(postId);
        boolean flag = post.equals(null) ? false : true;
        if(flag){
            return new Result(Code.SELECT_OK, post, "查找成功！");
        } else {
            return new Result(Code.SELECT_ERR, post, "查找失败");
        }
    }

    @CrossOrigin
    @GetMapping(value = "/1")
    public Result getPostByUser(@RequestParam Long id){
        List<Post> posts = postService.selectPostByUser(id);
        boolean flag = posts.isEmpty() ? false : true;
        if(flag){
            return new Result(Code.SELECT_OK, posts, "查找成功！");
        } else {
            return new Result(Code.SELECT_ERR, posts, "查找失败");
        }
    }

    @CrossOrigin
    @PutMapping
    public Result updatePost(Post post){
        if(postService.updatePost(post)){
            return new Result(Code.UPDATE_OK, "更新成功！");
        } else {
            return new Result(Code.UPDATE_ERR, "更新失败");
        }
    }
}
