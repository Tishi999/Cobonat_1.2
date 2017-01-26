package com.kagssoft.cobonat.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kagssoft.cobonat.R;
import com.kagssoft.cobonat.fragments.Information;

import java.util.Collections;
import java.util.List;

/**
 * Created by sams on 1/26/2017.
 */

public class CobonAdapter extends RecyclerView.Adapter<CobonAdapter.MyViewHolder> {

    private  LayoutInflater inflater;
    List<Information>data= Collections.emptyList();

    public CobonAdapter(Context context , List<Information>data) {
        inflater=LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = inflater.inflate(R.layout.cusom_row,parent,false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current=data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
     class MyViewHolder extends  RecyclerView.ViewHolder {
         TextView title;
         ImageView icon ;

         public MyViewHolder(View itemView) {
             super(itemView);
             title= (TextView) itemView.findViewById(R.id.listText);
             icon = (ImageView) itemView.findViewById(R.id.list_Icon);
         }
     }
}
