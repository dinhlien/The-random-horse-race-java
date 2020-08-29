
import java.awt.*;
import java.awt.event.*;
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
public class NameSelector extends JFrame implements ActionListener, ItemListener{
    private String[] names;
    private RaceOrganizer model;
    private JCheckBox boxes[];    
    private boolean selectionFinished;
    private JPanel panelN, panelC, panelS;
    private JLabel lbl;
    private JButton btnComp, btnStart;
    private final int WINDOW_WIDTH = 700;
    private final int WINDOW_HEIGHT = 750;
    
    public NameSelector(String[] names, RaceOrganizer model){
        this.names = names;
        this.model = model;        
    }
    
    public boolean getSelectionFinished(){        
        return selectionFinished;
    }
    
    public void resetSelectionFinished(){
        selectionFinished = false;
    }
    
    public void setModel(RaceOrganizer mod){
        model = mod;
    }
    
    public void buildFrame(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("The Field");
        setLayout(new BorderLayout(0,10));
        
        panelN = new JPanel();
        panelC = new JPanel();
        panelS = new JPanel();
                     
        lbl = new JLabel("Select the racing field!");
        panelN.add(lbl, BorderLayout.CENTER);
        
        btnComp = new JButton("Selection Complete!");
        btnStart = new JButton("Start");
        panelS.add(btnComp);
        panelS.add(btnStart);
                
        panelC.setLayout(new GridLayout(names.length,1,0,5));
        boxes = new JCheckBox[names.length];
        for (int i = 0; i < names.length; i++) {
            boxes[i] = new JCheckBox(names[i]);
            boxes[i].addItemListener(this);
            boxes[i].setBackground(Color.CYAN);            
            panelC.add(boxes[i]); 
        }
               
        //background color
        panelS.setBackground(Color.PINK);
        panelC.setBackground(Color.YELLOW);
                
        add(panelN, BorderLayout.NORTH);
        add(panelC, BorderLayout.CENTER);
        add(panelS, BorderLayout.SOUTH);
        
        btnComp.addActionListener(this);
        btnStart.addActionListener(this);
        
        pack();
        setVisible(true);
    } 
    
    public void itemStateChanged(ItemEvent e){
        for (int i = 0; i < boxes.length; i++) {
            if (e.getSource() == boxes[i]) {
                if (boxes[i].isSelected() == true) {
                    model.getRunners().add(new Horse(names[i]));                    
                }
                else {                    
                    for (int j = 0; j < model.getRunners().size(); j++) {
                        if (model.getRunners().get(j).getName() == names[j])
                            model.getRunners().remove(j);
                    }
                }
                    
            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnComp) {
            for (int i = 0; i < model.getRunners().size(); i++)
                System.out.println(model.getRunners().get(i).getName());
            for (int i = 0; i < boxes.length; i++) {
                boxes[i].setEnabled(false);
            }
                
        }
        else if (e.getSource() == btnStart) {
            selectionFinished = true;
            dispose();
        }
    }
}
