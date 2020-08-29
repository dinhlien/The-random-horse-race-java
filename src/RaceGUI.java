import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
public class RaceGUI extends JFrame implements ActionListener{
    
    private int sizee;
    private RaceOrganizer model;
    private ImageIcon icon = new ImageIcon("racehorseicon.gif");
    private JTextField[] track, place, stride;
    
    public RaceGUI(RaceOrganizer model, String title){
        super(title);
        setModel(model);
        
        //set number of runners to dimension
        this.sizee = this.model.getRunners().size();
        
        //initialize 
        track = new JTextField[this.sizee];
        place = new JTextField[this.sizee];
        stride = new JTextField[this.sizee];
        for (int i = 0; i < this.sizee; i++) {
            track[i] = new JTextField(15);
            track[i].setEditable(false);
            track[i].setBackground(Color.GREEN);
            place[i] = new JTextField(2);
            place[i].setEditable(false);
            stride[i] = new JTextField(2);
            stride[i].setEditable(false);
        }
        
        setSize(860, sizee*30+370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("The Field");
        
        //builder
        add(PanelFactory.buildNorth(), BorderLayout.NORTH);
        add(PanelFactory.buildSouth(icon), BorderLayout.SOUTH);
        add(PanelFactory.buildEast(this.sizee, this.place, this.stride), BorderLayout.EAST);
        add(PanelFactory.buildWest(model), BorderLayout.WEST);
        add(PanelFactory.buildCenter(this.sizee, this.track), BorderLayout.CENTER);
        
        pack();
        setVisible(true);
    }
    
    public void setModel(RaceOrganizer model) {
        this.model = model;
        model.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        ArrayList<Horse> temp = this.model.getRunners();
        
        Font font = new Font("Dialog", Font.BOLD, 11); 

        
        //update the components
        for (Horse element : temp) {
            int index = temp.indexOf(element);
            track[index].setText(element.getRunX());
            track[index].setFont(font);
            place[index].setText(Integer.toString(element.getPlacement()));
            stride[index].setText(Integer.toString(element.getStrides())); 
        }
        //revalidate and repaint GUI
        this.revalidate();
        this.repaint();
    }
}
