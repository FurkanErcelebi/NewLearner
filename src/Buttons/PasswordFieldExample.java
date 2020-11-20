package Buttons;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class PasswordFieldExample {
    JFrame f;
    JLabel l1, l2, response;
    JPasswordField pw;
    JTextField usr;
    JButton login;

    PasswordFieldExample() {
        f = new JFrame("Password Field Example");
        pw = new JPasswordField();
        l1 = new JLabel("Password:");
        l1.setBounds(20, 100, 80, 30);
        pw.setBounds(100, 100, 100, 30);
        l2 = new JLabel("User:");
        usr = new JTextField("");
        l2.setBounds(20, 60, 60, 30);
        usr.setBounds(100, 60, 100, 30);
        login = new JButton("Login");
        login.setBounds(20, 140, 180, 30);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                response = new JLabel("User:" + usr.getText() + "Password:" + new String(pw.getPassword()));
                response.setBounds(20, 180, 340, 30);
                f.add(response);
            }
        });
        f.add(pw);
        f.add(l1);
        f.add(l2);
        f.add(usr);
        f.add(login);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new PasswordFieldExample();
    }
}
