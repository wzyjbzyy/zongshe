package cn.itcast.user.service.Impl;

import cn.itcast.user.pojo.BasicUser;
import cn.itcast.user.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    public boolean addUser(BasicUser userBasic);

    public boolean deleteUserById(Long id);

    public boolean updateUser(User user);

    public boolean updateBasicUser(BasicUser basicUser);

    public BasicUser selectBasicUserById(Long id);

    public User selectUserById(Long id);

    public BasicUser selectBasicUserByPhoneNum(String phoneNum);

    public List<Long> selectFans(Long userId);

    public List<Long> selectLikes(Long userId);

    public boolean addRelationship(Long userId, Long fanId);

    public boolean deleteRelationship(Long userId, Long fanId);
}
