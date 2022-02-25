package com.example.pec3_carmelo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import java.util.UUID;
//Extendemos de SingleFragmentActivity para sobreCargar el metodo "CreateFragment"
//Conseguimos que un fragment y la activity no esten ligados
public class AnimePopularListActivity extends SingleFragmentActivity{

    //Propiedades
    private ImageView backButton;
    @Override
    protected Fragment createFragment() {
        return new AnimePopularListFragment();
    }
    //Metodo para conseguir Intents directos a esta activity
    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext,AnimePopularListActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Enlazamos la imgagen del xml al codigo
        backButton = (ImageView) findViewById(R.id.back_toolbar_button);
        //hacemos visible el elemento
        backButton.setVisibility(View.VISIBLE);
        //le damos comporamiento al clic, en este caso, se cierra la activity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
