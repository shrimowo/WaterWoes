//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.*;
/**
 * This is the Main class, user should only have to run this class and get access
 * to all the codes features
 */
public class WaterWoes extends JFrame implements ActionListener, MouseListener{
    final int PANELSIZE = 1000;
    final int GRIDSIZE = 10;
    final int YOFF = 54; //offset the menu's change on the grids position
    final int XOFF = 8; //offset some peculiar 8 pixel differance
    //click tracking and placment variables

    //Mouse position
    int mousex;
    int mousey;

    //corrosponding grid position
    int xnearS;
    int ynearS;

    //Prompts
    boolean hasClicked;
    boolean promptConfirm = false;

    // Initialises the grid
    public int[][] Grid = new int[GRIDSIZE][GRIDSIZE]; 
    //private GridWorkingsNEW gridWorkings;

    //GUI
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic; //Canvas
    Graphics fixer; //Graphics

    //Instance variable of speedmenu class
    SpeedButton speedMenu;
    public WaterWoes()
    {
        System.out.print('\u000C'); //clear screen
        setTitle("Wellington Water"); //Main panel title
        this.getContentPane().setPreferredSize(new Dimension(PANELSIZE+1,PANELSIZE+1)); //Default size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //exit
        this.pack();
        this.toFront();
        this.setVisible(true);

        while (promptConfirm == false){ 
            // Manages the inital tutorial prompt
            WaterWoesText prompt = new WaterWoesText("Do You Want A Guide To Water-Works? (Yes, or No)");
            prompt.setLocationRelativeTo(this);
            prompt.setVisible(true);

            //Reply
            String reply=prompt.getText();
            reply = reply.toLowerCase();

            //Act according to reply
            if (reply.equals("yes")) {promptConfirm = true; Guide();} 
            else if (reply.equals("no")) promptConfirm = true;
            else System.out.println("Please answer with either 'yes' or 'no'");
        }
        //System.out.println(reply);

        speedMenu = new SpeedButton(this); //Generates speed adjustment panel
        SaveStates saveMenu = new SaveStates(this); //Generates the save slots menu

        //Initialize panel and canvas
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,500));
        myGraphic = new Canvas();
        panel.add(myGraphic);

        //Action listener
        myGraphic.addMouseListener(this);
        addMouseListener(this);

        menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu("Infrastructure Options"); //Panel Title
        menuBar.add(menu);

        //Menu items
        menuItem=new JMenuItem("Water Source");menuItem.addActionListener(this);menuItem.setAccelerator(KeyStroke.getKeyStroke('w'));menu.add(menuItem);this.pack();
        menuItem=new JMenuItem("Sink");menuItem.addActionListener(this);menuItem.setAccelerator(KeyStroke.getKeyStroke('s'));menu.add(menuItem);this.pack();
        menuItem=new JMenuItem("Pipe");menuItem.setAccelerator(KeyStroke.getKeyStroke('p'));menuItem.addActionListener(this);menu.add(menuItem);this.pack();    
        menuItem=new JMenuItem("Junction");menuItem.addActionListener(this);menuItem.setAccelerator(KeyStroke.getKeyStroke('j'));menu.add(menuItem);this.pack();  
        menuItem=new JMenuItem("QUIT"); menuItem.addActionListener(this); menuItem.setAccelerator(KeyStroke.getKeyStroke('q')); menu.add(menuItem); this.pack();  

        repaint(); //Paints canvas
    }

    public void mouseExited(MouseEvent e) {} //{System.out.println("exit");}
    public void mouseEntered(MouseEvent e) {repaint();}// Repaints to avoid menu blanking out top right of the panel//{System.out.println("enter");}
    public void mouseReleased(MouseEvent e) {}//{System.out.println("release");}
    public void mousePressed(MouseEvent e) {}//{System.out.println("press");}
    public void mouseClicked(MouseEvent e) {
        //Mouse position
        int mousexCheck=e.getX()-XOFF;
        int mouseyCheck=e.getY()-YOFF;
        //makes sure cursor is within the grid
        if (mousexCheck <= 999 && mousexCheck >= 0) {
            if (mouseyCheck <=999 && mouseyCheck >= 0) {
                //Places Item
                mousex = mousexCheck;
                mousey = mouseyCheck;
                System.out.println("Will place here:  x:"+(mousex)+" y:"+(mousey)); 
                hasClicked=true;
            } else System.out.println("Place within the grid");
        } else System.out.println("Place within the grid");
    }

    public void Guide(){
        //Guide Dialogue

        System.out.println("Welcome to the Water Woes virtual simulation");
        System.out.println("Click anywhere within the grid to choose a position");
        System.out.println("(*(!Make sure your mouse is still!)*)");
        System.out.println("then navigate to the top right and select a Infrastructure option");
        System.out.println("(*(!try out the shortcuts!)*)");
        System.out.println("Watersource will generate 1 Water Per flow, that flow into nearby Pipes or Sinks");
        System.out.println("Pipes will flow into nearby junctions and sinks");
        System.out.println("sinks will absorb 1 Water per flow");
        System.out.println("Junctions are used to connect pipes to other pipes");
    }

    void createDialog(){ //Dialogue after placing an object
        //Dialogue box
        JDialog box = new JDialog(this);
        box.setBounds(400,400,120,90);
        TextArea area = new TextArea("Placment confirmed!"); //Text
        area.setEditable(false);box.add(area);box.toFront();box.setVisible(true);box.setTitle("");
    }

    public void actionPerformed(ActionEvent e){ //when a menu option is clicked
        String cmd=e.getActionCommand(); //Get Menu Item
        repaint();
        
        //Switch state to determine action
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
        
        //Seperated so that the user doesn't have to click to close
        switch(cmd){
            case "QUIT" : System.exit(0); speedMenu.myTimer.cancel();
                break;
        }
    }

    public void rounder (){ 
        //Converts mouse position to grid position
        double xnear = Math.floor(mousex/100.0);
        double ynear = Math.floor(mousey/100.0);
        xnearS = (int)xnear;
        ynearS = (int)ynear;
        //System.out.println("x"+(xnearS)+"y"+(ynearS));
    }

    public void gridPlaceWS() {
        //Places water source
        Grid[xnearS][ynearS] = 1;
        //GridWorkingsNEW gridload = new GridWorkingsNEW();
    }

    public void gridPlaceP() {
        //Places pipes
        Grid[xnearS][ynearS] = 2;
    }

    public void gridPlaceS() {
        //Places sink
        Grid[xnearS][ynearS] = 3;
    }

    public void gridPlaceJ() {
        //Places junction
        Grid[xnearS][ynearS] = 4;      
    }

    public void paint (Graphics g){ //Paints method
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //prepares text
        g2.setColor(Color.RED);
        g2.setFont(new Font("Serif", Font.BOLD, 30));
        for (int x=0;x<GRIDSIZE;x++) { //Cycles through the grid and paints any objects
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
                
                //Draws Water Level for each grid space
                try {g2.drawString(speedMenu.gridEngine.gridWater[x][y]+"",(x*100)+XOFF,(y*100)+(100+YOFF));} catch (Exception e){}
            }
        }
        g2.setColor(Color.BLACK);
        
        //Paint the Grid
        for (int x=0;x<10;x++) { //draws the grid lines
            Line2D lin = new Line2D.Float((x*100)+XOFF,YOFF,(x*100)+XOFF,PANELSIZE+YOFF);
            g2.draw(lin);
        }
        for (int x=0;x<10;x++) { //draws the grid lines
            Line2D lin = new Line2D.Float(XOFF,(x*100)+YOFF,PANELSIZE+XOFF,(x*100)+YOFF);
            g2.draw(lin);
        }
        //Edges of grid
        g2.drawRect(XOFF,YOFF,PANELSIZE,PANELSIZE);
    }
}