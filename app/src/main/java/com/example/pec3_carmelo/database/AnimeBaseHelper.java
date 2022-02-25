package com.example.pec3_carmelo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.pec3_carmelo.database.AnimeDbSchema.AnimeTable;
public class AnimeBaseHelper extends SQLiteOpenHelper {

    //Properties
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "animeBase.db";
    public AnimeBaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        // sql query to create the database
        database.execSQL("CREATE TABLE " + AnimeTable.NAME + "(" +
                "id integer PRIMARY KEY AUTOINCREMENT, " +
                AnimeTable.Cols.UUID + "," +
                AnimeTable.Cols.NAME + "," +
                AnimeTable.Cols.IMAGE + "," +
                AnimeTable.Cols.LIKES +
                ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
