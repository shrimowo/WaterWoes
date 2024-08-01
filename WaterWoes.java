//:P
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.*;
//import java.util.Scanner; //Keyboard input
  // Gnomenu |BAZINGA| \\
    // Coding a menu 14/02/2024 \\
public class WaterWoes extends JFrame implements ActionListener, MouseListener{
    final int PANELSIZE = 1000;
    final int YOFF = 54;
    final int XOFF = 8;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;
    Graphics fixer;
    public WaterWoes()
    {
        setTitle("Wellington Water");
        this.getContentPane().setPreferredSize(new Dimension(PANELSIZE+1,PANELSIZE+1));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);
        
        SpeedButton speedMenu = new SpeedButton();
        WaterWoesText prompt = new WaterWoesText("Do You Want A Guide To Water-Works?");
        prompt.setLocationRelativeTo(this);
        prompt.setVisible(true);
        String reply=prompt.getText();
        System.out.println(reply);
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,500));
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
    public void mouseExited(MouseEvent e) {} //{System.out.println("exit");}
    public void mouseEntered(MouseEvent e) {}//{System.out.println("enter");}
    public void mouseReleased(MouseEvent e) {}//{System.out.println("release");}
    public void mousePressed(MouseEvent e) {}//{System.out.println("press");}
    public void mouseClicked(MouseEvent e) {
        int mousex=e.getX();
        int mousey=e.getY();
        System.out.println("Will place here:  x:"+(mousex)+" y:"+(mousey));
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
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int x=0;x<10;x++) {
            Line2D lin = new Line2D.Float((x*100)+XOFF,YOFF,(x*100)+XOFF,PANELSIZE+YOFF);
            g2.draw(lin);
        }
        for (int x=0;x<10;x++) {
            Line2D lin = new Line2D.Float(XOFF,(x*100)+YOFF,PANELSIZE+XOFF,(x*100)+YOFF);
            g2.draw(lin);
        }
        g2.drawRect(XOFF,YOFF,PANELSIZE,PANELSIZE);
    }
}