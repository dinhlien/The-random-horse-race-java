
import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Linh
 */
public class PanelFactory {

    static JPanel buildCenter(int numOfRunners, JTextField[] track) {
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(numOfRunners, 1, 0, 5));
        for (int i = 0; i < numOfRunners; i++) {
            panelCenter.add(track[i]);
        }
        return panelCenter;
    }

    static JPanel buildEast(int numOfRunners, JTextField[] place, JTextField[] stride) {
        JPanel panelEast = new JPanel();
        panelEast.setLayout(new GridLayout(numOfRunners, 2, 5, 5));
        for (int i = 0; i < numOfRunners; i++) {
            panelEast.add(place[i]);
            panelEast.add(stride[i]);
        }
        return panelEast;
    }

    static JPanel buildWest(RaceOrganizer model) {
        JPanel panelWest = new JPanel();
        int numOfRunners = model.getRunners().size();
        JTextField[] names = new JTextField[numOfRunners];

        //create name labels
        panelWest.setLayout(new GridLayout(numOfRunners, 1, 0, 5));
        for (int i = 0; i < numOfRunners; i++) {
            names[i] = new JTextField(5);
            names[i].setText(model.getRunners().get(i).getName());
            names[i].setBackground(Color.CYAN);
            panelWest.add(names[i]);
        }
        return panelWest;
    }

    static JPanel buildNorth() {
        // label name
        JTextField labelName = new JTextField();
        labelName.setEditable(false);
        labelName.setText("The Horse");
        labelName.setBackground(Color.GRAY);
        labelName.setForeground(Color.RED);
        // label tracks
        JTextField labelTrack = new JTextField();
        labelTrack.setEditable(false);
        labelTrack.setText("The Tracks");
        labelTrack.setBackground(Color.GRAY);
        labelTrack.setForeground(Color.PINK);
        // label place - stride
        JTextField labelPlaceStride = new JTextField();
        labelPlaceStride.setEditable(false);
        labelPlaceStride.setText("Place - Stride");
        labelPlaceStride.setBackground(Color.GRAY);
        labelPlaceStride.setForeground(Color.YELLOW);
        // panel
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new GridLayout(1, 3, 0, 5));
        panelNorth.add(labelName);
        panelNorth.add(labelTrack);
        panelNorth.add(labelPlaceStride);
        return panelNorth;
    }

    static JPanel buildSouth(ImageIcon imageIcon) {
        JLabel labelImage = new JLabel(imageIcon);
        JPanel panelSouth = new JPanel();
        panelSouth.add(labelImage, BorderLayout.CENTER);
        return panelSouth;
    }
}
