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
        if (mousex <= 1000 && mousey <= 562) System.out.println("<=");
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
    public WaterWoesMenu()
    {
        System.out.print('\u000C');
        setTitle("Wellington Water");
        this.getContentPane().setPreferredSize(new Dimension(504,1055));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);
        
        WaterWoesText test = new WaterWoesText("Guide to water works");
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