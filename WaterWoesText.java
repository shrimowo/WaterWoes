import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class WaterWoesText extends JDialog
{
    private String remember;
    public WaterWoesText(String question)
    {
        super (new JFrame(question),question);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(question.length()*10,100));
        JTextField reply=new JTextField();
        JButton clickMe = new JButton("enter");
        clickMe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                remember=reply.getText();
                close();
            }
        });
        this.setLayout(new GridLayout(2,1,5,5));
        this.add(reply);
        this.add(clickMe);
        this.pack();
        setModal(true);
    }
    private void close() {this.dispose();}
    public String getText(){ return remember;}
}
