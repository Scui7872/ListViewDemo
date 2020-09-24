package com.example.listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Goods> goods;
    private OnItemClickListener onItemClickListener;

    public RecyclerAdapter(List<Goods> goods) {
        this.goods = goods;
    }

    public interface OnItemClickListener {
        void onItemClick(View view,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view  = View.inflate(parent.getContext(),R.layout.item_list,null);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Goods good = goods.get(position);
        holder.tvTitle.setText(good.getTitle());
        holder.tvPrice .setText(good.getPrice());
        holder.ivPic.setBackgroundResource(good.getIcon());
        if(onItemClickListener !=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return goods.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvPrice;
        ImageView ivPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPrice = itemView.findViewById(R.id.tv_price);
            ivPic = itemView.findViewById(R.id.iv_pic);
        }
    }
}
