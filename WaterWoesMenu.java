import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
  // Gnomenu |formerly gabathrol| \\
    // Coding a menu 14/02/2024 \\
public class WaterWoesMenu extends JFrame implements ActionListener, MouseListener{
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;
    public void mouseExited(MouseEvent e) {} //{System.out.println("exit");}
    public void mouseEntered(MouseEvent e) {}//{System.out.println("enter");}
    public void mouseReleased(MouseEvent e) {}//{System.out.println("release");}
    public void mousePressed(MouseEvent e) {}//{System.out.println("press");}
    public void mouseClicked(MouseEvent e) {
        int mousex=e.getX();
        int mousey=e.getY();
        if (mousex <= 504 && mousey <= 1055) System.out.println("<=");
    }
    public void paint (Graphics g) {
        final String fileName="Gnome.JPG";
        ImageIcon image= new ImageIcon(fileName);
        super.paint(g);
        image.paintIcon(this,g,0,55);
    }
    void createDialog(){
        JDialog box = new JDialog(this);
        box.setBounds(400,400,120,90);
        TextArea area = new TextArea("Thank You For Shopping With Us!");
        area.setEditable(false);
        box.add(area);
        box.toFront();
        box.setVisible(true);
        box.setTitle("Gnome Receipt");
    }
    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        switch(cmd){
            case "Gnome House" : System.out.println("House purchased"); createDialog();
                break;
            case "Mushroom Seeds" : System.out.println("Seeds purchased"); createDialog();
                break;
            case "Phrygian Cap" : System.out.println("Cap purchased"); createDialog();
                break;
            case "Small Boots" : System.out.println("Boots purchased"); createDialog();
                break;
            case "QUIT" : System.exit(0);
                break;
        }
    }
    public WaterWoesMenu()
    {
        System.out.print('\u000C');
        setTitle("Gnome Store"); //Formerly gnome harvest
        this.getContentPane().setPreferredSize(new Dimension(504,1055));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);
        
        WaterWoesText test = new WaterWoesText("zaza");
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
        
        menu = new JMenu("gnomenu");
        menuBar.add(menu);
        
        menuItem=new JMenuItem("Gnome House");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('h'));
        menu.add(menuItem);
        this.pack();
        
        menuItem=new JMenuItem("Mushroom Seeds");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('s'));
        menu.add(menuItem);
        this.pack();
        
        menuItem=new JMenuItem("Phrygian Cap");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('c'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        this.pack();    
        
        menuItem=new JMenuItem("Small Boots");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('b'));
        menu.add(menuItem);
        this.pack();  
        
        menuItem=new JMenuItem("QUIT");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('q'));
        menu.add(menuItem);
        this.pack();  
    }
}