package cn.itcast.post.Mapper;

import cn.itcast.post.pojo.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<Post> {
    @Select("select * from post where user_id = #{userId}")
    public List<Post> selectPostByUser(@Param("userId") Long userId);
}
