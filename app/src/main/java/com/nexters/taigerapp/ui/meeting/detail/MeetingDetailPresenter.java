package com.nexters.taigerapp.ui.meeting.detail;

import com.nexters.taigerapp.ui.comment.Comment;

public class MeetingDetailPresenter {
    private MeetingDetailActivity meetingDetailActivity;
    private MeetingDetailInteractor meetingDetailInteractor;

    public MeetingDetailPresenter(MeetingDetailActivity meetingDetailActivity) {
        this.meetingDetailActivity = meetingDetailActivity;
        this.meetingDetailInteractor = new MeetingDetailInteractor();
    }


    public void saveComment(String commentStr) {
        Comment comment = meetingDetailInteractor.saveComment(commentStr);
        meetingDetailActivity.refreshComment(comment);
    }
}
