package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;



public class myadapter  extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {

    public myadapter(@NonNull  FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull  myviewholder holder, int position, @NonNull  model model) {
        holder.h_name.setText(model.getHostel_Name());
        holder.h_address.setText(model.getAadhaar_Hostel_Address());
        holder.h_city.setText(model.getCity());
        holder.h_price.setText(model.getPrice());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img1;
        TextView h_name,h_address,h_city,h_price;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            h_name = itemView.findViewById(R.id.h_name);
            h_address = itemView.findViewById(R.id.h_address);
            h_city = itemView.findViewById(R.id.h_city);
            h_price = itemView.findViewById(R.id.h_price);

        }
    }

}
