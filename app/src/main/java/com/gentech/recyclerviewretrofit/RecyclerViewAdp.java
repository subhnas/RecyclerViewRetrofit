package com.gentech.recyclerviewretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdp extends RecyclerView.Adapter<RecyclerViewAdp.MyviewHolder> {

    Context context;
    List<ResponseArray> list;

    public RecyclerViewAdp(Context context, List<ResponseArray> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdp.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.recycler_adp_row,parent,false);
       MyviewHolder myviewHolder=new MyviewHolder(view);
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdp.MyviewHolder holder, int position) {

        ResponseArray responseArray= list.get(position);

        holder.applicantNameTvId.setText(responseArray.ApplicantName);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView applicantNameTvId;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            applicantNameTvId=itemView.findViewById(R.id.applicantNameTvId);


        }
    }
}
