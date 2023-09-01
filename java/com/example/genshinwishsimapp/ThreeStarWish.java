package com.example.genshinwishsimapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Parent;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ThreeStarWish implements Initializable {

    @FXML
    Label Drops;
    @FXML
    MediaView mediaView;
    @FXML
    File file;
    Media media;
    MediaPlayer mediaPlayer;

    private Stage stage;
    private Parent root;
    private Scene scene;
    private int primoGems;
    private int summons;
    private int summonsAvailable;

    public void initialize(URL arg0, ResourceBundle arg1){
        file = new File("src/main/resources/com/example/genshinwishsimapp/media/5StarSummonAnimation.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    public void setSummonsAvailable(int primos){
        this.summonsAvailable = (int)primos/160;
    }


    public void switchToStandardBanner(ActionEvent event) throws IOException{

        mediaPlayer.dispose();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("standardBanner.fxml"));
        root = loader.load();
        StandardBanner standardBanner = loader.getController();
        standardBanner.displayPrimoGems(primoGems-(160 * summons));
        standardBanner.setSummonsAvailable(primoGems-(160 * summons));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayDrops(String drop){
        Drops.setText(drop);
    }

    public void getPrimoGems(int primos){
        this.primoGems = primos;
    }

    public void getSummons(int summons){
        this.summons = summons;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }








}
