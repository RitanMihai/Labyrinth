package org.example;

import org.example.frontend.Labyrinth;

import javax.swing.*;

public class App
{
    private static void initUI(){
        JFrame frame = new JFrame();

        Labyrinth labyrinth = new Labyrinth();

        frame.add(labyrinth);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }

    public static void main( String[] args ) {
        SwingUtilities.invokeLater(App::initUI);
    }
}
