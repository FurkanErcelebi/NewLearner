package CarProject;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CarSearchValidation {

    JPanel labelpanel, panel;
    JButton button;
    JLabel VINsearchlable;
    TextField VINsearchtext;
    JLabel label, VINsearcherror;
    String result;


    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JButton getButton() {
        return button;
    }

    public JPanel Header(String title) {
        labelpanel = new JPanel();
        labelpanel.setBounds(20, 25, 700, 20);
        label = new JLabel(title);
        label.setBounds(20, 25, 600, 20);
        labelpanel.add(label);
        return labelpanel;
    }

    public JPanel CarSearchValidation(CarArrayList cars) {
        panel = new JPanel();
        panel.setBounds(20, 50, 640, 380);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

//        if (!cars.getCarArrayList().isEmpty()) {
            VINsearchlable = new JLabel("VIN(5 karakter giriniz,A-Z veye 0-9 karakterler bulunmalı) :");
            VINsearchlable.setBounds(20, 20, 340, 20);
            VINsearchtext = new TextField("");
            VINsearchtext.setBounds(390, 20, 80, 20);
            VINsearcherror = new JLabel();
            VINsearcherror.setForeground(Color.red);
            VINsearcherror.setBounds(20, 40, 370, 20);
            button = new JButton("Ara");
            button.setBounds(100, 70, 80, 30);
            setButton(button);
            panel.add(VINsearchlable);
            panel.add(VINsearchtext);
            panel.add(VINsearcherror);
            panel.add(button);
//        }
        return panel;
    }

    public boolean CarSearchControl() {
        boolean VINcorrect = false, correct;
        String VIN, regular_expression, matched;
        VIN = VINsearchtext.getText();
        correct = false;
        regular_expression = "[A-Z0-9]{5}";
        matched = VIN;
        if (!Pattern.matches(regular_expression, matched)) {
            VINsearcherror.setText("Girilecek numara 5 karakter uzunluğunda , büyük harf ve sayı karakterinden oluşmalı");
        } else {
            regular_expression = "[A-Z]*[\\d]?[A-Z]*[\\d]?[A-Z]*";
            if (!Pattern.matches(regular_expression, matched)) {
                VINsearcherror.setText("Numarada en fazla 2 sayıdan ve diğerleri büyük harflerden oluşmalı");
            } else VINcorrect = true;
        }
        if (VINcorrect) {
            setResult(VIN);
            VINsearchtext.setText("");
            VINsearcherror.setText("");
        }

        return correct;
    }
}
