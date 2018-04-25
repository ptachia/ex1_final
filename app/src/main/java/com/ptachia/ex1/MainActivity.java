package com.ptachia.ex1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    massageAdapter adapter;
    List<One_massage> massages;

    Button send;
    EditText massage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        massages = new ArrayList<>();
        recyclerView = findViewById(R.id.chat);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new massageAdapter(massages);
        recyclerView.setAdapter(adapter);


        send = findViewById(R.id.send);
        massage = findViewById(R.id.massage);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty((massage.getText()))){
                    Toast.makeText(MainActivity.this, "must enter massage", Toast.LENGTH_LONG).show();
                    return;
                }
                One_massage new_massage = new One_massage(massage.getText().toString());
                adapter.addMassage(new_massage);
                massage.setText("");

            }
        });

    }


}
