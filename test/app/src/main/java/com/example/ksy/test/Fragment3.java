package com.example.ksy.test;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ium on 14. 2. 25.
 */
public class Fragment3 extends Fragment{


    private ArrayList<String>    list;
    private ListView             listview;
    private ArrayAdapter<String> adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_3, null);

        list = new ArrayList<String>();
        listview= (ListView) view.findViewById(R.id.listView);
        adapter =  new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        list.add("test1");
        list.add("test2");
        list.add("test3");


        adapter.notifyDataSetChanged();

        return view;
    }
}