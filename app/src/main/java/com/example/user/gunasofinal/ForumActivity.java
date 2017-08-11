package com.example.user.gunasofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.example.user.gunasofinal.adapter.ForumAdapter;
import com.example.user.gunasofinal.model.Complain;

import java.util.List;




public class ForumActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Complain> complain;
    private ForumAdapter adapter;
TextView tvUser;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        Intent intent=getIntent();
        Log.e("TAG", "onClick:2 ");
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        Backendless.initApp(getApplicationContext(),"F4C26AE7-9CA0-8CB8-FF49-D66D9F1C0D00", "9D8E4C70-E734-CAA5-FFFD-B69BAE068400");
        String whereClause = "";
        DataQueryBuilder dataQuery = DataQueryBuilder.create();
        dataQuery.setWhereClause( whereClause );

        Backendless.Persistence.of(Complain.class).find(new AsyncCallback<List<Complain>>() {
            @Override
            public void handleResponse(List<Complain> response) {
                // create a list for your data
                 complain= response;
                adapter = new ForumAdapter(complain);
                recyclerView.setAdapter(adapter);


                for (Complain complai:response
                     ) {
                    Log.e("TAG", "handleResponse: "+complai.toString() );

                }



            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("TAG", "handleFault: "+fault.toString() );

            }
        });


    }
}
