package com.vrishankgupta.jsoncheck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.vrishankgupta.jsoncheck.Model.myClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
   public static ListView textView;
   static ArrayList<myClass> array = new ArrayList<>();
   static myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.data);
        adapter = new myAdapter();
        textView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask task = new myTask();
                task.execute();
            }
        });
    }


    class myAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return array.size();
        }

        @Override
        public Object getItem(int position) {
            return array.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.detail, parent, false);
            }
            myClass item = (myClass) getItem(position);
            ((TextView) convertView.findViewById(R.id.name)).setText(item.getName());
            ((TextView) convertView.findViewById(R.id.course)).setText(item.getCourse());
            ((TextView) convertView.findViewById(R.id.branch)).setText(item.getBranch());
            ((TextView) convertView.findViewById(R.id.roll_number)).setText(item.getRoll_number() + "");
            ((TextView) convertView.findViewById(R.id.college)).setText(item.getCollege());
            return convertView;
        }
    }


}
