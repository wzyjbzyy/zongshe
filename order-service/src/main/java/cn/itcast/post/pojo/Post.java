package cn.itcast.post.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class Post {
    private Long postId;
    private Long userId;
    private String postTitle;
    private Date createTime;
    private Date updateTime;
}