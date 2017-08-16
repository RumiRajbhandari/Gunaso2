package com.example.user.gunasofinal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.DataQueryBuilder;
import com.backendless.persistence.QueryOptions;
import com.example.user.gunasofinal.R;
import com.example.user.gunasofinal.adapter.ForumAdapter;
import com.example.user.gunasofinal.model.Complain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 7/24/17.
 */
public class ForumFragment extends Fragment {
    Button btn_post;
    private RecyclerView recyclerView;
    private List<Complain> complain;
    private ForumAdapter adapter;

    View mView;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.activity_forum, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e("TAG", "onClick:2 ");
        btn_post=(Button)view.findViewById(R.id.btn_post);
        recyclerView = (RecyclerView)view.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        Backendless.initApp(this.getContext(),"F4C26AE7-9CA0-8CB8-FF49-D66D9F1C0D00", "9D8E4C70-E734-CAA5-FFFD-B69BAE068400");
        String whereClause = "";
        DataQueryBuilder dataQuery = DataQueryBuilder.create();
        dataQuery.setWhereClause( whereClause );

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "onClick: post" );
            }
        });


        Backendless.Persistence.of(Complain.class).find(new AsyncCallback<List<Complain>>() {
            @Override
            public void handleResponse(List<Complain> response) {
                // create a list for your data
                complain= response;
                adapter = new ForumAdapter(complain,getContext());
                recyclerView.setAdapter(adapter);
                for (Complain complai:response
                        ) {
                    Log.e("TAG", "handleResponse: "+complai.toString() );

                }


                //Log.e("TAG", "onClick:2 "+response.get(0).toString()+"/n"+response.get(1).toString() );



            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("TAG", "handleFault: "+fault.toString() );

            }
        });


    }
}
