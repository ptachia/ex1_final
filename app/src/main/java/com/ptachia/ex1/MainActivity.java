package com.ptachia.ex1;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MassageDetails.deleteMassageInterface {

    RecyclerView recyclerView;
    massageAdapter adapter;
    List<One_massage> massages;

    Button send;
    EditText massage;

    String new_massage;
    String new_time;
    int last_position;

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

        recyclerView.addOnItemTouchListener(new recycleViewTouchListemer(getApplicationContext(),
                recyclerView, new recycleViewClickListener()
        {
            @Override
            public void onLongClick(View view, int position)
            {
                new_massage = massages.get(position).getMassage();
                new_time = massages.get(position).getTimeStamp();
                last_position = position;
                Fragment mFragment = null;
                mFragment = new MassageDetails();
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.frag_on_main, mFragment).addToBackStack(null).commit();
            }
        }
        ));
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

    @Override
    public void onDeleteClicked()
    {
        if (last_position != -1)
        {
            adapter.getMassages().remove(last_position);
            adapter.notifyItemRemoved(last_position);
            adapter.notifyItemRangeChanged(last_position,adapter.getMassages().size());
            last_position = -1;
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public String getTime() {
        return new_time;
    }

    @Override
    public String getMsg() {
        return new_massage;
    }

//    @Override
//    public void onBackPressed(){
//        FragmentManager fm = getFragmentManager();
//        if (fm.getBackStackEntryCount() > 0) {
//            fm.popBackStack();
//        } else {
//            super.onBackPressed();
//        }
//    }
}
