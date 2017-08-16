package com.example.user.gunasofinal.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.example.user.gunasofinal.ComplainActivity;
import com.example.user.gunasofinal.ComplainDetail;
import com.example.user.gunasofinal.R;
import com.example.user.gunasofinal.fragment.ComplainFragment;
import com.example.user.gunasofinal.model.Complain;

import java.util.List;

/**
 * Created by user on 7/24/2017.
 */

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ViewHolder>{

    private List<Complain> complain;
    Context context;

    public ForumAdapter(List<Complain> complain, Context context) {
        this.complain = complain;
        this.context=context;
    }

    @Override
    public ForumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_forum, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForumAdapter.ViewHolder holder, final int position) {
        holder.tv_date.setText(complain.get(position).getDatee());
        holder.tv_head.setText(complain.get(position).getHead());
        holder.tv_body.setText(complain.get(position).getBody());
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ComplainDetail.class);
                intent.putExtra("hello",complain.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return complain.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_date, tv_head, tv_body;
        LinearLayout linear;

        public ViewHolder(View view) {
            super(view);
            linear=(LinearLayout)view.findViewById(R.id.linear);
            tv_date = (TextView) view.findViewById(R.id.tv_date);
            tv_head = (TextView) view.findViewById(R.id.tv_head);
            tv_body = (TextView) view.findViewById(R.id.tv_body);

        }
    }
}