package com.example.pec3_carmelo;

import androidx.fragment.app.Fragment;

//Extendemos de SingleFragmentActivity para sobreCargar el metodo "CreateFragment"
//Conseguimos que un fragment y la activity no esten ligados
public class AnimeListActivity extends SingleFragmentActivity {
    //Devolvemos el Fragment que nos interesa
    @Override
    protected Fragment createFragment() {
        return new AnimeListFragment();
    }
}
