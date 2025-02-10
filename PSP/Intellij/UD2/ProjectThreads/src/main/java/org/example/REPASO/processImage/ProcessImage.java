package org.example.REPASO.processImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProcessImage implements Runnable{
    String imageName;

    public ProcessImage(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void run() {

        try {
            File intputFile = new File("src/main/resources/originals/" + imageName);
            BufferedImage img = ImageIO.read(intputFile); // read image


            // get image's width and height
            int width = img.getWidth();
            int height = img.getHeight();
            int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);
            // convert to grayscale
            for (int i = 0; i < pixels.length; i++) {

                // Here i denotes the index of array of pixels
                // for modifying the pixel value.
                int p = pixels[i];

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // calculate average
                int avg = (r + g + b) / 3;

                // replace RGB value with avg
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;

                pixels[i] = p;
            }
            img.setRGB(0, 0, width, height, pixels, 0, width);

            // write image
            String FileName="src/main/results/"+imageName.replaceFirst("\\.(?=[^.]+$)", "_grey.");
            File outputFile = new File(FileName);
            ImageIO.write(img, "png", outputFile);
            System.out.println("Imagen procesada: " + outputFile.getName());
        } catch (IOException e) {
            System.out.println("Error procesando la imagen " + imageName + ": " + e.getMessage());
        }
    }

}