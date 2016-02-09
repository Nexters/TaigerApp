package com.nexters.taigerapp.ui.comment;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    private String name;
    private String content;
    private String profileImagePath;
    private Date createdAt;
}
