package com.example.genshinwishsimapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import java.util.Random;


import java.io.IOException;

public class StandardBanner {

    @FXML
    Label PrimoGemsAmount;
    @FXML
    Label SummonsAvailable;
    @FXML
    Button singleSummon;
    @FXML
    Button multiSummon;

    public void displayPrimoGems(int primos){
        PrimoGemsAmount.setText("Primogems: " + primos);
        this.primoGems = primos;
    }

    public void setSummonsAvailable(int primos){
        this.summonsAvailable = (int)primos/160;
        SummonsAvailable.setText("Summons Left: " + summonsAvailable);
    }


    public void switchToWeaponBanner(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("weaponBanner.fxml"));
        root = loader.load();
        WeaponBanner weaponBanner = loader.getController();
        weaponBanner.displayPrimoGems(primoGems);
        weaponBanner.setSummonsAvailable(primoGems);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void singleSummon(ActionEvent event) throws IOException{
            Random rnd = new Random();
            Characters characters = new Characters();
            Weapons weapons = new Weapons();
            int summons = 1;
            boolean has4Star = false;
            boolean has5Star = false;

        if(primoGems < 160){
            System.out.println("Not enough primogems. (Require " + (160 - primoGems) + " more primogems)");
            return;
        }

            for(int i = 0; i < summons; i++) {
                int generatedNumber = rnd.nextInt(101); // includes number from 0 = 100
                FiveStarCharacterPity++;
                FourStarCharacterPity++;

                if(FiveStarCharacterPity == 90){ // guarnteed 5* when hit 90 pity
                    System.out.println("You got a guaranteed 5* Character!");
                    int generatedValue = rnd.nextInt(characters.getFiveStarCharacters().size());
                    System.out.println("(5*)(C) " + characters.getFiveStarCharacters().get(generatedValue));
                    characters.getYourFiveStarCharacters().add(characters.getFiveStarCharacters().get(generatedValue)); // adds 5* weapon
                    FiveStarCharacterPity = 0;
                    FourStarCharacterPity = 0;
                    has5Star = true;

                } else if(FourStarCharacterPity == 10){ // 4 star pity (50%/50% weapon or character)
                    int weaponOrCharacter = rnd.nextInt(2);
                    if(weaponOrCharacter == 0) {
                        System.out.println("You got a guaranteed 4* Character!");
                        int generatedValue = rnd.nextInt(characters.getFourStarCharacters().size());
                        System.out.println("(4*)(C) " + characters.getFourStarCharacters().get(generatedValue));

                        FourStarCharacterPity = 0;
                        has4Star = true;

                    } else{
                        System.out.println("You got a guaranteed 4* Weapon!");
                        int generatedValue = rnd.nextInt(weapons.getFourStarWeapons().size());
                        System.out.println("(4*)(W) " + weapons.getFourStarWeapons().get(generatedValue));

                        FourStarCharacterPity = 0;
                        has4Star = true;
                    }

                } else if (generatedNumber >= 7) {  // includes numbers from 7 - 100 (94%)
                    int generatedValue = rnd.nextInt(weapons.getThreeStarWeapons().size());
                    System.out.println("(3*)(W) " + weapons.getThreeStarWeapons().get(generatedValue));

                } else if (generatedNumber >= 4) { // includes numbers from 4-6 (3%)
                    int generatedValue = rnd.nextInt(characters.getFourStarCharacters().size());
                    System.out.println("You got a 4* Character!");
                    System.out.println("(4*)(C) " + characters.getFourStarCharacters().get(generatedValue));
                    FourStarCharacterPity = 0;
                    has4Star = true;

                } else if (generatedNumber >= 1) { // includes numbers from 1-3 (3%)
                    System.out.println("You got a 4* Weapon!");
                    int generatedValue = rnd.nextInt(weapons.getFourStarWeapons().size());
                    System.out.println("(4*)(W) " + weapons.getFourStarWeapons().get(generatedValue));
                    FourStarCharacterPity = 0;
                    has4Star = true;

                } else { // number 0 (1%)
                    int generatedValue = rnd.nextInt(characters.getFiveStarCharacters().size());
                    System.out.println("You got a 5* Character!");
                    System.out.println("(5*)(C) " + characters.getFiveStarCharacters().get(generatedValue));
                    characters.getYourFiveStarCharacters().add(characters.getFiveStarCharacters().get(generatedValue)); // adds 5* weapon
                    FiveStarCharacterPity = 0;
                    has5Star = true;
                }
            }

        if(has5Star){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FiveStarSummon.fxml"));
            root = loader.load();
            FiveStarWish fiveStarWish = loader.getController();
            fiveStarWish.getPrimoGems(primoGems);
            fiveStarWish.getSummons(summons);
            fiveStarWish.setSummonsAvailable(primoGems);
            fiveStarWish.getMediaPlayer().play();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if(has4Star){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FourStarSummon.fxml"));
            root = loader.load();
            FourStarWish fourStarWish = loader.getController();
            fourStarWish.getPrimoGems(primoGems);
            fourStarWish.getSummons(summons);
            fourStarWish.setSummonsAvailable(primoGems);
            fourStarWish.getMediaPlayer().play();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ThreeStarSummon.fxml"));
            root = loader.load();
            ThreeStarWish threeStarWish = loader.getController();
            threeStarWish.getPrimoGems(primoGems);
            threeStarWish.getSummons(summons);
            threeStarWish.setSummonsAvailable(primoGems);
            threeStarWish.getMediaPlayer().play();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    public void multiSummon(ActionEvent event) throws IOException{ // loops through 10 times, but have to find a way to print it out before it goes to next scene
        Random rnd = new Random();
        Characters characters = new Characters();
        Weapons weapons = new Weapons();
        int summons = 10;
        boolean has4Star = false;
        boolean has5Star = false;

        if(primoGems < 1600){
            System.out.println("Not enough primogems. (Require " + (1600 - primoGems) + " more primogems)");
            return;
        }

        for(int i = 0; i < summons; i++) {
            int generatedNumber = rnd.nextInt(101); // includes number from 0 = 100
            FiveStarCharacterPity++;
            FourStarCharacterPity++;

            if(FiveStarCharacterPity == 90){ // guarnteed 5* when hit 90 pity
                System.out.println("You got a guaranteed 5* Character!");
                int generatedValue = rnd.nextInt(characters.getFiveStarCharacters().size());
                System.out.println("(5*)(C) " + characters.getFiveStarCharacters().get(generatedValue));
                characters.getYourFiveStarCharacters().add(characters.getFiveStarCharacters().get(generatedValue)); // adds 5* weapon
                FiveStarCharacterPity = 0;
                FourStarCharacterPity = 0;
                has5Star = true;

            } else if(FourStarCharacterPity == 10){ // 4 star pity (50%/50% weapon or character)
                int weaponOrCharacter = rnd.nextInt(2);
                if(weaponOrCharacter == 0) {
                    System.out.println("You got a guaranteed 4* Character!");
                    int generatedValue = rnd.nextInt(characters.getFourStarCharacters().size());
                    System.out.println("(4*)(C) " + characters.getFourStarCharacters().get(generatedValue));

                    FourStarCharacterPity = 0;
                    has4Star = true;

                } else{
                    System.out.println("You got a guaranteed 4* Weapon!");
                    int generatedValue = rnd.nextInt(weapons.getFourStarWeapons().size());
                    System.out.println("(4*)(W) " + weapons.getFourStarWeapons().get(generatedValue));

                    FourStarCharacterPity = 0;
                    has4Star = true;

                }

            } else if (generatedNumber >= 7) {  // includes numbers from 7 - 100 (94%)
                int generatedValue = rnd.nextInt(weapons.getThreeStarWeapons().size());
                System.out.println("(3*)(W) " + weapons.getThreeStarWeapons().get(generatedValue));

            } else if (generatedNumber >= 4) { // includes numbers from 4-6 (3%)
                int generatedValue = rnd.nextInt(characters.getFourStarCharacters().size());
                System.out.println("You got a 4* Character!");
                System.out.println("(4*)(C) " + characters.getFourStarCharacters().get(generatedValue));
                FourStarCharacterPity = 0;
                has4Star = true;

            } else if (generatedNumber >= 1) { // includes numbers from 1-3 (3%)
                System.out.println("You got a 4* Weapon!");
                int generatedValue = rnd.nextInt(weapons.getFourStarWeapons().size());
                System.out.println("(4*)(W) " + weapons.getFourStarWeapons().get(generatedValue));
                FourStarCharacterPity = 0;
                has4Star = true;


            } else { // number 0 (1%)
                int generatedValue = rnd.nextInt(characters.getFiveStarCharacters().size());
                System.out.println("You got a 5* Character!");
                System.out.println("(5*)(C) " + characters.getFiveStarCharacters().get(generatedValue));
                characters.getYourFiveStarCharacters().add(characters.getFiveStarCharacters().get(generatedValue)); // adds 5* weapon
                FiveStarCharacterPity = 0;
                has5Star = true;
            }
        }

        if(has4Star && has5Star){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FiveStarSummon.fxml"));
            root = loader.load();
            FiveStarWish fiveStarWish = loader.getController();
            fiveStarWish.getPrimoGems(primoGems);
            fiveStarWish.getSummons(summons);
            fiveStarWish.setSummonsAvailable(primoGems);
            fiveStarWish.getMediaPlayer().play();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if(has4Star && !has5Star){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FourStarSummon.fxml"));
            root = loader.load();
            FourStarWish fourStarWish = loader.getController();
            fourStarWish.getPrimoGems(primoGems);
            fourStarWish.getSummons(summons);
            fourStarWish.setSummonsAvailable(primoGems);
            fourStarWish.getMediaPlayer().play();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if(!has4Star && has5Star){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FiveStarSummon.fxml"));
            root = loader.load();
            FiveStarWish fiveStarWish = loader.getController();
            fiveStarWish.getPrimoGems(primoGems);
            fiveStarWish.getSummons(summons);
            fiveStarWish.setSummonsAvailable(primoGems);
            fiveStarWish.getMediaPlayer().play();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ThreeStarSummon.fxml"));
            root = loader.load();
            ThreeStarWish threeStarWish = loader.getController();
            threeStarWish.getPrimoGems(primoGems);
            threeStarWish.getSummons(summons);
            threeStarWish.setSummonsAvailable(primoGems);
            threeStarWish.getMediaPlayer().play();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }



    private Stage stage;
    private Parent root;
    private Scene scene;
    private int primoGems;
    private int summonsAvailable;
    private int FiveStarCharacterPity = 0;
    private int FourStarCharacterPity = 0;





}
