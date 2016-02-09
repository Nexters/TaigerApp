package com.nexters.taigerapp.ui.meeting.detail;

import com.nexters.taigerapp.ui.comment.Comment;

import java.util.Date;

public class MeetingDetailInteractor {

    public Comment saveComment(String commentStr) {
        Comment comment = new Comment("test", commentStr, null, new Date());
        return comment;
    }
}
