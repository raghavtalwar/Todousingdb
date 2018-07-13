package com.example.raghav.todousingdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<Task> al = new ArrayList<Task>();
    Button btn;
    TextView note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        final TaskAdapter taskAdapter = new TaskAdapter(this,al);
        rv.setAdapter(taskAdapter);

        note=findViewById(R.id.editext);


        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String notes =note.getText().toString();
                al.add(new Task(notes));
                taskAdapter.notifyDataSetChanged();
            }
        });

    }
}
