package CarProject;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class CarDeleteValidation {


    JPanel labelpanel, panel;
    JButton button;
    JLabel nolable;
    TextField notext;
    JLabel label, noerror;
    int result;

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
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

    public JPanel DeleteValidation(CarArrayList cars) {
        panel = new JPanel();
        panel.setBounds(20, 50, 640, 380);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        if (!cars.getCarArrayList().isEmpty()) {
            nolable = new JLabel("NO:");
            nolable.setBounds(60, 20, 40, 20);
            notext = new TextField("");
            notext.setBounds(100, 20, 40, 20);
            noerror = new JLabel("");
            noerror.setBounds(50, 40, 400, 20);
            noerror.setForeground(Color.red);
            button = new JButton("Sil");
            button.setBounds(100, 60, 80, 30);
            setButton(button);
            panel.add(nolable);
            panel.add(notext);
            panel.add(noerror);
            panel.add(button);
        }
        return panel;

    }

    public int CarDeleteControl(CarArrayList cars) {
        int i = 0, size = cars.carArrayList.size();
        boolean correct;
        String index, regular_expression, matched;
        if (!cars.getCarArrayList().isEmpty()) {
            index = notext.getText();
            correct = false;
            regular_expression = "(\\d)?(\\d)?(\\d)";
            matched = index;
            if (!Pattern.matches(regular_expression, matched)) {
                noerror.setText("1 ile 3 karakter uzunluğunda olmalı ve sayılardan oluşmalı");
            } else {
                i = Integer.parseInt(index);
                if (size < i) {
                    noerror.setText("Şuna eşit veya daha küçük bir numara giriniz :" + Integer.toString(size));
                } else correct = true;
            }
            if (correct) {
                notext.setText("");
                noerror.setText("");
                setResult(i);
                return 0;
            } else {
                return 1;
            }
        } else return 2;
    }
}
