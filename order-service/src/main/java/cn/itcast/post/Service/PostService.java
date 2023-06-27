package cn.itcast.post.Service;

import cn.itcast.post.pojo.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PostService {
    public boolean addPost(Post post);

    public boolean deletePost(Long postId);

    public List<Post> selectPostByUser(Long userId);

    public Post selectPostById(Long postId);

    public boolean updatePost(Post post);
}
