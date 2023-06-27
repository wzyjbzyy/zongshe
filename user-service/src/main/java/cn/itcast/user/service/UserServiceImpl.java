package cn.itcast.user.service;

import cn.itcast.user.mapper.RelationshipMapper;
import cn.itcast.user.mapper.UserBasicMapper;
import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.BasicUser;
import cn.itcast.user.pojo.Relationship;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBasicMapper userBasicMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RelationshipMapper relationshipMapper;

    @Override
    public boolean addUser(BasicUser userBasic){
        boolean flag1 = userMapper.insert(null)>0;
        boolean flag2 = userBasicMapper.insert(userBasic)>0;
        return flag1 && flag2;
    }

    @Override
    public boolean deleteUserById(Long id) {
        boolean flag1 = userBasicMapper.deleteById(id)>0;
        boolean flag2 = userMapper.deleteById(id)>0;

        return flag1 && flag2;
    }

    @Override
    public boolean updateUser(User user){
        return userMapper.updateById(user)>0;
    }

    @Override
    public boolean updateBasicUser(BasicUser basicUser){
        return userBasicMapper.updateById(basicUser)>0;
    }

    @Override
    public BasicUser selectBasicUserById(Long id) {
        return userBasicMapper.SelectById(id);
    }

    @Override
    public User selectUserById(Long id){
        return userMapper.selectById(id);
    }

    @Override
    public BasicUser selectBasicUserByPhoneNum(String phoneNum){
        return userBasicMapper.SelectByPhoneNum(phoneNum);
    }



    //获取某用户的所有粉丝的id
    @Override
    public List<Long> selectFans(Long userId){
        return relationshipMapper.selectFanByUserId(userId);
    }

    @Override
    //获取某用户所有关注的id
    public List<Long> selectLikes(Long userId){
        return relationshipMapper.selectLikeById(userId);
    }

    @Override
    public boolean addRelationship(Long userId, Long fanId){
        Date date = new Date(System.currentTimeMillis());
        Relationship relationship = new Relationship();
        relationship.setUserId(userId);
        relationship.setFanId(fanId);
        relationship.setStartTime(date);
        return relationshipMapper.insert(relationship)>0;
    }

    //取关
    @Override
    public boolean deleteRelationship(Long userId, Long fanId){
        return relationshipMapper.deleteRelationship(userId, fanId);
    }
}