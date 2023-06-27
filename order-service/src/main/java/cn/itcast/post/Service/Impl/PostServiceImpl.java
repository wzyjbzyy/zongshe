package cn.itcast.post.Service.Impl;

import cn.itcast.post.Mapper.PostMapper;
import cn.itcast.post.Service.PostService;
import cn.itcast.post.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    public boolean addPost(Post post){
        return postMapper.insert(post)>0;
    }

    @Autowired
    public boolean deletePost(Long postId){
        return postMapper.deleteById(postId)>0;
    }

    @Autowired
    public List<Post> selectPostByUser(Long userId){
        return postMapper.selectPostByUser(userId);
    }

    @Autowired
    public Post selectPostById(Long postId){
        return postMapper.selectById(postId);
    }

    @Autowired
    public boolean updatePost(Post post){
        return postMapper.updateById(post)>0;
    }
}
