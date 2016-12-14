package com.dev4u.ntc.livesearchlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        editText = (EditText) findViewById(R.id.edsearch);
        initList();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(s.toString().equals("")){
//                    // reset listview
//                    initList();
//                } else {
//                    // perform search
//                    searchItem(s.toString());
//                }
                MainActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

//    public void searchItem(String textToSearch){
//        for(String item:items){
//            if(!item.contains(textToSearch)){
//                listItems.remove(item);
//            }
//        }
//        adapter.notifyDataSetChanged();
//    }

    public void initList() {
        items = new String[]{"Java", "JavaScript", "C#", "PHP", "С++", "Python", "C", "SQL", "Ruby", "Objective-C"};
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
    }
}
