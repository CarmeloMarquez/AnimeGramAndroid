package com.example.pec3_carmelo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimePopularListFragment extends Fragment {

    //Propiedades
    private RecyclerView mAnimeRecyclerView;
    private AnimeAdapter mAdapter;
    //Decimos el numero de animes queremos que muestre
    private final int mNumAnimes = 5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Hacemos que el Fragment sea un Recycler view
        View view = inflater.inflate(R.layout.fragment_anime_list,container,false);

        //Ligamos el Fragment con el recyclerView
        mAnimeRecyclerView = (RecyclerView) view.findViewById(R.id.anime_recycler_view);
        mAnimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Conseguimos la lista deseada. En este caso solo el numero que le damos
        //a la propiedad "mNumAnimes"
        AnimeLab animeLab = AnimeLab.get(getActivity());
        List<Anime> anime = animeLab.getPopularAnimes(mNumAnimes);

        //le damos valor al adaptador. Le pasamos una lista y el contexto
        mAdapter = new AnimeAdapter(anime,getActivity());
        //Setteamos el adaptador
        mAnimeRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
