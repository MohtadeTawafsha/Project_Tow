package com.example.project_tow;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolde> {
    public Context context;
    public List<ListItems> dataList;
    private SharedPreferences prefs;
    private Gson mGson;

    private RecyclerInterface recyclerInterface;

    public MyAdapter(Context context, ArrayList<ListItems> dataList) {
        this.context = context;
        this.dataList = dataList;
        prefs = context.getSharedPreferences("123", Context.MODE_PRIVATE);
        mGson = new Gson();
    }


    private void saveDataToSharedPreferences() {
        SharedPreferences.Editor editor = prefs.edit();
        String json = mGson.toJson(dataList);
        editor.putString("123", json);
        editor.apply();
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ViewHolde(view, recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolde holder, int position) {
        ListItems item = dataList.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.image.setImageResource(item.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = holder.getAdapterPosition();

                Intent intent = new Intent(view.getContext(), MainActivity4.class);
                intent.putExtra("name", dataList.get(i).getName());
                intent.putExtra("des", dataList.get(i).getDescription());
                intent.putExtra("image", dataList.get(i).getImage());
                startActivity(view.getContext(), intent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolde extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView description;
        private ImageView image;

        public ViewHolde(@NonNull View itemView, RecyclerInterface recyclerInterface) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.des);
            image = itemView.findViewById(R.id.image);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    if (recyclerInterface != null) {
//
//                        int pos = getAdapterPosition();
//
//                        if (pos != RecyclerView.NO_POSITION) {
//
//                            recyclerInterface.onItemClick(pos);
//                        }
//                    }
//                }
//            });
        }
    }
}
