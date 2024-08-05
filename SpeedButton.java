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
    int timeTracker=0;
    boolean isPaused;
    Timer myTimer = new Timer();
    TimerTask task;
    GridWorkings gridEngine;
    WaterWoes waterWoes;
    private void newTimer() {
        myTimer.cancel();
        myTimer = new Timer();
        task = new TimerTask() {
            public void run() {
                timeTracker++;
                System.out.println("Water Flowed: " + timeTracker);
                gridEngine.gridTech();
            }
        };
        long timeChange = 1000 * (speed + 1);
        myTimer.scheduleAtFixedRate(task, timeChange, timeChange);
    }
    public SpeedButton(WaterWoes waterWoes)
    {
        this.waterWoes = waterWoes;
        gridEngine = new GridWorkings(waterWoes);
        slowButton = new JButton();
        slowButton.setText("Slow Flow");
        slowButton.setBounds (0,0,100,40); 
        slowButton.setFocusable(false);
        slowButton.addActionListener(this); 
        this.add(slowButton);                   
        pauseButton = new JButton();
        pauseButton.setText("Pause Flow");
        pauseButton.setBounds (100,0,100,40);  
        pauseButton.setFocusable(false); 
        pauseButton.addActionListener(this);
        this.add(pauseButton);  
        fastButton = new JButton();
        fastButton.setText("Increase Flow");
        fastButton.setBounds (200,0,100,40);  
        fastButton.setFocusable(false); 
        fastButton.addActionListener(this); 
        this.add(fastButton);
        
        setTitle("Flow Rate Monitor");
        this.getContentPane().setPreferredSize(new Dimension(300,40));  
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    

        this.pack();
        this.toFront(); 
        this.setVisible(true);
        newTimer();
        }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==fastButton){
            if (speed == 0 ) System.out.println("Flow Rate Can't Be Increased");
            else {System.out.println("Flow Rate Increased"); speed--;}
            myTimer.cancel();
            newTimer();
            isPaused = false;
        } else if  (e.getSource()==slowButton){
            if (speed >= 10 ) System.out.println("Flow Rate Can't Be Decreased");
            else {System.out.println("Flow Rate Decreased"); speed++;}
            myTimer.cancel();  
            newTimer();
            isPaused = false;
        } else if  (e.getSource()==pauseButton){
            System.out.println("Flow Rate Paused");
            isPaused=true;
            myTimer.cancel();
        }
        if (speed <= 4)setTitle("Flow Rate is Fast");
        else if (speed >= 6)setTitle("Flow Rate is Slow");
        else if (speed == 5) setTitle("Flow Rate is Normal");
        if (speed >= 10) setTitle("Flow Rate is Very Slow");
        else if (speed <= 0) setTitle("Flow Rate is Very Fast");
        if (isPaused == true)setTitle("Flow Rate is Paused");
    }
}