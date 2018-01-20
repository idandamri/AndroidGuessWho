package com.guesswho.idan.androidguesswho;

import java.util.HashMap;

/**
 * Created by Idan on 20/01/2018.
 */

public class CharacterSelectObject {

    public static final int EMPTY = -1;
    private int resourceId = EMPTY;
    private HashMap<Integer, CharacteristicObj> Characteristics = new HashMap<>();
    private String name = "";

    public CharacterSelectObject(int resourceId, HashMap<Integer, CharacteristicObj> characteristics, String name) {
        setResourceId(resourceId);
        setCharacteristics(characteristics);
        setName(name);
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public HashMap<Integer, CharacteristicObj> getCharacteristics() {
        return Characteristics;
    }

    public void setCharacteristics(HashMap<Integer, CharacteristicObj> characteristics) {
        Characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
