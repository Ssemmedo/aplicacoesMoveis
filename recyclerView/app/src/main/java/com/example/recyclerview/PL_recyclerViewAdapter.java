package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PL_recyclerViewAdapter extends RecyclerView.Adapter<PL_recyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<LanguagesModel> languagesModels;


    public  PL_recyclerViewAdapter(Context context, ArrayList<LanguagesModel> languagesModels){
        this.context = context;
        this.languagesModels = languagesModels;

    }

    @NonNull
    @Override
    public PL_recyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new PL_recyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PL_recyclerViewAdapter.MyViewHolder holder, int position) {
        holder.txtProgrammingLanguage.setText(languagesModels.get(position).getProgrammingLanguage());
        holder.txtDescription.setText(languagesModels.get(position).getDescription());
        holder.imgEye.setImageResource(languagesModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return languagesModels.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgEye;
        TextView txtProgrammingLanguage;
        TextView txtDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgEye = itemView.findViewById(R.id.imgEye);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtProgrammingLanguage = itemView.findViewById(R.id.txtTitle);
        }
    }
}
