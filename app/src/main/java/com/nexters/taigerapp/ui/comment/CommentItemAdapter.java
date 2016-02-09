package com.nexters.taigerapp.ui.comment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexters.taigerapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import lombok.Data;
import lombok.Setter;

public class CommentItemAdapter extends RecyclerView.Adapter<CommentItemAdapter.ViewHolder> {
    @Setter
    private List<Comment> comments;
    private Context context;

    public CommentItemAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public CommentItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_comment_item, null);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CommentItemAdapter.ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.setComment(comment);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void add(Comment comment) {
        comments.add(comment);
        // TODO?
    }

    @Data
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        private ImageView ivUserProfile;
        private TextView tvUserName;
        private TextView tvUserComment;

        public ViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            ivUserProfile = (ImageView) itemView.findViewById(R.id.iv_user_profile);
            tvUserName = (TextView) itemView.findViewById(R.id.tv_user_name);
            tvUserComment = (TextView) itemView.findViewById(R.id.tv_user_comment);
        }

        public void setComment(Comment comment) {
            if (comment.getProfileImagePath() != null) {
                Picasso.with(itemView.getContext()).load(comment.getProfileImagePath()).into(ivUserProfile);
            }

            tvUserName.setText(comment.getName());
            tvUserComment.setText(comment.getContent());
        }
    }
}
