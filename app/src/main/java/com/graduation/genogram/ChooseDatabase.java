package com.graduation.genogram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.graduation.genogram.db.Family;
import com.graduation.genogram.db.FirstNameDatabase;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class ChooseDatabase extends Fragment {
    private TextView textView;
    private Button addButton;
    private ListView listView;
    private ArrayAdapter<String>adapter;
    private List<String>dataList=new ArrayList<>();
    private FirstNameDatabase firstNameDatabase;
    private Family family;
    private List<FirstNameDatabase> firstNameDatabaseList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.choose_database,container,false);

        textView=view.findViewById(R.id.title_text);
        addButton=view.findViewById(R.id.add_button);
        listView= view.findViewById(R.id.list_view);

        adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        firstNameDatabaseList= LitePal.findAll(FirstNameDatabase.class);
        if(firstNameDatabaseList.size()==0)
            initDatabase();
        for (FirstNameDatabase fd:firstNameDatabaseList) {
            dataList.add(fd.getFirstName());
        }
        adapter.notifyDataSetChanged();
        listView.setSelection(0);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /***************
                 *
                 */
                Intent intent=new Intent(getActivity(),MainLayout.class);
                startActivity(intent);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*************
                 *
                 */
                Intent intent=new Intent(getActivity(),addDatabase.class);
                startActivity(intent);
                //getActivity().finish();
            }
        });
    }

    private void initDatabase() {
        Log.d("initDatabase","===============");
        firstNameDatabase=new FirstNameDatabase();
        firstNameDatabase.setFirstName("testName");
        firstNameDatabase.setPostscript("hh");
        firstNameDatabase.setId(1);
        firstNameDatabase.save();

        family=new Family();
        family.setId(1);
        family.setName("man");
        family.setSpouse("woman");
        family.setDatabaseId(1);
        family.setFather(0);
        family.save();

        family=new Family();
        family.setId(2);
        family.setName("man1");
        family.setSpouse("woman1");
        family.setDatabaseId(1);
        family.setFather(1);
        family.save();

        family=new Family();
        family.setId(3);
        family.setName("man2");
        family.setSpouse("woman2");
        family.setDatabaseId(1);
        family.setFather(1);
        family.save();
    }
}
