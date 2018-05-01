package com.ptachia.ex1;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MassageDetails extends Fragment {

    TextView outhor;
    TextView about_outhor;
    TextView timestamp;
    TextView massageContent;
    Button delete_massage;
    One_massage massage;
    deleteMassageInterface listener;

    public void setMassage(One_massage massage) {
        this.massage = massage;
    }

    public interface deleteMassageInterface {
        public void onDeleteClicked();
        public String getTime();
        public String getMsg();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { // the container is the framelayout
        return inflater.inflate(R.layout.massage_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        massageContent = view.findViewById(R.id.the_massage2);
        timestamp = view.findViewById(R.id.time_stamp2);
        outhor = view.findViewById(R.id.ptachia_full_name);
        about_outhor = view.findViewById(R.id.about_ptachia);
        massageContent.setText(listener.getMsg());
        timestamp.setText(listener.getTime());
        outhor.setText(R.string.outhor);
        about_outhor.setText(R.string.about_outhor);
        delete_massage = view.findViewById(R.id.delete_massage);
        delete_massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDeleteClicked();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (deleteMassageInterface) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }
}

