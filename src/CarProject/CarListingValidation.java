package CarProject;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CarListingValidation {


    JPanel labelpanel, panel;
    JButton button;
    JLabel pricelable1, pricelable2;
    TextField pricetext1, pricetext2;
    JLabel label, priceerror1, priceerror2;
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

    public JPanel CarListingValidation(CarArrayList cars) {
        panel = new JPanel();
        panel.setBounds(20, 50, 640, 380);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

//        if (!cars.getCarArrayList().isEmpty()) {
            pricelable1 = new JLabel("En küçük(nokta ile ifade ediniz,ör:2435.0) :");
            pricelable1.setBounds(20, 20, 250, 20);
            pricetext1 = new TextField("");
            pricetext1.setBounds(270, 20, 80, 20);
            priceerror1 = new JLabel();
            priceerror1.setForeground(Color.red);
            priceerror1.setBounds(20, 40, 370, 60);
            panel.add(pricelable1);
            panel.add(pricetext1);
            panel.add(priceerror1);
            pricelable2 = new JLabel("En büyük(nokta ile ifade ediniz,ör:2435.0) :");
            pricelable2.setBounds(20, 100, 255, 20);
            pricetext2 = new TextField("");
            pricetext2.setBounds(275, 100, 80, 20);
            priceerror2 = new JLabel();
            priceerror2.setForeground(Color.red);
            priceerror2.setBounds(20, 120, 370, 60);
            button = new JButton("Ara");
            button.setBounds(100, 190, 80, 30);
            setButton(button);
            panel.add(pricelable2);
            panel.add(pricetext2);
            panel.add(priceerror2);
            panel.add(button);
//        }
        return panel;
    }

    public int CarListingControl() {
        String lprice, hprice, temp, regular_expression, matched1, matched2;
        int i = 0;
        double numlprice = 0.0, numhprice = 0.0;
        boolean totalcorrect, highcorrect, lowcorrect;
        lprice = pricetext1.getText();
        hprice = pricetext2.getText();
        totalcorrect = false;
        priceerror1.setText("");
        priceerror2.setText("");
        regular_expression = "(.){7,9}";
        matched1 = lprice;
        matched2 = hprice;
        if (!Pattern.matches(regular_expression, matched1) || !Pattern.matches(regular_expression, matched2)) {
            if (!Pattern.matches(regular_expression, matched1))
                priceerror1.setText("Girilecek küçük değer 7 ile 9 karakterler arasında uzunluk olmalı");
            if (!Pattern.matches(regular_expression, matched2))
                priceerror2.setText("Girilecek büyük değer 7 ila 9 karakterler arasında uzunluk olmalı");
        } else {
            regular_expression = "[2-9](\\d)(\\d)(\\d).(\\d)(\\d)?|(1)?(\\d)(\\d)(\\d)(\\d)(\\d).(\\d)(\\d)?|200000.(\\d)(\\d)?";
            if (!Pattern.matches(regular_expression, matched1) || !Pattern.matches(regular_expression, matched2)) {
                if (!Pattern.matches(regular_expression, matched1))
                    priceerror1.setText("45000.0 ile 200000.99 arasında bir değer olmalı ve nokta bulunmalı");
                if (!Pattern.matches(regular_expression, matched2))
                    priceerror2.setText("45000.0 ile 200000.99 arasında bir değer olmalı ve nokta bulunmalı");
            } else {
                numhprice = Double.parseDouble(hprice);
                numlprice = Double.parseDouble(lprice);
                i = 0;
                if (numhprice == numlprice) {
                    priceerror1.setText("Büyük değerlerle aynı,farklı değerler giriniz");
                    priceerror2.setText("Küçük değerlerle aynı,farklı değerler giriniz");
                } else i++;
                if (numlprice > numhprice) {
                    if (i != 0) {
                        temp = priceerror1.getText();
                        priceerror1.setText(temp + "\nGirilen değer en büyük değerden büyük");
                        temp = priceerror2.getText();
                        priceerror2.setText(temp + "\nGirilen değer en küçük değerden küçük");
                    } else {
                        priceerror1.setText("Girilen değer en büyük değerden büyük");
                        priceerror2.setText("Girilen değer en küçük değerden küçük");
                    }
                } else i++;
                if (i == 2) totalcorrect = true;
            }
        }
        if (totalcorrect) {
            setResult(lprice + "-" + hprice);
            pricetext1.setText("");
            priceerror1.setText("");
            pricetext2.setText("");
            priceerror2.setText("");
            return 0;
        } else return 1;

    }
}
