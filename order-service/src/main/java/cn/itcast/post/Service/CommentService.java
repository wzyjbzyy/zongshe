package cn.itcast.post.Service;

import cn.itcast.post.pojo.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CommentService {
    public boolean addComment(Comment comment);

    public boolean deleteComment(Long CommentId);

    public List<Comment> selectCommentByUser(Long userId);

    public Comment selectCommentById(Long CommentId);

    public boolean updateComment(Comment Comment);
}
