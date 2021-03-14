package be.kdg.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class FileKlasse {
    private final File myFile = new File("files/gegevens.txt");
    private List<String> scores = new ArrayList<>();

    public FileKlasse() {
    }

    public void getScore() {
        try {
            scores = Files.readAllLines(Paths.get(myFile.toURI()));
            new FileWriter(myFile, false).close();
        } catch (IOException e) {
            System.out.println("reading file");
        }
    }

    public void checkList() {
        if (scores.size() == 10) {
            scores.remove(9);
        }
    }

    public void schrijfScoreWeg(String naam, boolean isGewonnen) {
        getScore();
        checkList();
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gegevens.txt")));
            if (isGewonnen) {
                scores.add(0, naam + ":1\n");
            } else {
                scores.add(0, naam + ":1\n");
            }
            for (String string : scores) {
                pw.write(string);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("wegschrijven in file");
        }
    }

    public File getMyFile() {
        return myFile;
    }
}
