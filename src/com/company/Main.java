package com.company;


import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
public class Main {

    public static void main(String[] args) throws IOException {


        // Ordner auswählen, wo Dateien abliegen
        File f = new File("C:\\Users\\Michael\\Desktop\\Michael\\Programmieren\\Java\\Image analysis\\Testdateien");
        File[] fileArray = f.listFiles();
        System.out.println("Es sind " + fileArray.length + " Bilder zum vergleichen da.");

        // Mit einer Schleife jede Datei screenen und in eine Textdatei alle Infos abspeichern
        for (int i = 0; i < fileArray.length; i++) {
            System.out.println("Jetzt ist Datei Nummer " + (i + 1) + " namens " + fileArray[i].toString() + " dran.");

            //Datei erstellen
            File file;

            file = new File("FileWriterTest.txt");

            String dateiName = fileArray[i].toString(); //später noch mit RegEx alles vor "/" löschen, damit Dateiname schöner wird
            file = new File(dateiName);
                                                       //BufferedImage img = ImageIO.read(new File("fileArray[i]");
                                                        //BufferedImage img = ImageIO.read(new File("C:\Users\Michael\Desktop\Michael\Programmieren\Java\Image analysis\Testdateien\103992931.jpg"));
            try {
                BufferedImage img = ImageIO.read(new File(fileArray[i].toString()));

                System.out.println("Daten des auzulesenden Bildes: " + img.getData());

                for (int x = 0; x < img.getHeight(); x++) {
                    for (int y = 0; y < img.getWidth(); y++) {
                        int rgb = img.getRGB(x, y);
                        Color c = new Color(rgb);
                        System.out.println("Farbe:"+ c + "bei X: " + x + " Y: " +y);

                        //In Datei schreiben
                        FileWriter writer;
                        writer = new FileWriter(file ,true);
                        writer.write(c.toString());

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("-------->   " + fileArray[i] + " ausgelesen und abgespeichert!!!");

        }

        // Die Textdateien mit verschiedenen Prüfverfahren vergleichen und dadurch verschiedene Aspekte bewerten
    }
}