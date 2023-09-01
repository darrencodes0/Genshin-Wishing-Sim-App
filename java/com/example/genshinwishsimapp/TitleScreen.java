package com.example.genshinwishsimapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleScreen {

    @FXML
    TextField InsertPrimoGems;
    @FXML
    Button ContinueButton;

    private Stage stage;
    private Parent root;
    private Scene scene;

    private int primoGems;



    public void switchToStandardBanner(ActionEvent event) throws IOException{

        primoGems = Integer.parseInt(InsertPrimoGems.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("standardBanner.fxml"));
        root = loader.load();
        StandardBanner standardBanner = loader.getController();
        standardBanner.displayPrimoGems(primoGems);
        standardBanner.setSummonsAvailable(primoGems);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
