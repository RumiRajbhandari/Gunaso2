package com.example.user.gunasofinal.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.gunasofinal.FirstProject;
import com.example.user.gunasofinal.R;
import com.example.user.gunasofinal.SecondProject;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        listView = (ListView) view.findViewById(R.id.list1);
        ArrayAdapter<String> madapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.projects));
        // return view;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent aboutcsit = new Intent(getActivity(), FirstProject.class);
                    // aboutcsit.putExtra("listname",listView.getItemAtPosition(i).toString());
                    startActivity(aboutcsit);
                }
                else if (i == 1) {
                    Intent pakistan = new Intent(getActivity(), SecondProject.class);
                    //pakistan.putExtra("listname",listView.getItemAtPosition(i).toString());
                    startActivity(pakistan);
                }
            }
        });
        listView.setAdapter(madapter);
        return view;
}

//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
//                R.array.projects, android.R.layout.simple_list_item_1);
//    }
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Intent intent=new Intent(getActivity(),FirstProject.class);
//        startActivity(intent);
//    }
}

