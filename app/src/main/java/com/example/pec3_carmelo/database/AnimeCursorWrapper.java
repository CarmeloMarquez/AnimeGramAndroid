package com.example.pec3_carmelo.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.media.Image;

import com.example.pec3_carmelo.Anime;

import java.util.Date;
import java.util.UUID;

import com.example.pec3_carmelo.database.AnimeDbSchema.AnimeTable;

public class AnimeCursorWrapper extends CursorWrapper {

    public AnimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    //Añadimos el metodo getCrime que extraerá los datos de las columnas
    //relevantes
    public Anime getAnime(){

        //Obtenemos el contenido de las columnas
        String uuidString = getString(getColumnIndex(AnimeTable.Cols.UUID));
        String name = getString(getColumnIndex(AnimeTable.Cols.NAME));
        int image = getInt(getColumnIndex(AnimeTable.Cols.IMAGE));
        int likes = getInt(getColumnIndex(AnimeTable.Cols.LIKES));

        //Ahora vamos a crear el objeto Anime a devolver
        Anime anime = new Anime(UUID.fromString(uuidString));
        anime.setName(name);
        anime.setImage(image);
        anime.setNumLikes(likes);
        return anime;

    }
}
