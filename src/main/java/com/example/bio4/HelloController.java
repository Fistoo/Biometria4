package com.example.bio4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class HelloController {
    private int width;
    private int height;
    private File selectedFile;
    final int PIX_SIZE = 10;
    private BufferedImage image;

    @FXML
    private Label test;

    @FXML
    private ImageView imageOrginal;

    @FXML
    private ImageView imgOutput;

    @FXML
    private Button load;

    @FXML
    private Button mediana;

    @FXML
    private Button pikxelizacja;

    @FXML
    protected void onLoadButtonClick() throws IOException {
        final FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        selectedFile = fc.showOpenDialog(imgOutput.getScene().getWindow());
        image = ImageIO.read(selectedFile);
        imgOutput.setImage(convertToFxImage(image));
        imgOutput.setFitWidth(450);
        imgOutput.setFitHeight(400);
        width = (int)image.getWidth();
        height = (int)image.getHeight();
    }

    @FXML
    void initialize() {

    }
    @FXML
    public void Mediana (int window, double k1) throws IOException {

    }
    @FXML
    protected void Pikselizacja (int window, double k1) throws IOException {
        Raster src = image.getData();
        WritableRaster dest = src.createCompatibleWritableRaster();
        for(int y = 0; y < src.getHeight(); y += PIX_SIZE) {
            for(int x = 0; x < src.getWidth(); x += PIX_SIZE) {

                double[] pixel = new double[3];
                pixel = src.getPixel(x, y, pixel);

                for(int yd = y; (yd < y + PIX_SIZE) && (yd < dest.getHeight()); yd++) {
                    for(int xd = x; (xd < x + PIX_SIZE) && (xd < dest.getWidth()); xd++) {
                        dest.setPixel(xd, yd, pixel);
                    }
                }
            }
        }
        BufferedImage temp = ImageIO.read(selectedFile);
        temp.setData(dest);
        imgOutput.setImage(convertToFxImage(temp));
    }
    @FXML
    public void Kuwahara (int window, double k1) throws IOException {

    }
    private static Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }

        return new ImageView(wr).getImage();
    }
}