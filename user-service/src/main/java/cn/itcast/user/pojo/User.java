package cn.itcast.user.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long userId;
    private String identifier;
    //发布动态总条数
    private Integer sum;
    private String avatarPath;
    private String email;
//    private Integer account_lvl;
//    private String status;
}
