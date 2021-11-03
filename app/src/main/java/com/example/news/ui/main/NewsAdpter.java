package com.example.news.ui.main;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.news.R;
import com.example.news.pojo.NewsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdpter extends RecyclerView.Adapter<NewsAdpter.NewsViewHolder>{
    private List<NewsModel> list=new ArrayList<>();


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
        final NewsModel current=list.get(position);
        holder.name.setText(current.getTitle());
        holder.desc.setText(current.getDescription());
        Picasso.with(holder.itemView.getContext()).load(current.getUrlToImage()).into(holder.img);

    }


    @Override
    public int getItemCount() {
        return list.size();

    }
    public void setList(List<NewsModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    static class NewsViewHolder extends RecyclerView.ViewHolder{
        private TextView name,desc;
        private ImageView img;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            desc=itemView.findViewById(R.id.des);
           img=itemView.findViewById(R.id.img);


        }
    }
}
