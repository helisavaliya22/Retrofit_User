package com.example.retrofit_user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.ViewHolder> {

    MainActivity mainActivity;
    ArrayList<Model_Class> modellist;

    public Recycler_Adapter(MainActivity mainActivity, ArrayList<Model_Class> modellist) {
        this.mainActivity = mainActivity;
        this.modellist = modellist;
    }

    @NonNull
    @Override
    public Recycler_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.recycler_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Adapter.ViewHolder holder, int position) {
        holder.name.setText(modellist.get(position).getName());
        holder.street.setText(modellist.get(position).getAddress());
        holder.lat.setText(modellist.get(position).getLat());
        holder.lng.setText(modellist.get(position).getLng());
    }

    @Override
    public int getItemCount() {
        return modellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,street,lat,lng;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            street = itemView.findViewById(R.id.item_street);
            lat = itemView.findViewById(R.id.item_lat);
            lng = itemView.findViewById(R.id.item_lng);
        }
    }
}
