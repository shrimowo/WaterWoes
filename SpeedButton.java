import javax.swing.JFrame;   
import javax.swing.JButton;   
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
public class SpeedButton extends JFrame implements ActionListener{
    JButton slowButton;
    JButton pauseButton;
    JButton fastButton;
    public int speed=5;
    public int timeTracker=0;
    Timer myTimer = new Timer();
    TimerTask task;
    private void newTimer() {
        myTimer.cancel();
        myTimer = new Timer();
        task = new TimerTask() {
            public void run() {
                timeTracker++;
                System.out.println("Water Flowed: " + timeTracker);
            }
        };
        long timeChange = 1000 * (speed + 1);
        myTimer.scheduleAtFixedRate(task, timeChange, timeChange);
    }
    public SpeedButton()
    {
        slowButton = new JButton();
        slowButton.setText("Slow Flow");
        slowButton.setBounds (0,0,100,40);  //x,y,width,height.
        slowButton.setFocusable(false); // remove box around text in button
        slowButton.addActionListener(this); // we are implmenting the ActionListener in this interface.
        this.add(slowButton);                    // add to frame
        pauseButton = new JButton();
        pauseButton.setText("Pause Flow");
        pauseButton.setBounds (100,0,100,40);  //x,y,width,height.
        pauseButton.setFocusable(false); // remove box around text in button
        pauseButton.addActionListener(this); // we are implmenting the ActionListener in this interface.
        this.add(pauseButton);  
        fastButton = new JButton();
        fastButton.setText("Increase Flow");
        fastButton.setBounds (200,0,100,40);  //x,y,width,height.
        fastButton.setFocusable(false); // remove box around text in button
        fastButton.addActionListener(this); // we are implmenting the ActionListener in this interface.
        this.add(fastButton);
        // add to frame
        setTitle("Flow Rate Monitor");  //Whateveryou want the window to be called.
        this.getContentPane().setPreferredSize(new Dimension(300,40));  
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    

        this.pack();
        this.toFront();  // Not too sure what this does, commenting out makes no apparent difference
        this.setVisible(true);
        newTimer();
        }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==fastButton){
            if (speed == 0 ) System.out.println("Flow Rate Can't Be Increased");
            else {System.out.println("Flow Rate Increased"); speed--;}
            setTitle("Flow Rate is at: "+speed+" Units per Second");
            myTimer.cancel();
            newTimer();
        } else if  (e.getSource()==slowButton){
            if (speed >= 10 ) System.out.println("Flow Rate Can't Be Decreased");
            else {System.out.println("Flow Rate Decreased"); speed++;}
            setTitle("Flow Rate is at: "+speed+" Units per Second");
            myTimer.cancel();  
            newTimer();
        } else if  (e.getSource()==pauseButton){
            System.out.println("Flow Rate Paused");
            setTitle("Flow Rate Paused");
            myTimer.cancel();
        }
    }
}