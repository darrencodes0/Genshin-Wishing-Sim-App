package com.example.genshinwishsimapp;

import java.util.*;
public class Weapons{

    public Weapons(){
        addFiveStarWeapons();
        addFourStarWeapons();
        addThreeStarWeapons();
        AllWeapons.addAll(FourStarWeapons);
        AllWeapons.addAll(FiveStarWeapons);
        AllWeapons.addAll(ThreeStarWeapons);
    }

    public void addFiveStarWeapons(){
        FiveStarWeapons.add("Wolf Gravestone");
        FiveStarWeapons.add("Amos' Bow");
        FiveStarWeapons.add("Skyward Harp");
        FiveStarWeapons.add("Lost Prayer to the Sacred Winds");
        FiveStarWeapons.add("Skyward Atlas");
        FiveStarWeapons.add("Primordial Jade Winged-Spear");
        FiveStarWeapons.add("Skyward Pride");
        FiveStarWeapons.add("Aquila Favonia");
        FiveStarWeapons.add("Skyward Spine");
        FiveStarWeapons.add("Skyward Blade");

    }

    public void addFourStarWeapons() {
        FourStarWeapons.add("Favonius Warbow");
        FourStarWeapons.add("Rust");
        FourStarWeapons.add("Sacrifical Bow");
        FourStarWeapons.add("The Stringless");
        FourStarWeapons.add("Eye of Perception");
        FourStarWeapons.add("Favonius Codex");
        FourStarWeapons.add("Sacrificial Fragments");
        FourStarWeapons.add("The Widsith");
        FourStarWeapons.add("Favonius Greatsword");
        FourStarWeapons.add("Rainslasher");
        FourStarWeapons.add("Sacrifical Greatsword");
        FourStarWeapons.add("The Bell");
        FourStarWeapons.add("Dragon's Bane");
        FourStarWeapons.add("Favonius Lance");
        FourStarWeapons.add("Favonius Sword");
        FourStarWeapons.add("Lion's Roar");
        FourStarWeapons.add("Sacrifical Sword");
        FourStarWeapons.add("The Flute");
    }

    public void addThreeStarWeapons(){
        ThreeStarWeapons.add("Raven Bow");
        ThreeStarWeapons.add("Sharp-shooter's Oath");
        ThreeStarWeapons.add("Black Tassel");
        ThreeStarWeapons.add("Thrilling Tales of Dragon Slayer");
        ThreeStarWeapons.add("Slingshot");
        ThreeStarWeapons.add("Emerald Orb");
        ThreeStarWeapons.add("Magic Guide");
        ThreeStarWeapons.add("Bloodtainted Greatsword");
        ThreeStarWeapons.add("Debate Club");
        ThreeStarWeapons.add("Ferrous Shadow");
        ThreeStarWeapons.add("Cool Steel");
        ThreeStarWeapons.add("Harbinger of Dawn");
        ThreeStarWeapons.add("Skyrider Sword");
    }

    public ArrayList<String> getFiveStarWeapons(){
        return FiveStarWeapons;
    }

    public ArrayList<String> getFourStarWeapons(){
        return FourStarWeapons;
    }

    public ArrayList<String> getThreeStarWeapons(){
        return ThreeStarWeapons;
    }

    public ArrayList<String> getAllWeapons(){
        return AllWeapons;
    }

    public ArrayList<String> getYourFiveStarWeapons() {
        return yourFiveStarWeapons;
    }

    private final ArrayList<String> FiveStarWeapons = new ArrayList<>();
    private final ArrayList<String> FourStarWeapons = new ArrayList<>();
    private final ArrayList<String> ThreeStarWeapons = new ArrayList<>();
    private final ArrayList<String> AllWeapons = new ArrayList<>();
    private final ArrayList<String> yourFiveStarWeapons = new ArrayList<>();

}
