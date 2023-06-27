package cn.itcast.user.mapper;

import cn.itcast.user.pojo.Relationship;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RelationshipMapper extends BaseMapper<Relationship> {
    //查找此用户的粉丝
    @Select("select fan_id from relationship where user_id = #{userId}")
    List<Long> selectFanByUserId(@Param("userId") Long userId);

    @Select("select user_id from relationship where fan_id = #{fanId}")
    List<Long> selectLikeById(@Param("FanId") Long fanId);

    @Delete("delete from relationship where userId = #{userId} and fan_id = #{fanId}")
    boolean deleteRelationship(@Param("userId")Long userId, @Param("fanId") Long fanId);
}
