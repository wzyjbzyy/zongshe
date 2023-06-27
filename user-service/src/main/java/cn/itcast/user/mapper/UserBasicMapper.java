package cn.itcast.user.mapper;

import cn.itcast.user.pojo.BasicUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserBasicMapper extends BaseMapper<BasicUser> {
    
    @Select("select * from user_basic where user_id = #{userId}")
    BasicUser SelectById(@Param("userId") Long userId);

    @Select("select * from user_basic where phone_num = #{phoneNum}")
    BasicUser SelectByPhoneNum(@Param("phone_num") String phoneNum);
}