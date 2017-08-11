package com.example.user.gunasofinal.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.gunasofinal.R;
import com.example.user.gunasofinal.model.Complain;

import java.util.List;

/**
 * Created by user on 7/24/2017.
 */

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ViewHolder>{

    private List<Complain> complain;

    public ForumAdapter(List<Complain> complain) {
        this.complain = complain;
    }

    @Override
    public ForumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_forum, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForumAdapter.ViewHolder holder, int position) {
        holder.tv_date.setText(complain.get(position).getDatee());
        holder.tv_head.setText(complain.get(position).getHead());
        holder.tv_body.setText(complain.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return complain.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_date, tv_head, tv_body;

        public ViewHolder(View view) {
            super(view);

            tv_date = (TextView) view.findViewById(R.id.tv_date);
            tv_head = (TextView) view.findViewById(R.id.tv_head);
            tv_body = (TextView) view.findViewById(R.id.tv_body);

        }
    }
}
