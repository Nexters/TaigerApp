package com.nexters.taigerapp.ui.meeting.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.ui.meeting.Meeting;
import com.nexters.taigerapp.ui.meeting.MeetingLocation;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import lombok.Data;
import lombok.Setter;

public class MeetingItemAdapter extends RecyclerView.Adapter<MeetingItemAdapter.ViewHolder> {
    private final static DateFormat dateFormat = new SimpleDateFormat("hh:mm a");

    @Setter
    private List<Meeting> meetings;
    private Context context;
    private MeetingPresenter presenter;

    public MeetingItemAdapter(Context context, List<Meeting> meetings, MeetingPresenter presenter) {
        this.context = context;
        this.meetings = meetings;
        this.presenter = presenter;
    }

    @Override
    public MeetingItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_meeting_item, null);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MeetingItemAdapter.ViewHolder holder, int position) {
        final Meeting meeting = meetings.get(position);
        holder.setMeeting(meeting);

        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showMeetingDetail(meeting.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    @Data
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        private TextView tvMeetingClock;
        private ImageView ivMeetingProfile1, ivMeetingProfile2, ivMeetingProfile3;
        private TextView tvMeetingTitle;
        private ImageView ivMeetingBackground;

        public ViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            tvMeetingClock = (TextView) itemView.findViewById(R.id.tc_meeting_clock);
            ivMeetingProfile1 = (ImageView) itemView.findViewById(R.id.iv_meeting_profile_1);
            ivMeetingProfile2 = (ImageView) itemView.findViewById(R.id.iv_meeting_profile_2);
            ivMeetingProfile3 = (ImageView) itemView.findViewById(R.id.iv_meeting_profile_3);
            ivMeetingBackground = (ImageView) itemView.findViewById(R.id.iv_meeting_bg);
        }

        public void setMeeting(Meeting meeting) {
            MeetingLocation meetingLocation = meeting.getDeparture();

            tvMeetingClock.setText(dateFormat.format(meetingLocation.getDate()));

            Picasso.with(itemView.getContext()).load(R.drawable.kakao_default_profile_image)
                    .transform(new CropCircleTransformation())
                    .into(ivMeetingProfile1);
            Picasso.with(itemView.getContext()).load(R.drawable.kakao_default_profile_image)
                    .transform(new CropCircleTransformation())
                    .into(ivMeetingProfile2);
            Picasso.with(itemView.getContext()).load(R.drawable.kakao_default_profile_image)
                    .transform(new CropCircleTransformation())
                    .into(ivMeetingProfile3);

            Picasso.with(itemView.getContext()).load(R.drawable.bg_image_01)
                    .transform(new BlurTransformation(itemView.getContext(), 25))
                    .into(ivMeetingBackground);
        }
    }
}
