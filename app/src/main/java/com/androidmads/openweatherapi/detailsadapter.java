package com.androidmads.openweatherapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class detailsadapter extends RecyclerView.Adapter<detailsadapter.ViewHolder> {
    Context mContext;
    ArrayList<wather> list;

    public detailsadapter(Context mContext, ArrayList<wather> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View view=layoutInflater.inflate(R.layout.details,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull detailsadapter.ViewHolder holder, int i) {
        holder.city.setText(list.get(i).city);
        holder.temperature.setText(list.get(i).temperature);
        holder.pressure.setText(list.get(i).humidity);
        holder.humidity.setText(list.get(i).pressure);
        holder.wind.setText(list.get(i).wind_speed);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView city,wind,pressure,humidity,weather,temperature;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            city=itemView.findViewById(R.id.city);
            wind=itemView.findViewById(R.id.wind);
            temperature=itemView.findViewById(R.id.temperature);
            pressure=itemView.findViewById(R.id.pressure);
            humidity=itemView.findViewById(R.id.humidity);
        }
    }
}
