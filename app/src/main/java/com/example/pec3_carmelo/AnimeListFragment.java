package com.example.pec3_carmelo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;


public class AnimeListFragment extends Fragment {

    //Propiedades
    private RecyclerView mAnimeRecyclerView;
    private AnimeAdapter mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hacemos que haya elementos nuevos en el Menu
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Hacemos que el Fragment sea un Recycler view
        View view = inflater.inflate(R.layout.fragment_anime_list,container,false);

        //Ligamos el Fragment con el recyclerView
        mAnimeRecyclerView = (RecyclerView) view.findViewById(R.id.anime_recycler_view);
        mAnimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Conseguimos la lista deseada. En este caso todos los elementos de la base de datos
        AnimeLab animeLab = AnimeLab.get(getActivity());
        List<Anime> anime = animeLab.getAnimes();

        //le damos valor al adaptador. Le pasamos una lista y el contexto
        mAdapter = new AnimeAdapter(anime,getActivity());
        //Setteamos el adaptador
        mAnimeRecyclerView.setAdapter(mAdapter);

        return view;
    }

    //Le indicamos que menu queremos que tenga
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_anime,menu);
    }

    //Le damos comportamiento a los elementos del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.top_five_animes:
                //Si se le da clic a la estrella, nos lleva al Top 5 Animes
                Intent intent = AnimePopularListActivity.newIntent(getActivity());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}