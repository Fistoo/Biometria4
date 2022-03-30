package com.example.bio4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class HelloController {
    private int width;
    private int height;
    private File selectedFile;

    @FXML
    private Label test;

    @FXML
    private ImageView imageOrginal;

    @FXML
    private ImageView medianImage;

    @FXML
    private ImageView pixImage;

    @FXML
    private ImageView araraImage;

    @FXML
    protected void onLoadButtonClick() throws IOException {
        final FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        selectedFile = fc.showOpenDialog(test.getScene().getWindow());
        Image img = new Image(selectedFile.getPath());
        imageOrginal.setImage(img);
        imageOrginal.setFitWidth(200);
        imageOrginal.setFitHeight(150);
        width = (int)img.getWidth();
        height = (int)img.getHeight();
        Mediana(15,-1.5);
        Pikselizacja(15, -1.5);
        Kuwahara(15,-1.5);
    }

    @FXML
    void initialize() {

    }
    public void Mediana (int window, double k1) throws IOException {

    }
    public void Pikselizacja (int window, double k1) throws IOException {

    }
    public void Kuwahara (int window, double k1) throws IOException {

    }
}