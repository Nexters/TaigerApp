package com.nexters.taigerapp.ui.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nexters.taigerapp.R;

import java.util.List;

import lombok.Data;
import lombok.Setter;

public class UserHistoryItemAdapter extends RecyclerView.Adapter<UserHistoryItemAdapter.ViewHolder> {
    @Setter
    private List<UserHistory> userHistories;
    private Context context;

    public UserHistoryItemAdapter(Context context, List<UserHistory> userHistories) {
        this.context = context;
        this.userHistories = userHistories;
    }

    @Override
    public UserHistoryItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_user_history_item, null);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(UserHistoryItemAdapter.ViewHolder holder, int position) {
        UserHistory userHistory = userHistories.get(position);
        holder.setUserHistory(userHistory);
    }

    @Override
    public int getItemCount() {
        return userHistories.size();
    }

    @Data
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHistoryTitle;
        private RatingBar rbRank;

        public ViewHolder(View itemView) {
            super(itemView);

            tvHistoryTitle = (TextView) itemView.findViewById(R.id.tv_history_title);
            rbRank = (RatingBar) itemView.findViewById(R.id.rb_rank);
        }

        public void setUserHistory(UserHistory userHistory) {
            tvHistoryTitle.setText(userHistory.getTitle());
            rbRank.setRating(userHistory.getRank());
        }
    }
}
