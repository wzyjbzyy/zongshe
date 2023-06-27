package cn.itcast.user.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Relationship {
    private Long relationshipId;
    private Long userId;
    //关注此用户的id
    private Long FanId;
    private Date startTime;
}
