package com.example.pec3_carmelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeHolder extends RecyclerView.ViewHolder {

    //Propiedades
    private Context mContext = null;
    private ImageView mImageAnimeView;
    private ImageView mImageButtonView;
    private TextView mNameTextView;
    private TextView mLikesCountView;
    private Anime mAnime;

    //Le pasamos al constructor del holder todos los elementos del xml
    public AnimeHolder(LayoutInflater inflater, ViewGroup parent){
        super(inflater.inflate(R.layout.list_item_anime,parent,false));
        mImageAnimeView = (ImageView) itemView.findViewById(R.id.anime_image);
        mNameTextView = (TextView) itemView.findViewById(R.id.anime_name);
        mLikesCountView = (TextView) itemView.findViewById(R.id.like_count);
        mImageButtonView = (ImageView) itemView.findViewById(R.id.like_clickable);
    }
    //Le damos comportamiento a los elementos
    public void bind(Anime anime){
        //El anime que se le pase por parametro lo igualamos al
        //anime de nuestra propiedad
        mAnime = anime;
        //Seteamos el texto dependiendo del Anime que sea
        mNameTextView.setText(mAnime.getName());
        mImageAnimeView.setImageResource(mAnime.getImage());
        mLikesCountView.setText(""+mAnime.getNumLikes());
        //le damos comportamiento al clic de nuestro icono del like
        mImageButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //guardamos el numero de likes
                int actualLikes = mAnime.getNumLikes();
                //Incrementamos el numero de likes
                mAnime.setNumLikes(actualLikes+1);
                //mostramos el numero de likes
                mLikesCountView.setText(""+mAnime.getNumLikes());
                //Actualizamos el objeto, para guardar el numero del likes
                AnimeLab.get(getContext()).updateAnime(mAnime);
            }
        });


    }
    //set del contexto que usamos en el Adaptador
    public void setContext(Context contexto){
        mContext = contexto;
    }
    //get que usamos en dentro del onCLick
    public Context getContext(){
        return mContext;
    }
}

