package cn.itcast.user.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class BasicUser {
    private Long userId;
    private String uname;
    private String nickname;
    private String password;    //通过哈希加密存储
    private Integer age;
    private String address;
    private String gender;
    private String phoneNum;
    private Date birthday;
    private Date accountSince;   //账户创建时间
    private Integer followNum;  //粉丝数
    private Integer likeNum;    //关注数
    private Integer starNum;    //获赞数
}