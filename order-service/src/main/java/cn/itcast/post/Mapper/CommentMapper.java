package cn.itcast.post.Mapper;

import cn.itcast.post.pojo.Comment;
import cn.itcast.post.pojo.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("select * from comment where user_id = #{userId}")
    public List<Comment> selectCommentByUser(@Param("userId") Long userId);
}
