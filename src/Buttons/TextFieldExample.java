package Buttons;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class TextFieldExample implements ActionListener {
    JFrame f;
    JButton inc, dec;
    JTextField var1, var2, sum;

    TextFieldExample() {
        f = new JFrame("TextField Example");
        var1 = new JTextField("");
        var1.setBounds(30, 15, 200, 60);
        var2 = new JTextField("");
        var2.setBounds(30, 100, 200, 60);
        inc = new JButton("+");
        dec = new JButton("-");
        inc.setBounds(30, 185, 40, 40);
        dec.setBounds(80, 185, 40, 40);
        inc.addActionListener(this);
        dec.addActionListener(this);
        f.add(var1);
        f.add(var2);
        f.add(inc);
        f.add(dec);//f.add(sum);
        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(var1.getText());
        int b = Integer.parseInt(var2.getText());
        int c = 0;
        sum = new JTextField("");
        sum.setBounds(30, 270, 200, 60);
        if (e.getSource() == inc) {
            c = a + b;
        } else if (e.getSource() == dec) {
            c = a - b;
        }
        sum.setText(Integer.toString(c));
        f.add(sum);
    }

    public static void main(String args[]) {
        new TextFieldExample();
    }
}
