package cn.itcast.post.Service.Impl;

import cn.itcast.post.Mapper.CommentMapper;
import cn.itcast.post.Service.CommentService;
import cn.itcast.post.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public boolean addComment(Comment comment){
        return commentMapper.insert(comment)>0;
    }

    @Override
    public boolean deleteComment(Long CommentId){
        return commentMapper.deleteById(CommentId)>0;
    }

    @Override
    public List<Comment> selectCommentByUser(Long userId){
        return commentMapper.selectCommentByUser(userId);
    }

    @Override
    public Comment selectCommentById(Long CommentId){
        return commentMapper.selectById(CommentId);
    }

    @Override
    public boolean updateComment(Comment Comment){
        return commentMapper.updateById(Comment)>0;
    }
}
