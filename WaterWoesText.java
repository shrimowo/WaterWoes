//imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Returns user input from generated dialogue box
 * 
 * Emmett Petty
 * 5/08/24
 */
public class WaterWoesText extends JDialog
{
    private String remember; //User input
    public WaterWoesText(String question) //Constuctor
    {
        //Size and JFrame
        super (new JFrame(question),question);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(question.length()*10,100));
        
        //Initialize reply string and button
        JTextField reply=new JTextField();
        JButton clickMe = new JButton("enter");
        
        clickMe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Get user response and closed
                remember=reply.getText();
                close();
            }
        });
        
        //Settings
        this.setLayout(new GridLayout(2,1,5,5));
        this.add(reply);
        this.add(clickMe);
        this.pack();
        setModal(true);
    }
    private void close() {this.dispose();} //Close
    public String getText(){ return remember;} //Return user input
}