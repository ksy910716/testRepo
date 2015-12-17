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
        //View view = inflater.inflate(R.layout.activity_main, container, false);
        //TextView testId = (TextView) view.findViewById(R.id.testid);
        //testId.setText("3");

        /*ArrayList<String> al = new ArrayList<String>();
        al.add("test1");
        al.add("test2");
        al.add("test3");
        al.add("test4");
        al.add("test5");
        al.add("test6");
        al.add("test7");

        ArrayAdapter<String> Adapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,al);

        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(Adapter);*/

// inflater.inflate(R.layout.fragment_3, container, false);

        //View view = inflater.inflate(R.layout.fragment_1, container, false);
        //TextView tv = (TextView) view.findViewById(R.id.text1);
        //tv.setText("Fragment 1");

        //return view;

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