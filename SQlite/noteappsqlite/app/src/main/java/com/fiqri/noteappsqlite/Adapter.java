package com.fiqri.noteappsqlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements Filterable {

    //membuat atau memanggil sebuah fungsi
    Context context;
    Activity activity;
    List<Model> notesList;
    List<Model> newList;
    private MyViewHolder holder;
    private int position;

    public Adapter(Context context, Activity activity, List<Model> notesList) {
        this.context = context;
        this.activity = activity;
        this.notesList = notesList;
        newList = new ArrayList<>(notesList);
    }

    @NonNull
    @Override
    //membuat sebuah method dan ini adalah turunan dari class dari interface
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    //membuat sebuah method dan ini adalah turunan dari class dari interface
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(notesList.get(position).getTitle());
        holder.description.setText(notesList.get(position).getDescription());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            //membuat sebuah method dan ini adalah turunan dari class dari interface
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateNotesActivity.class);

                intent.putExtra("title", notesList.get(position).getTitle());
                intent.putExtra("description", notesList.get(position).getDescription());
                intent.putExtra("id", notesList.get(position).getId());

                activity.startActivity(intent);
            }
        });
    }

    @Override
    //membuat sebuah method dan ini adalah turunan dari class dari interface
    public int getItemCount() {
        return notesList.size();
    }

    @Override
    //membuat sebuah method dan ini adalah turunan dari class dari interface
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        //membuat sebuah method dan ini adalah turunan dari class dari interface
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Model> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {       //sebuah kondisi
                filteredList.addAll(newList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Model item : newList) {    //sebuah kondisi
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }

            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        //membuat sebuah method dan ini adalah turunan dari class dari interface
        protected void publishResults(CharSequence constraint, FilterResults results) {
            notesList.clear();
            notesList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
    //membuat sebuah kelas
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        RelativeLayout layout;
        //membuat sebuah kelas
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);      //findbyviewid =(untuk fragmen yang menyediakan UI dalam layout aktivitas)
            description = itemView.findViewById(R.id.description);  //findbyviewid =(untuk fragmen yang menyediakan UI dalam layout aktivitas)
            layout = itemView.findViewById(R.id.note_layout);   //findbyviewid =(untuk fragmen yang menyediakan UI dalam layout aktivitas)
        }
    }


    public List<Model> getList() {
        return notesList;
    }
    //membuat sebuah method
    public void removeItem(int position) {
        notesList.remove(position);
        notifyItemRemoved(position);
    }
    //membuat sebyah method
    public void restoreItem(Model item, int position) {
        notesList.add(position, item);
        notifyItemInserted(position);
    }
}

