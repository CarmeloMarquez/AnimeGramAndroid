package com.example.pec3_carmelo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeHolder>{

    //Propiedades
    private List<Anime> mAnimes;
    private Context mContext;
    //Constructor
    public AnimeAdapter(List<Anime> anime, Context context){
        mAnimes = anime;
        //Con este Contexto conseguimos separar la clase interna
        //que usabamos antes en clases publicas
        this.mContext = context;
    }

    @NonNull
    @Override
    public AnimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new AnimeHolder(layoutInflater,parent);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeHolder holder, int position) {

        Anime anime = mAnimes.get(position);
        //Le seteamos el contexto que se pasa en el Constructor
        holder.setContext(mContext);
        holder.bind(anime);
    }

    @Override
    public int getItemCount() {
        return mAnimes.size();
    }

}
