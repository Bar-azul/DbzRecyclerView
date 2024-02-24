package com.example.recyclerveiw1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DBZ_RecyclerViewAdapter extends RecyclerView.Adapter<DBZ_RecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewinterface recyclerViewinterface;
    Context context;
    ArrayList<dbz_Model>dbzModels;

    public DBZ_RecyclerViewAdapter(Context context, ArrayList<dbz_Model>dbzModels
            ,RecyclerViewinterface recyclerViewinterface){

        this.context = context;
        this.dbzModels = dbzModels;
        this.recyclerViewinterface = recyclerViewinterface;
    }

    public void  setFilteredList(ArrayList<dbz_Model> filteredList){
        this.dbzModels = filteredList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public DBZ_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row,parent,false);

        return new DBZ_RecyclerViewAdapter.MyViewHolder(view, recyclerViewinterface);
    }

    @Override
    public void onBindViewHolder(@NonNull DBZ_RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.tvName.setText(dbzModels.get(position).getDbz_names());
        holder.tvrace.setText(dbzModels.get(position).getDbz_races());
        holder.tvpower.setText(dbzModels.get(position).getDbz_power());
        holder.imageview.setImageResource(dbzModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dbzModels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageview;
        TextView tvName,tvrace,tvpower;
        public MyViewHolder(@NonNull View itemView,RecyclerViewinterface recyclerViewinterface) {
            super(itemView);

            imageview = itemView.findViewById(R.id.imageView3);
            tvName = itemView.findViewById(R.id.textView);
            tvrace = itemView.findViewById(R.id.textView2);
            tvpower = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if(recyclerViewinterface != null) {

                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewinterface.onItemClick(pos);
                        }
                    }
                }


            });

        }
    }
}