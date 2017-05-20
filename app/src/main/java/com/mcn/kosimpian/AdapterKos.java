package com.mcn.kosimpian;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class AdapterKos extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataKos> data= Collections.emptyList();
    DataKos current;
    int currentPos=0;


    // create constructor to innitilize context and data sent from MainActivity
    public AdapterKos(Context context, List<DataKos> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_kos, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }


    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        final DataKos current=data.get(position);
        myHolder.textKosName.setText(current.m_nama);
        myHolder.textKosAlamat.setText(current.m_alamat);
        myHolder.textKosHarga.setText( current.m_harga);

//        myHolder.cView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"posisi ; "+position,Toast.LENGTH_SHORT).show();
//            }
//        });
//        myHolder.textKosName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"posisi ; "+position,Toast.LENGTH_SHORT).show();
//            }
//        });
//        myHolder.textKosHarga.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"posisi ; "+position,Toast.LENGTH_SHORT).show();
//            }
//        });
//        myHolder.textKosAlamat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"posisi ; "+position,Toast.LENGTH_SHORT).show();
//            }
//        });
//        myHolder.img_Kos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"posisi ; "+position,Toast.LENGTH_SHORT).show();
//            }
//        });
        myHolder.relatifl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), detail_kos.class);
                v.getContext().startActivity(intent);
                Toast.makeText(context,"posisi ; "+position,Toast.LENGTH_SHORT).show();
            }
        });
//        myHolder.textPrice.setText("Rs. " + current.price + "\\Kg");
//        myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

//         load image into imageview using glide
        Glide.with(context).load(current.m_foto)
                .placeholder(R.drawable.dummy)
                .error(R.drawable.dummy)
                .into(myHolder.img_Kos);

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textKosName;
        ImageView img_Kos;
        TextView textKosHarga;
        TextView textKosAlamat;
//        TextView textPrice;
        CardView cView;
        RelativeLayout relatifl;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textKosName= (TextView) itemView.findViewById(R.id.textKosName);
            img_Kos= (ImageView) itemView.findViewById(R.id.i_kos);
            textKosAlamat= (TextView) itemView.findViewById(R.id.textKosAlamat);
            textKosHarga = (TextView) itemView.findViewById(R.id.textHargaKos);
//            textPrice = (TextView) itemView.findViewById(R.id.textPrice);
            cView = (CardView) itemView.findViewById(R.id.card_view);
            relatifl = (RelativeLayout) itemView.findViewById(R.id.relativel);
        }

    }


}
