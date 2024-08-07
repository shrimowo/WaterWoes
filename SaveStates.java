//imports
import javax.swing.JFrame;   
import javax.swing.JButton;   
import java.awt.Dimension;
import java.awt.event.*;
/**
 * This class is for creating a gui that lets the user save their designs
 */
public class SaveStates extends JFrame implements ActionListener
{
    //Instance variables
    
    //Water location
    GridWorkings waterImport;
    
    //Save buttons
    JButton saveButton1;
    JButton saveButton2;
    JButton saveButton3;
    JButton loadButton1;
    JButton loadButton2;
    JButton loadButton3;
    
    //Main class
    WaterWoes waterWoes;
    
    //Array containing Save data
    final int GRIDSIZE = 10;
    int[][] Grid;
    int[][] gridWater;
    int[][] gridSave1 = new int[GRIDSIZE][GRIDSIZE];
    int[][] gridSave2 = new int[GRIDSIZE][GRIDSIZE];
    int[][] gridSave3 = new int[GRIDSIZE][GRIDSIZE];
    
    public SaveStates(WaterWoes waterWoes){
        //Updates array and allows classes to communicate
        this.waterWoes = waterWoes;
        waterImport = waterWoes.speedMenu.gridEngine;
        gridWater = waterImport.gridWater;
        this.Grid=waterWoes.Grid;
        
        //Initialize all save buttons
        saveButton1 = new JButton();
        saveButton1.setText("Save Slot 1");
        saveButton1.setBounds (0,0,110,40); 
        saveButton1.setFocusable(false);
        saveButton1.addActionListener(this); 
        this.add(saveButton1);                   
        saveButton2 = new JButton();
        saveButton2.setText("Save Slot 2");
        saveButton2.setBounds (110,0,110,40);  
        saveButton2.setFocusable(false); 
        saveButton2.addActionListener(this);
        this.add(saveButton2);  
        saveButton3 = new JButton();
        saveButton3.setText("Save Slot 3");
        saveButton3.setBounds (220,0,110,40);  
        saveButton3.setFocusable(false); 
        saveButton3.addActionListener(this); 
        this.add(saveButton3);
        loadButton1 = new JButton();
        loadButton1.setText("Load Slot 1");
        loadButton1.setBounds (0,40,110,40); 
        loadButton1.setFocusable(false);
        loadButton1.addActionListener(this); 
        this.add(loadButton1);                   
        loadButton2 = new JButton();
        loadButton2.setText("Load Slot 2");
        loadButton2.setBounds (110,40,110,40);  
        loadButton2.setFocusable(false); 
        loadButton2.addActionListener(this);
        this.add(loadButton2);  
        loadButton3 = new JButton();
        loadButton3.setText("Load Slot 3");
        loadButton3.setBounds (220,40,110,40);  
        loadButton3.setFocusable(false); 
        loadButton3.addActionListener(this); 
        this.add(loadButton3);
        
        //Initialize pane
        setTitle("Save Slots");
        this.getContentPane().setPreferredSize(new Dimension(330,80));  
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    
        
        //settings
        this.pack();
        this.toFront(); 
        this.setVisible(true);
    }
    public void update(){ //update
        Grid=waterWoes.Grid;
    }
    
    //Action listener
    public void actionPerformed(ActionEvent e){
        //Saves
        if (e.getSource()==saveButton1){
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    gridSave1[x][y] = Grid[x][y];
                }
            }
            System.out.println("This configuration was saved to save slot 1!");
        } else if  (e.getSource()==saveButton2){
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    gridSave2[x][y] = Grid[x][y];
                }
            }
            System.out.println("This configuration was saved to save slot 2!");
        } else if  (e.getSource()==saveButton3){
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    gridSave3[x][y] = Grid[x][y];
                }
            }
            System.out.println("This configuration was saved to save slot 3!");
        }
        //Loads
        if (e.getSource()==loadButton1){
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    Grid[x][y] = gridSave1[x][y];
                    waterImport.gridWater[x][y] = 0;
                }
            }
            this.gridWater=waterImport.gridWater;
            System.out.println("slot 1 was loaded!");
        } else if  (e.getSource()==loadButton2){
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    Grid[x][y] = gridSave2[x][y];
                    waterImport.gridWater[x][y] = 0;
                }
            }
            this.gridWater=waterImport.gridWater;
            System.out.println("slot 2 was loaded!");
        } else if  (e.getSource()==loadButton3){
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    Grid[x][y] = gridSave3[x][y];
                    waterImport.gridWater[x][y] = 0;
                }
            }
            this.gridWater=waterImport.gridWater;
            System.out.println("slot 3 was loaded!");
        }
    }
}
