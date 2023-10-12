package org.example.frontend;

import org.example.App;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Labyrinth extends JPanel {
    private List<List<Integer>> matrix;
    private Integer width;
    private Integer height;
    private Integer rows;
    private Integer columns;

    public Labyrinth() {
        matrix = new ArrayList<>();

        this.readFromFile();

        this.rows = matrix.size();
        this.columns = matrix.get(0).size();
        this.width =  this.rows  * 100;
        this.height = this.columns * 100;
        this.setLayout(new GridLayout(this.rows, this.columns));

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
            JPanel panel = new JPanel();

            Boolean isWall = matrix.get(i).get(j) == 0;
            if(isWall){
                panel.setBackground(Color.GRAY);
            } else {
                panel.setBackground(Color.CYAN);
            }

            panel.setBorder(new LineBorder(Color.BLACK, 1));
            panel.setSize(100, 100);
            this.add(panel);
            //g.drawRect(i*100,j*100,100,100);
            }
        }
    }

    public void readFromFile(){
        final String SPACE_SEPARATOR = " ";
        /* READ FROM FILE */
        /* Get the relative path to the file name labyrinth.txt from the resource folder  */
        String filePath = Labyrinth.class.getClassLoader().getResource("labyrinth.txt").getPath();

        /* Functional variant */
        try(BufferedReader bufferFile = new BufferedReader(new FileReader(filePath))) {
            bufferFile.lines()
                    .map(line -> Arrays.stream(line.split(SPACE_SEPARATOR)).map(Integer::parseInt)
                            .collect(Collectors.toList()))
                            .forEach(this.matrix::add);
            //Stream<List<String>> listStream = bufferFile.lines().map(string -> string.split(SPACE_SEPARATOR)).map(Arrays::asList);
        } catch(Exception e) {
            System.err.println("Error at reading file");
        }

        /* https://devqa.io/java-read-files */
        // try(BufferedReader bufferFile = new BufferedReader(fileReader)) {
        //     for (String fileListLine : bufferFile.lines().toList()) {
        //         String[] split = fileListLine.split(SPACE_SEPARATOR);
        //         List<Integer> currentList = new ArrayList<>();
        //         for (String s : split) {
        //             Integer intValue = Integer.parseInt(s);
        //             currentList.add(intValue);
        //         }
        //         matrix.add(currentList);
        //     }
        // } catch(Exception e) {
        //     System.err.println("Error at reading file");
        // }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
