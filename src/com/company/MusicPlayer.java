package com.company;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 5/6/15.
 */
public class MusicPlayer extends JFrame{
    private JButton playButton;
    private JPanel root;
    private JButton quitButton;


    public MusicPlayer() {
        setContentPane(root);
        setVisible(true);
        pack();
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Playing a mp3");

                //Hack to force JavaFX init
                //https://www.daniweb.com/software-development/java/threads/475808/how-to-play-mp3-files-in-java-using-eclipse
                new javafx.embed.swing.JFXPanel();

                //Once JavaFX init has occurred, can play a MP3 using JavaFX Media/MediaPlayer classes
                //TODO stopping, pausing, not blocking the GUI thread when the song is playing....
                String file = "file:///Users/admin/desktop/music.mp3";
                Media mediaObject = new Media(file);
                MediaPlayer player = new MediaPlayer(mediaObject);
                player.play();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
