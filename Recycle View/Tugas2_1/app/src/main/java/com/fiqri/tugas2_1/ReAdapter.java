package com.fiqri.tugas2_1;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReAdapter extends RecyclerView.Adapter<ReAdapter.ReViewHolder> implements Filterable {

    //membuat atau memanggil sebuah fungsi

    Context mContext;
    List<Reitem> mData;
    List<Reitem> mDatafiltered;
    boolean isDark = false;

    public ReAdapter(Context mContext, List<Reitem> mData, boolean isDark) {
        this.mContext = mContext;
        this.mData = mData;
        this.isDark = isDark;
        this.mDatafiltered = mData;
    }

    public ReAdapter(Context mContext, List<Reitem> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mDatafiltered = mData;
    }
    //membuat sebuah kelas
    @NonNull
    @Override
    public ReViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item,viewGroup,false);
        return new ReViewHolder(layout);
    }

    //membuat sebuah method dan ini adalah turunan dari class dari interface
    @Override
    public void onBindViewHolder(@NonNull ReViewHolder reViewHolder, int position) {

        //menambahkan animasi untuk foto profil
        reViewHolder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
        //menambahkan animasi untuk whole card atau container
        reViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));

        //mengikat sebuah data
        reViewHolder.tv_title.setText(mDatafiltered.get(position).getTitle());
        reViewHolder.tv_content.setText(mDatafiltered.get(position).getContent());
        reViewHolder.tv_date.setText(mDatafiltered.get(position).getDate());
        reViewHolder.img_user.setImageResource(mDatafiltered.get(position).getUserPhoto());

    }
    //turunan dari class dari interface
    @Override
    public int getItemCount() {
        return mDatafiltered.size();
    }
    // turunan dari class dari interface
    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {  //method

                String Key = constraint.toString();
                if (Key.isEmpty()) {                //sebuah kondisi

                    mDatafiltered = mData ;

                }
                else {
                    List<Reitem> lstFiltered = new ArrayList<>();
                    for (Reitem row : mData) {

                        if (row.getTitle().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);
                        }

                    }

                    mDatafiltered = lstFiltered;

                }


                FilterResults filterResults = new FilterResults();
                filterResults.values= mDatafiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {   //membuat sebuah method


                mDatafiltered= (List<Reitem>) results.values;
                notifyDataSetChanged();

            }
        };

    }

    //membuat sebuah kelas baru
    public class ReViewHolder extends RecyclerView.ViewHolder {

        //membuat atau memanggil sebuah fungsi
        TextView tv_title,tv_content,tv_date;
        ImageView img_user;
        RelativeLayout container;

        public ReViewHolder(@NonNull View itemView) {       //turunan dari kelas sebelumnya
            super(itemView);
            container = itemView.findViewById(R.id.container);
            tv_title = itemView.findViewById(R.id.title);
            tv_content = itemView.findViewById(R.id.description);
            tv_date = itemView.findViewById(R.id.date);
            img_user = itemView.findViewById(R.id.img_user);


            if (isDark) {           //sebuah kondisi
                setDarkTheme();
            }

        }

        private void setDarkTheme() {       //sebuah method

            container.setBackgroundResource(R.drawable.card_bg_dark);

        }



    }
}

