package com.nexters.taigerapp.ui.departure;

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

import jp.wasabeef.picasso.transformations.BlurTransformation;
import lombok.Data;
import lombok.Setter;

public class DepartureItemAdapter extends RecyclerView.Adapter<DepartureItemAdapter.ViewHolder> {
    @Setter
    private List<Departure> departures;
    private Context context;
    private DeparturePresenter presenter;

    public DepartureItemAdapter(Context context, List<Departure> departures, DeparturePresenter presenter) {
        this.departures = departures;
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_departure_item, null);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Departure departure = departures.get(position);
        holder.setDeparture(departure);

        holder.getItemView().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                presenter.saveDeparture(departure);
                presenter.saveUser();
            }
        });
    }

    @Override
    public int getItemCount() {
        return departures.size();
    }

    @Data
    public class ViewHolder extends RecyclerView.ViewHolder{
        private View itemView;

        private TextView tvDepartMeetingCount;
        private TextView tvDepartDestUserCount;
        private TextView tvDepartName;
        private ImageView ivDepartBackground;

        public ViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            tvDepartMeetingCount = (TextView) itemView.findViewById(R.id.tv_depart_meeting_count);
            tvDepartDestUserCount = (TextView) itemView.findViewById(R.id.tv_depart_dest_user_count);
            tvDepartName = (TextView) itemView.findViewById(R.id.tv_depart_name);
            ivDepartBackground = (ImageView) itemView.findViewById(R.id.iv_depart_bg);
        }

        public void setDeparture(Departure departure){
            tvDepartMeetingCount.setText(String.valueOf(departure.getDepartMeetingCount()));
            tvDepartDestUserCount.setText(String.valueOf(departure.getDepartDestUserCount()));
            tvDepartName.setText(departure.getDepartName());
            // TODO change Image
            Picasso.with(itemView.getContext()).load(R.drawable.bg_image_01)
                    .transform(new BlurTransformation(itemView.getContext(), 25, 2))
                    .into(ivDepartBackground);
        }
    }
}
