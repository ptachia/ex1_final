package com.ptachia.ex1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class massageAdapter extends RecyclerView.Adapter<massageAdapter.massageViewHolder> {
//    private Context mCtx;
    private List<One_massage> massages;

    public List<One_massage> getMassages() {
        return massages;
    }

    public massageAdapter(List<One_massage> massages) {
        this.massages = massages;
    }

    public void removeOneMsg(int position){
        massages.remove(position);
    }

    public void addMassage(One_massage new_massage){
        massages.add(new_massage);
        notifyItemInserted(massages.size()-1);
    }

    @NonNull
    @Override
    public massageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.one_massage, parent, false);
        massageViewHolder holder = new massageViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull massageViewHolder holder, int position) {
        One_massage massage = massages.get(position);
        holder.massage.setText(massage.getMassage());
        holder.myname.setText(R.string.my_name);
        holder.timestamp.setText(massage.getTimeStamp());
    }

    @Override
    public int getItemCount() {
        return massages.size();
    }


    class massageViewHolder extends RecyclerView.ViewHolder{

        TextView timestamp, myname, massage;

        public massageViewHolder(View itemView) {
            super(itemView);

            timestamp = itemView.findViewById(R.id.timestamp);
            myname = itemView.findViewById(R.id.name);
            massage = itemView.findViewById(R.id.massage);
        }
    }
}
