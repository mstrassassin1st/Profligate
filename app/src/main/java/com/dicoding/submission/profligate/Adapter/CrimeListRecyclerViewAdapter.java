package com.dicoding.submission.profligate.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dicoding.submission.profligate.Detail;
import com.dicoding.submission.profligate.Model.Crime;
import com.dicoding.submission.profligate.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class CrimeListRecyclerViewAdapter extends RecyclerView.Adapter<CrimeListRecyclerViewAdapter.MyViewHolder>
{
    private Context mContext;
    private List<Crime> mData;

    public CrimeListRecyclerViewAdapter(Context mContext, List<Crime> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.crime_list_item_template, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final int x = position;
        holder.tvListItemTitle.setText(mData.get(position).getTitle());
        Glide.with(mContext).load(mData.get(position).getImgURL()).into(holder.crc_imgView);
        int myNumber = mData.get(position).getPrice();
        String formattedNumber = NumberFormat.getNumberInstance(Locale.UK).format(myNumber);
        String priceMod = "Money wasted: Rp " + formattedNumber + ".00";
        holder.tvListItemPrice.setText(priceMod);
        holder.card_crime_list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Detail.class);
                intent.putExtra("index", x);
                intent.putExtra("name", mData.get(position).getTitle());
                intent.putExtra("wasted", mData.get(position).getPrice());
                intent.putExtra("picture", mData.get(position).getImgURL());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvListItemTitle;
        TextView tvListItemPrice;
        CardView card_crime_list_item;
        CircleImageView crc_imgView;

        public MyViewHolder(View itemView){
            super(itemView);
            tvListItemTitle = itemView.findViewById(R.id.tvListItemTitle);
            tvListItemPrice = itemView.findViewById(R.id.tvListItemPrice);
            card_crime_list_item = itemView.findViewById(R.id.card_crime_list_item);
            crc_imgView = itemView.findViewById(R.id.crc_imgView);
        }
    }
}
