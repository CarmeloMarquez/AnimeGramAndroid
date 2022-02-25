package com.example.pec3_carmelo;

import android.media.Image;

import java.util.UUID;

public class Anime {

    //Properties
    private UUID mID;
    private String mName;
    private int mNumLikes;
    private int mImage;

    //Constructors
    public Anime(){
        this (UUID.randomUUID());
    }
    public Anime(UUID id){
        mID = id;
    }
    //Getters and Setters
    public UUID getID() {
        return mID;
    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        this.mName = name;
    }
    public int getNumLikes() {
        return mNumLikes;
    }
    public void setNumLikes(int numLikes) {
        this.mNumLikes = numLikes;
    }
    public int getImage() {
        return mImage;
    }
    public void setImage(int image) {
        this.mImage = image;
    }

}
