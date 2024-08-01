import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Creation extends JFrame implements ActionListener, MouseListener{
    final int PANELSIZE = 1000;
    Canvas myGraphic;
    Graphics fixer;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    public Creation()
    {
        setTitle("Wellington Water");
        this.getContentPane().setPreferredSize(new Dimension(PANELSIZE+1,PANELSIZE+1));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);
        
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
    public void mouseExited(MouseEvent e) {} //{System.out.println("exit");}
    public void mouseEntered(MouseEvent e) {}//{System.out.println("enter");}
    public void mouseReleased(MouseEvent e) {}//{System.out.println("release");}
    public void mousePressed(MouseEvent e) {}//{System.out.println("press");}
    public void mouseClicked(MouseEvent e) {
        int mousex=e.getX();
        int mousey=e.getY();
        System.out.println("Will place here:  x:"+(mousex)+" y:"+(mousey));
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
            Line2D lin = new Line2D.Float((x*100)+8,31,(x*100)+8,PANELSIZE+31);
            g2.draw(lin);
        }
        for (int x=0;x<10;x++) {
            Line2D lin = new Line2D.Float(8,(x*100)+31,PANELSIZE+8,(x*100)+31);
            g2.draw(lin);
        }
        g2.drawRect(8,31,PANELSIZE,PANELSIZE);
    }
}
