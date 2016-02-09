package com.nexters.taigerapp.ui.meeting.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.ui.meeting.Meeting;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import lombok.Data;
import lombok.Setter;

public class MeetingItemAdapter extends RecyclerView.Adapter<MeetingItemAdapter.ViewHolder> {
    @Setter
    private List<Meeting> meetings;
    private Context context;
    private MeetingPresenter presenter;

    public MeetingItemAdapter(Context context, List<Meeting> meetings) {
        this.context = context;
        this.meetings = meetings;
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


    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    @Data
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        private DateFormat dateFormat;
        private TextClock tcMeetingClock;
        private ImageView ivMeetingProfile1, ivMeetingProfile2, ivMeetingProfile3;
        private TextView tvMeetingTitle;
        private ImageView ivMeetingBackground;

        public ViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            tcMeetingClock = (TextClock) itemView.findViewById(R.id.tc_meeting_clock);
            dateFormat = new SimpleDateFormat(String.valueOf(tcMeetingClock.getFormat12Hour()));
            ivMeetingProfile1 = (ImageView) itemView.findViewById(R.id.iv_meeting_profile_1);
            ivMeetingProfile2 = (ImageView) itemView.findViewById(R.id.iv_meeting_profile_2);
            ivMeetingProfile3 = (ImageView) itemView.findViewById(R.id.iv_meeting_profile_3);
            ivMeetingBackground = (ImageView) itemView.findViewById(R.id.iv_meeting_background);
        }

        public void setMeeting(Meeting meeting) {
            tcMeetingClock.setText(dateFormat.format(meeting.getDepartureDate()));

            Picasso.with(itemView.getContext()).load(R.drawable.kakao_default_profile_image)
                    .transform(new CropCircleTransformation())
                    .into(ivMeetingProfile1);
            Picasso.with(itemView.getContext()).load(R.drawable.kakao_default_profile_image)
                    .transform(new CropCircleTransformation())
                    .into(ivMeetingProfile2);
            Picasso.with(itemView.getContext()).load(R.drawable.kakao_default_profile_image)
                    .transform(new CropCircleTransformation())
                    .into(ivMeetingProfile3);

            Picasso.with(itemView.getContext()).load(R.drawable.kakao_default_profile_image)
                    .transform(new BlurTransformation(itemView.getContext(), 25, 2))
                    .into(ivMeetingBackground);
        }
    }
}
