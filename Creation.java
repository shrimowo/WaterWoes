import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class Creation extends JFrame
{
    int panelSize = 1000;
    Canvas myGraphic;
    Graphics fixer;
    public Creation()
    {
        setTitle("Wellington Water");
        this.getContentPane().setPreferredSize(new Dimension(panelSize+1,panelSize+1));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);
    }
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int x=0;x<10;x++) {
            Line2D lin = new Line2D.Float((x*100)+8,31,(x*100)+8,panelSize+31);
            g2.draw(lin);
        }
        for (int x=0;x<10;x++) {
            Line2D lin = new Line2D.Float(8,(x*100)+31,panelSize+8,(x*100)+31);
            g2.draw(lin);
        }
        g2.drawRect(8,31,panelSize,panelSize);
    }
}
