package com.nexters.taigerapp.ui.comment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexters.taigerapp.R;

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

    @Data
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setComment(Comment comment) {

        }
    }
}
