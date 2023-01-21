package com.example.example;

import java.io.Serializable;

public class ContinentModel implements Serializable {
    private int AvatarImageCountry;
    private String name;

    public int getAvatarImageCountry() {
        return AvatarImageCountry;
    }

    public ContinentModel(int avatarImageCountry, String name) {
        AvatarImageCountry = avatarImageCountry;
        this.name = name;
    }

    public void setAvatarImageCountry(int avatarImageCountry) {
        AvatarImageCountry = avatarImageCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
