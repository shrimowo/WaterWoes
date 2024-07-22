//:P
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.*;
import java.util.Scanner; //Keyboard input
  // Gnomenu |BAZINGA| \\
    // Coding a menu 14/02/2024 \\
public class WaterWoes extends JFrame implements ActionListener, MouseListener{
    final int GRIDSIZE = 7;
    boolean StartScreen = true;
    boolean GridGenerating = true;
    Scanner keyboard;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;
    Graphics fixer;
    public void mouseExited(MouseEvent e) {} //{System.out.println("exit");}
    public void mouseEntered(MouseEvent e) {}//{System.out.println("enter");}
    public void mouseReleased(MouseEvent e) {}//{System.out.println("release");}
    public void mousePressed(MouseEvent e) {}//{System.out.println("press");}
    public void mouseClicked(MouseEvent e) {
        int mousex=e.getX();
        int mousey=e.getY();
        System.out.println("Will place here:  x:"+(mousex)+" y:"+(mousey));
    }
    public void paint (Graphics g) {
        final String fileName="sewer.JPG";
        ImageIcon image= new ImageIcon(fileName);
        super.paint(g);
        image.paintIcon(this,g,0,550);
    }
    void createDialog(){
        JDialog box = new JDialog(this);
        box.setBounds(400,400,120,90);
        TextArea area = new TextArea("Placment confirmed!");
        area.setEditable(false);
        box.add(area);
        box.toFront();
        box.setVisible(true);
        box.setTitle("");
    }
    public void createWaterSource (Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawOval(150,450,200,500);
    }
    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        switch(cmd){
            case "Water Source" : System.out.println("Water Source Placed"); createDialog();
                break;
            case "Sink" : System.out.println("Sink Placed"); createDialog();
                break;
            case "Pipe" : System.out.println("Pipe Placed"); createDialog();
                break;
            case "Junction" : System.out.println("Junction Placed"); createDialog();
                break;
            case "QUIT" : System.exit(0);
                break;
        }
    }
    public void gridGeneration()
        {
        int[][] Grid = new int[GRIDSIZE][GRIDSIZE]; 
        System.out.print('\u000C');
        for (int x=0;x<GRIDSIZE;x++) //Sets the grid as off by default
            for (int y=0;y<GRIDSIZE;y++) {
                Grid[x][y] = 1;
            }
        System.out.println("Welcome To Conways Game Of Life"); //Instructions
        while (StartScreen) {
            System.out.println("");
            System.out.println("Type 'guide' To Be Given Instructions");
            System.out.println("Type 'start' To Begin The Game");
            keyboard = new Scanner(System.in);
            String answer=keyboard.nextLine();
            answer = answer.toLowerCase();
            System.out.print('\u000C');
            if (answer.equals("start")) StartScreen = false;
            else if (answer.equals("guide")) {
                System.out.println("Conways Game Of Life Rules:");
                System.out.println("A live cell dies if it has fewer than two live neighbors.");
                System.out.println("A live cell with two or three live neighbors lives on to the next generation.");
                System.out.println("A live cell with more than three live neighbors dies.");
                System.out.println("A dead cell will be brought back to live if it has exactly three live neighbors.");
                System.out.println("o = dead cell   x = live cell");
            } // Invalid input checker
            else System.out.println("Sorry your input was invalid");
        }
        System.out.print('\u000C');
        while (GridGenerating) { //Generates (prints) the grid
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    if (Grid[x][y] == 1) System.out.print("o ");
                    else if (Grid[x][y] == 2) System.out.print("x ");
                }
                System.out.println("");
            }
            System.out.println("Give me 2 positions between 1 & 25 seperated by a comma"); //Instructions
            System.out.println("If you are done type 'done'"); //Instructions
            keyboard = new Scanner(System.in);
            String doneCheck = keyboard.nextLine().toLowerCase();
            if (doneCheck.equals("done")) GridGenerating = false;
                else {
                String[] nums=doneCheck.split(",");
                if (nums.length==2) {
                    if (validInput(nums[0]) && validInput(nums[1])) {
                        int N1 = Integer.parseInt(nums[0])-1;
                        int N2 = Integer.parseInt(nums[1])-1;
                        Grid[N1][N2] = 2;
                        System.out.print('\u000C');
                    } else {
                        System.out.print('\u000C');
                        System.out.println("Sorry you have made an invalid input, Make sure you give me 2 positions between 1 & 25 seperated by a comma");
                    }
                    } else {
                    System.out.print('\u000C');
                    System.out.println("Sorry you have made an invalid input, Make sure you give me 2 positions between 1 & 25 seperated by a comma");
                }
            }
        }
        System.out.print('\u000C');
        System.out.println("How many generations do you want the game to run for?"); //Instructions
        keyboard = new Scanner(System.in);
        while (true) {
            if (!keyboard.hasNextInt()) {
                keyboard.nextLine();
                System.out.println("Please input a number!");
            } else {
                inputNumber = keyboard.nextInt();
                if (inputNumber < 0) {
                    keyboard.nextLine();
                    System.out.println("Please input a positive number!");
                } else {
                    break;
                }
            }
        }
        final int GENERATIONS = inputNumber;
        int[][][] GridGen = new int[GENERATIONS+1][GRIDSIZE][GRIDSIZE]; 
        int livecells = 0;
        for (int x=0;x<GRIDSIZE;x++) { // This is for the users planning
            for (int y=0;y<GRIDSIZE;y++) {
                if (Grid[x][y] == 1) GridGen[0][x][y] = 1 ;
                else if (Grid[x][y] == 2) GridGen[0][x][y] = 2;
            }
        }
        for (int g=0;g<GENERATIONS;g++) {
            System.out.println("Generation "+(g+1)); //Displays what generation we are on
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    livecells = 0;
                    if (x==0 && y==0) { 
                        if (GridGen[g][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[g][x+1][y+1] == 2) livecells++; //Bottom Right
                        if (GridGen[g][x+1][y] == 2) livecells++; //Right
                    } else if (x==GRIDSIZE-1 && y==GRIDSIZE-1) {
                        if (GridGen[g][x][y-1] == 2) livecells++; //Top
                        if (GridGen[g][x-1][y-1] == 2) livecells++; //Top Left
                        if (GridGen[g][x-1][y] == 2) livecells++; //Left
                    } else if (x==GRIDSIZE-1 && y==0) { 
                        if (GridGen[g][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[g][x-1][y+1] == 2) livecells++; //Bottom Left
                        if (GridGen[g][x-1][y] == 2) livecells++; //Left
                    } else if (x==0 && y==GRIDSIZE-1) { 
                        if (GridGen[g][x][y-1] == 2) livecells++; //Top
                        if (GridGen[g][x+1][y-1] == 2) livecells++; //Top Right
                        if (GridGen[g][x+1][y] == 2) livecells++; //Right                        
                    } else if (x==0) {
                        if (GridGen[g][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[g][x][y-1] == 2) livecells++; //Top
                        if (GridGen[g][x+1][y+1] == 2) livecells++; //Bottom Right
                        if (GridGen[g][x+1][y] == 2) livecells++; //Right
                        if (GridGen[g][x+1][y-1] == 2) livecells++; //Top Right
                    } else if (y==0) {
                        if (GridGen[g][x-1][y+1] == 2) livecells++; //Bottom Left
                        if (GridGen[g][x-1][y] == 2) livecells++; //Left
                        if (GridGen[g][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[g][x+1][y+1] == 2) livecells++; //Bottom Right
                        if (GridGen[g][x+1][y] == 2) livecells++; //Right 
                    } else if (x==GRIDSIZE-1) {
                        if (GridGen[g][x][y-1] == 2) livecells++; //Top
                        if (GridGen[g][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[g][x-1][y-1] == 2) livecells++; //Top Left
                        if (GridGen[g][x-1][y] == 2) livecells++; //Left
                        if (GridGen[g][x-1][y+1] == 2) livecells++; //Bottom Left
                    } else if (y==GRIDSIZE-1) {
                        if (GridGen[g][x-1][y] == 2) livecells++; //Top Right
                        if (GridGen[g][x-1][y-1] == 2) livecells++; //Right
                        if (GridGen[g][x][y-1] == 2) livecells++; //Top
                        if (GridGen[g][x+1][y-1] == 2) livecells++; //Top Left
                        if (GridGen[g][x+1][y] == 2) livecells++; //Left
                    } else {
                        if (GridGen[g][x-1][y+1] == 2) livecells++; //Bottom Left
                        if (GridGen[g][x-1][y] == 2) livecells++; //Left
                        if (GridGen[g][x-1][y-1] == 2) livecells++; //Top Left
                        if (GridGen[g][x][y+1] == 2) livecells++; //Bottom
                        //if (GridGen[g][x][y] == 2) livecells++; This is the cell being checked
                        if (GridGen[g][x][y-1] == 2) livecells++; //Top
                        if (GridGen[g][x+1][y+1] == 2) livecells++; //Bottom Right
                        if (GridGen[g][x+1][y] == 2) livecells++; //Right
                        if (GridGen[g][x+1][y-1] == 2) livecells++; //Top Right
                    } 
                    // Setup next generation
                    if (GridGen[g][x][y] == 2 && livecells < 2) GridGen[g+1][x][y] = 1;
                    else if (GridGen[g][x][y] == 2 && livecells == 2) GridGen[g+1][x][y] = 2;
                    else if (GridGen[g][x][y] == 2 && livecells == 3) GridGen[g+1][x][y] = 2;
                    else if (GridGen[g][x][y] == 2 && livecells > 3) GridGen[g+1][x][y] = 1;
                    else if (GridGen[g][x][y] == 1 && livecells == 3) GridGen[g+1][x][y] = 2;
                    else GridGen[g+1][x][y] = 1;
                    // Display grid
                    if (GridGen[g][x][y] == 1) System.out.print("o ");
                    else if (GridGen[g][x][y] == 2) System.out.print("x ");
                    else System.out.print("e "); //Error Diagnosis
                }
                System.out.println("");
            }
            //This adds distance between the grids
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }
    public WaterWoes()
    {
        System.out.print('\u000C');
        setTitle("Wellington Water");
        this.getContentPane().setPreferredSize(new Dimension(1055,1055));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);
        
        WaterWoesText test = new WaterWoesText("Do You Want A Guide To Water-Works?");
        test.setLocationRelativeTo(this);
        test.setVisible(true);
        String reply=test.getText();
        System.out.println(reply);
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(504,1000));
        myGraphic = new Canvas();
        panel.add(myGraphic);
        
        addMouseListener(this);
        
        menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);
        
        menu = new JMenu("Infrastructure Options");
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
    }
}