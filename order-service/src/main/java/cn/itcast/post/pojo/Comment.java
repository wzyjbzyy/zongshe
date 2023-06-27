package cn.itcast.post.pojo;

import lombok.Data;

@Data
public class Comment {
    private Long commentId;
    private Long userId;
    private String commentTime;
    private String content;
    private Long parentId;
}