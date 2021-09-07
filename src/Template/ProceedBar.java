package Template;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

class ProceedBar {

    static JFrame frame;

    static JPanel panel;
    
    static JProgressBar bar; 

    public ProceedBar(){
        frame = new JFrame("Progress Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        bar = new JProgressBar();
        bar.setStringPainted(true);
    }

    static void continueProgress()throws InterruptedException{

        Thread.sleep(500);
        
        for(int i = 0;i < 100;i++){

            bar.setString(String.valueOf(i) + "% " + ((i < 50) ? "InProgress..." : ((i < 75) ? "Soon..." : "Nearly Complete...")));
            Thread.sleep(500);

        }
        bar.setString("100% Completed...");

    }

    public static void main(String[] args) throws InterruptedException {
        
        new ProceedBar();
        bar.setValue(0);
        
        panel.add(bar);
        
        frame.add(panel);
        frame.setSize(450, 450);
        frame.setVisible(true);

        continueProgress();
        bar.setOrientation(SwingConstants.VERTICAL);
        continueProgress();

    }

}