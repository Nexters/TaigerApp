package com.nexters.taigerapp.ui.meeting.detail;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.collect.Lists;
import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.ToolbarActivity;
import com.nexters.taigerapp.ui.comment.Comment;
import com.nexters.taigerapp.ui.comment.CommentItemAdapter;
import com.nexters.taigerapp.ui.meeting.Meeting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MeetingDetailActivity extends ToolbarActivity implements View.OnClickListener {
    private static final DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    private Meeting meeting;

    private MeetingDetailPresenter presenter;

    private TextView tvCountTimer;

    private RecyclerView rvMeetingComment;
    private LinearLayoutManager linearLayoutManager;

    private List<Comment> comments;
    private CommentItemAdapter commentItemAdapter;

    private EditText etMeetingComment;
    private ImageView ivMeetingCommentAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_meeting_detail, getString(R.string.title_activity_meeting_detail));
        setupActionBar();
        presenter = new MeetingDetailPresenter(this);

        tvCountTimer = (TextView) findViewById(R.id.tv_count_timer);
        refreshCountTimer(60000);

        rvMeetingComment = (RecyclerView) findViewById(R.id.rv_meeting_comment);
        linearLayoutManager = new LinearLayoutManager(this);
        rvMeetingComment.setLayoutManager(linearLayoutManager);

        comments = getComments();
        commentItemAdapter = new CommentItemAdapter(this, comments);
        rvMeetingComment.setAdapter(commentItemAdapter);

        etMeetingComment = (EditText) findViewById(R.id.et_meeting_comment);

        ivMeetingCommentAdd = (ImageView) findViewById(R.id.iv_meeting_comment_add);
        ivMeetingCommentAdd.setOnClickListener(this);
    }

    private void setupActionBar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_pre32);
    }

    private void refreshView(Meeting meeting){
        setupActionBar(meeting.getDeparture().getName() + " > " + meeting.getDestination().getName());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_meeting_comment_add:
                presenter.saveComment(etMeetingComment.getText().toString());
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public List<Comment> getComments() {
        List<Comment> comments = Lists.newArrayList();

        Comment comment1 = new Comment("test", "testtest", null, new Date());
        comments.add(comment1);
        Comment comment2 = new Comment("test1", "testtest1", null, new Date());
        comments.add(comment2);
        Comment comment3 = new Comment("test2", "testtest2", null, new Date());
        comments.add(comment3);

        return comments;
    }

    public void refreshCountTimer(long millisInFuture) {
        new CountDownTimer(millisInFuture, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Date date = new Date(millisUntilFinished);
                tvCountTimer.setText(dateFormat.format(date));
            }

            @Override
            public void onFinish() {
                tvCountTimer.setText("finish");
            }
        }.start();
    }

    public void refreshComment(Comment comment) {
        commentItemAdapter.add(comment);
        etMeetingComment.setText("");
    }
}
