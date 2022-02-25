package com.example.pec3_carmelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pec3_carmelo.database.AnimeBaseHelper;
import com.example.pec3_carmelo.database.AnimeCursorWrapper;
import com.example.pec3_carmelo.database.AnimeDbSchema.AnimeTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AnimeLab {

    private static AnimeLab sAnimeLab;
    private Context mContext;
    private SQLiteDatabase mDataBase;

    private AnimeLab(Context context){
        mContext = context.getApplicationContext();
        mDataBase = new AnimeBaseHelper(mContext).getWritableDatabase();
        //Cargamos la informacion.
        //Si existe informacion, no insertamos nada
        //Si no es asi, la cargamos
        if (getAnimes().size() == 0) {
            loadData();
        }
    }

    //Inyeccion de toda la informacion de los 10 animes
    private void loadData() {

        Anime a0 = new Anime();
        a0.setName("Attack on Tittan");
        a0.setImage(R.drawable.attack_on_titan);
        a0.setNumLikes(4);

        Anime a1 = new Anime();
        a1.setName("Dangaronpa");
        a1.setImage(R.drawable.dangaronpa);
        a1.setNumLikes(5);

        Anime a2 = new Anime();
        a2.setName("Pokemon");
        a2.setImage(R.drawable.pokemon);
        a2.setNumLikes(2);

        Anime a3 = new Anime();
        a3.setName("One Punch Man");
        a3.setImage(R.drawable.one_punch_man);
        a3.setNumLikes(9);

        Anime a4 = new Anime();
        a4.setName("JojosBA");
        a4.setImage(R.drawable.jojos_bizarre_adventure);
        a4.setNumLikes(4);

        Anime a5 = new Anime();
        a5.setName("Sword Art Online");
        a5.setImage(R.drawable.sword_art_online);
        a5.setNumLikes(7);

        Anime a6 = new Anime();
        a6.setName("Promised Neverland");
        a6.setImage(R.drawable.the_promised_neverland);
        a6.setNumLikes(2);

        Anime a7 = new Anime();
        a7.setName("Kimetsu No Yaiba");
        a7.setImage(R.drawable.kimetsu_no_yaiba);
        a7.setNumLikes(1);

        Anime a8 = new Anime();
        a8.setName("Death Note");
        a8.setImage(R.drawable.death_note);
        a8.setNumLikes(8);

        Anime a9 = new Anime();
        a9.setName("Tokyo Ghoul");
        a9.setImage(R.drawable.tokyo_ghoul);
        a9.setNumLikes(6);

        addAnime(a0);
        addAnime(a1);
        addAnime(a2);
        addAnime(a3);
        addAnime(a4);
        addAnime(a5);
        addAnime(a6);
        addAnime(a7);
        addAnime(a8);
        addAnime(a9);
    }

    //Convertimos la informacion de nuestra base de datos
    //En una lista para facilitar la consulta de informacion
    public List<Anime> getAnimes(){
        List<Anime> anime = new ArrayList<>();
        AnimeCursorWrapper cursor = queryAnimes(null,null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                anime.add(cursor.getAnime());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return anime;
    }
    //Conseguimos solo los Animes que se pasen por parametro
    public List<Anime> getPopularAnimes(int limit){
        List<Anime> anime = new ArrayList<>();
        //Con OrderBy conseguimos que nos ordene los elementos de mayor a menor
        //En este caso, los likes que es lo que necesitamos
        AnimeCursorWrapper cursor = queryAnimes(null,null,
                AnimeTable.Cols.LIKES+" DESC",""+limit);
        try{
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                anime.add(cursor.getAnime());
                cursor.moveToNext();
            }
        }finally{
            cursor.close();
        }
        return anime;
    }
    public static AnimeLab get(Context context){
        if(sAnimeLab == null){
            sAnimeLab = new AnimeLab(context);
        }
        return  sAnimeLab;
    }
    //Metodo que se encarga de pasar un Anime a una instancia de ContentValues
    private static ContentValues getContentValues(Anime anime){
        ContentValues values = new ContentValues();
        values.put(AnimeTable.Cols.UUID, anime.getID().toString());
        values.put(AnimeTable.Cols.NAME,anime.getName());
        values.put(AnimeTable.Cols.IMAGE,anime.getImage());
        values.put(AnimeTable.Cols.LIKES,anime.getNumLikes());
        return values;
    }

    //Metodo que usamos en AnimeLab.loadData para insertar la informacion
    public void addAnime(Anime a){
        ContentValues values = getContentValues(a);
        mDataBase.insert(AnimeTable.NAME,null,values);
    }
    //Actualizamos los animes, lo usamos cada vez que se da like a un Anime
    public void updateAnime(Anime anime){
        String uuidString = anime.getID().toString();
        ContentValues values = getContentValues(anime);
        mDataBase.update(AnimeTable.NAME,values,
                AnimeTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    //Consulta de Animes dentro de nuestra base de datos
    private AnimeCursorWrapper queryAnimes(String whereClause, String[] whereArgs){
        Cursor cursor = mDataBase.query(
                AnimeTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new AnimeCursorWrapper(cursor);
    }
    //Mismo metodo para consultar animes, pero especificamos el "OrderBy" y el "Limit"(numero de Animes)
    private AnimeCursorWrapper queryAnimes(String whereClause, String[] whereArgs, String orderBy, String numOfAnimes){
        Cursor cursor = mDataBase.query(
                AnimeTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                orderBy,
                numOfAnimes
        );
        return new AnimeCursorWrapper(cursor);

    }
}
