package com.guesswho.idan.androidguesswho;

/**
 * Created by Idan on 20/01/2018.
 */

public class CharacteristicObj {

    private String CharacteristicsString = "";
    private int id = CharacterSelectObject.EMPTY;

    public CharacteristicObj(String characteristicsString, int id) {
        CharacteristicsString = characteristicsString;
        this.id = id;
    }

    public String getCharacteristicsString() {
        return CharacteristicsString;
    }

    public void setCharacteristicsString(String characteristicsString) {
        CharacteristicsString = characteristicsString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
