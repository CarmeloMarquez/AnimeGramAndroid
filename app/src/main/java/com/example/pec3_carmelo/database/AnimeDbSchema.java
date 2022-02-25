package com.example.pec3_carmelo.database;

public class AnimeDbSchema {

    public static final class AnimeTable{
        //Nombre de la Tabla
        public static final String NAME = "animes";
        //Nombre de las columnas de la tabla
        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String LIKES = "likes";
            public static final String IMAGE = "image";
        }
    }
}
