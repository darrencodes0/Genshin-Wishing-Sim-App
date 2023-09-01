package com.example.genshinwishsimapp;

import java.util.*;

public class Characters{

    public Characters(){
        addFiveStarCharacters();
        addFourStarCharacters();
        AllCharacters.addAll(FourStarCharacters);
        AllCharacters.addAll(FiveStarCharacters);
    }

    public void addFiveStarCharacters(){
        FiveStarCharacters.add("Diluc");
        FiveStarCharacters.add("Mona");
        FiveStarCharacters.add("Qiqi");
        FiveStarCharacters.add("Jean");
        FiveStarCharacters.add("Keqing");
        FiveStarCharacters.add("Dehya");
        FiveStarCharacters.add("Tighnari");
    }

    public void addFourStarCharacters(){
        FourStarCharacters.add("Faruzan");
        FourStarCharacters.add("Fischl");
        FourStarCharacters.add("Sayu");
        FourStarCharacters.add("Xiangling");
        FourStarCharacters.add("Rosaria");
        FourStarCharacters.add("Razor");
        FourStarCharacters.add("Chongyun");
        FourStarCharacters.add("Xingqiu");
        FourStarCharacters.add("Kuki Shinobu");
        FourStarCharacters.add("Noelle");
        FourStarCharacters.add("Barbara");
        FourStarCharacters.add("Beidou");
        FourStarCharacters.add("Dori");
        FourStarCharacters.add("Collei");
        FourStarCharacters.add("Layla");
        FourStarCharacters.add("Kaeya");
        FourStarCharacters.add("Diona");
        FourStarCharacters.add("Sucrose");
        FourStarCharacters.add("Shikanoin Heizou");
        FourStarCharacters.add("Kujou Sara");
        FourStarCharacters.add("Lisa");
        FourStarCharacters.add("Gorou");
        FourStarCharacters.add("Ningguang");
        FourStarCharacters.add("Yun Jin");
        FourStarCharacters.add("Candace");
        FourStarCharacters.add("Amber");
        FourStarCharacters.add("Bennett");
        FourStarCharacters.add("Thoma");
        FourStarCharacters.add("Xinyan");
        FourStarCharacters.add("Yanfei");
        FourStarCharacters.add("Kaveh");
        FourStarCharacters.add("Kirara");
        FourStarCharacters.add("Yaoyao");
        FourStarCharacters.add("Mika");

    }

    public ArrayList<String> getFourStarCharacters(){
        return FourStarCharacters;
    }

    public ArrayList<String> getFiveStarCharacters(){
        return FiveStarCharacters;
    }

    public ArrayList<String> getAllCharacters(){
        return AllCharacters;
    }

    public ArrayList<String> getYourFiveStarCharacters() {
        return yourFiveStarCharacters;
    }

    private final ArrayList<String> FourStarCharacters = new ArrayList<>();
    private final ArrayList<String> FiveStarCharacters = new ArrayList<>();
    private final ArrayList<String> AllCharacters = new ArrayList<>();
    private final ArrayList<String> yourFiveStarCharacters = new ArrayList<>();

}
