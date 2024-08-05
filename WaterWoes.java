/*
 * This is the Main class, user should only have to run this class and get access
 * to all the codes features
 */

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.*;
public class WaterWoes extends JFrame implements ActionListener, MouseListener{
    // final variables
    final int PANELSIZE = 1000;
    final int GRIDSIZE = 10;
    final int YOFF = 54; //Used to offset the menu's change on the grids position
    final int XOFF = 8; //Used to offset some peculiar 8 pixel differance
    //click tracking and placment variables
    int mousex;
    int mousey;
    int xnearS;
    int ynearS;
    
    boolean hasClicked;
    boolean promptConfirm = false;
    
    // initialises the grid
    public int[][] Grid = new int[GRIDSIZE][GRIDSIZE]; 
    //private GridWorkingsNEW gridWorkings;
    
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;
    Graphics fixer;
    SpeedButton speedMenu;
    public WaterWoes()
    {
        System.out.print('\u000C');
        setTitle("Wellington Water"); //Main panel title
        this.getContentPane().setPreferredSize(new Dimension(PANELSIZE+1,PANELSIZE+1));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);
        
        while (promptConfirm == false){ // manages the inital tutorial prompt
            WaterWoesText prompt = new WaterWoesText("Do You Want A Guide To Water-Works? (Yes, or No)");
            prompt.setLocationRelativeTo(this);
            prompt.setVisible(true);
            String reply=prompt.getText();
            reply = reply.toLowerCase();
            if (reply.equals("yes")) promptConfirm = true;
            else if (reply.equals("no")) promptConfirm = true;
            else System.out.println("Please answer with either 'yes' or 'no'");
        }
        //System.out.println(reply);
        speedMenu = new SpeedButton(this); //Generates speed adjustment panel
        SaveStates saveMenu = new SaveStates(this); //Generates the save slots menu
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,500));
        myGraphic = new Canvas();
        panel.add(myGraphic);
        myGraphic.addMouseListener(this);

        
        addMouseListener(this);
        
        menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);
        
        menu = new JMenu("Infrastructure Options"); //Panel Title
        menuBar.add(menu);
        
        menuItem=new JMenuItem("Water Source");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('w'));
        menu.add(menuItem);
        this.pack();
        
        menuItem=new JMenuItem("Sink");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('s'));
        menu.add(menuItem);
        this.pack();
        
        menuItem=new JMenuItem("Pipe");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('p'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        this.pack();    
        
        menuItem=new JMenuItem("Junction");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('j'));
        menu.add(menuItem);
        this.pack();  
        
        menuItem=new JMenuItem("QUIT");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('q'));
        menu.add(menuItem);
        this.pack();  
        
        repaint(); //repaint for some precaution (i cant recall the specific reason)
    }
    public void mouseExited(MouseEvent e) {} //{System.out.println("exit");}
    public void mouseEntered(MouseEvent e) {repaint();}// Repaints to avoid menu blanking out top right of the panel//{System.out.println("enter");}
    public void mouseReleased(MouseEvent e) {}//{System.out.println("release");}
    public void mousePressed(MouseEvent e) {}//{System.out.println("press");}
    public void mouseClicked(MouseEvent e) {
        int mousexCheck=e.getX()-XOFF;
        int mouseyCheck=e.getY()-YOFF;
        //makes sure cursor is inside the grid to avoid bugs
        if (mousexCheck <= 999 && mousexCheck >= 0) {
            if (mouseyCheck <=999 && mouseyCheck >= 0) {
                mousex = mousexCheck;
                mousey = mouseyCheck;
                System.out.println("Will place here:  x:"+(mousex)+" y:"+(mousey)); 
                hasClicked=true;
            } else System.out.println("Place within the grid");
        } else System.out.println("Place within the grid");
    }
    void Guide(){
        System.out.println("Welcome to the Water Woes virtual simulation");
        System.out.println("Click anywhere within the grid to choose a position");
        System.out.println("(*(!Make sure your mouse is still!)*)");
        System.out.println("then navigate to the top right and select a Infrastructure option");
        System.out.println("(*(!try out the shortcuts!)*)");
        System.out.println("Watersource will generate 1 Water Per flow, that flow into nearby Pipes or Sinks");
        System.out.println("Pipes will flow into nearby junctions and sinks");
        System.out.println("sinks will absorb 1 Water per flow");
        System.out.println("Junctions are used to connect pipes to other pipes and function the same");
    }
    void createDialog(){ //placment that generates after placing an object
        JDialog box = new JDialog(this);
        box.setBounds(400,400,120,90);
        TextArea area = new TextArea("Placment confirmed!");
        area.setEditable(false);
        box.add(area);
        box.toFront();
        box.setVisible(true);
        box.setTitle("");
    }
    public void actionPerformed(ActionEvent e){ //when a menu option is clicked
        String cmd=e.getActionCommand();
        repaint();
        if (hasClicked == true) {
            switch(cmd){
                case "Water Source" : System.out.println("Water Source Placed"); createDialog(); rounder(); gridPlaceWS(); repaint();
                    break;
                case "Sink" : System.out.println("Sink Placed"); createDialog(); rounder(); gridPlaceS(); repaint();
                    break;
                case "Pipe" : System.out.println("Pipe Placed"); createDialog(); rounder(); gridPlaceP(); repaint();
                    break;
                case "Junction" : System.out.println("Junction Placed"); createDialog(); rounder(); gridPlaceJ(); repaint();
                    break;
            }
            speedMenu.gridEngine.update();
        } else System.out.println("Click on a grid to place first");
        switch(cmd){
                case "QUIT" : System.exit(0);
                    break;
            }
    }
    public void rounder (){ //for making mouse positions into functional ccordinates
        double xnear = Math.floor(mousex/100.0);
        double ynear = Math.floor(mousey/100.0);
        xnearS = (int)xnear;
        ynearS = (int)ynear;
        //System.out.println("x"+(xnearS)+"y"+(ynearS));
    }
    public void gridPlaceWS() {
        Grid[xnearS][ynearS] = 1;
        //GridWorkingsNEW gridload = new GridWorkingsNEW();
    }
    public void gridPlaceP() {
        Grid[xnearS][ynearS] = 2;
    }
    public void gridPlaceS() {
        Grid[xnearS][ynearS] = 3;
    }
    public void gridPlaceJ() {
        Grid[xnearS][ynearS] = 4;      
    }
    public void paint (Graphics g){ //Paints everything
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int x=0;x<GRIDSIZE;x++) { //Paints the objects
            for (int y=0;y<GRIDSIZE;y++) {
                if (Grid[x][y] == 1) {
                    final String fileName1="Water_Bucket.PNG";
                    ImageIcon image1= new ImageIcon(fileName1);
                    image1.paintIcon(this,g,(x*100)+XOFF,(y*100)+YOFF);
                } else if (Grid[x][y] == 2) {
                    final String fileName2="Pipes.PNG";
                    ImageIcon image2= new ImageIcon(fileName2);
                    image2.paintIcon(this,g,(x*100)+XOFF,(y*100)+YOFF);                    
                } else if (Grid[x][y] == 3) {
                    final String fileName3="Metal_Sink.PNG";
                    ImageIcon image3= new ImageIcon(fileName3);
                    image3.paintIcon(this,g,(x*100)+XOFF,(y*100)+YOFF);
                } else if (Grid[x][y] == 4) {
                    final String fileName4="Junction_Pipes.PNG";
                    ImageIcon image4= new ImageIcon(fileName4);
                    image4.paintIcon(this,g,(x*100)+XOFF,(y*100)+YOFF);
                }
            }
        }
        for (int x=0;x<10;x++) { //draws the grid lines
            Line2D lin = new Line2D.Float((x*100)+XOFF,YOFF,(x*100)+XOFF,PANELSIZE+YOFF);
            g2.draw(lin);
        }
        for (int x=0;x<10;x++) { //draws the grid lines
            Line2D lin = new Line2D.Float(XOFF,(x*100)+YOFF,PANELSIZE+XOFF,(x*100)+YOFF);
            g2.draw(lin);
        }
        g2.drawRect(XOFF,YOFF,PANELSIZE,PANELSIZE);
    }
}