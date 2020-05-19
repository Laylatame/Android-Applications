package com.example.newshomework;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterNoticia extends RecyclerView.Adapter<AdapterNoticia.ViewHolder> {

    private Context mContext;
    private ArrayList<Noticia> mNoticiaList;
    private String defaultImgURL = "https://miro.medium.com/max/1000/0*-ouKIOsDCzVCTjK-.png";


    public AdapterNoticia(Context context, ArrayList<Noticia> noticiaList){
        this.mContext = context;
        this.mNoticiaList = noticiaList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.noticia_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Noticia currentItem = mNoticiaList.get(position);
        String noticiaURL = currentItem.getNoticiaURL();
        String noticiaTitulo = currentItem.getNoticiaTitulo();
        String noticiaFecha = currentItem.getNoticiaFecha();
        String noticiaDescripcion = currentItem.getNoticiaDescripcion();
        String imageURL = currentItem.getImageURL();

        holder.mNoticiaTitulo.setText(noticiaTitulo);
        holder.mNoticiaFecha.setText(noticiaFecha);
        holder.mNoticiaDescripcion.setText(noticiaDescripcion);

        if(imageURL !="null") {
            Toast.makeText(mContext,
                    imageURL, Toast.LENGTH_SHORT).show();
            Picasso.with(mContext).load(imageURL).fit().centerInside().into(holder.mImageView);
        }
        else{
            Picasso.with(mContext).load(defaultImgURL).fit().centerInside().into(holder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mNoticiaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mNoticiaTitulo;
        public TextView mNoticiaFecha;
        public TextView mNoticiaDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            mNoticiaTitulo = itemView.findViewById(R.id.textViewTituloNoticia);
            mNoticiaFecha = itemView.findViewById(R.id.textViewFecha);
            mNoticiaDescripcion =itemView.findViewById(R.id.textViewDescripcion);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Noticia current = mNoticiaList.get(position);
                    String url = current.getNoticiaURL();
                    Intent viewIntent =
                            new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(url));
                    mContext.startActivity(viewIntent);
                }
            });
        }
    }
}
