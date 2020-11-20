package Buttons;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.event.*;

public class source {
    source() {
        JFrame f = new JFrame("Button Example");
        JButton b = new JButton(new ImageIcon("C:\\Users\\ifurk\\OneDrive\\Pictures\\612863B3-B60E-40F3-9DDF-F4C8B5804780"));
        b.setBounds(100, 100, 100, 40);
        f.add(b);
        f.setSize(300, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new source();
        /*JFrame f=new JFrame("Button Example");
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);
        JButton b=new JButton("Click Here");
        b.setBounds(50,100,95,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome to Javatpoint.");
            }
        });
        f.add(b);f.add(tf);
        f.add(b);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);*/
    }
}
