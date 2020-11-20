package CarProject;

import javax.swing.*;
import java.awt.*;
import java.time.Year;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CarAddValidation {

    JPanel labelpanel, panel;
    JButton button;
    JLabel VINlable, makelable, modellable, yearlable, mileagelable, pricelable;
    TextField VINtext, maketext, modeltext, yeartext, mileagetext, pricetext;
    JLabel label, VINerror, makeerror, modelerror, yearerror, mileageerror, priceerror;
    Car newCar;

    public void setNewCar(Car newCar) {
        this.newCar = newCar;
    }

    public Car getNewCar() {
        return this.newCar;
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

    public JPanel CarAttributesValidation() {
        panel = new JPanel();
        panel.setBounds(20, 50, 640, 380);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        VINlable = new JLabel("VIN(5 karakter giriniz,A-Z veye 0-9 karakterler bulunmalı) :");
        VINlable.setBounds(50, 20, 340, 20);
        VINtext = new TextField("");
        VINtext.setBounds(390, 20, 80, 20);
        VINerror = new JLabel();
        VINerror.setForeground(Color.red);
        VINerror.setBounds(20, 40, 480, 20);
        panel.add(VINlable);
        panel.add(VINtext);
        panel.add(VINerror);

        makelable = new JLabel("Marka(en fazla 13 karakter giriniz ve boşlukları (_) ile doldurun) :");
        makelable.setBounds(20, 70, 370, 20);
        maketext = new TextField("");
        maketext.setBounds(390, 70, 120, 20);
        makeerror = new JLabel("");
        makeerror.setForeground(Color.red);
        makeerror.setBounds(20, 90, 370, 20);
        panel.add(makelable);
        panel.add(maketext);
        panel.add(makeerror);

        modellable = new JLabel("Model(en fazla 19 karakter giriniz ve boşlukları (_) ile doldurun) :");
        modellable.setBounds(20, 120, 370, 20);
        modeltext = new TextField("");
        modeltext.setBounds(390, 120, 240, 20);
        modelerror = new JLabel("");
        modelerror.setForeground(Color.red);
        modelerror.setBounds(20, 140, 370, 20);
        panel.add(modellable);
        panel.add(modeltext);
        panel.add(modelerror);

        yearlable = new JLabel("Yıl:");
        yearlable.setBounds(360, 170, 30, 20);
        yeartext = new TextField("");
        yeartext.setBounds(390, 170, 70, 20);
        yearerror = new JLabel("");
        yearerror.setForeground(Color.red);
        yearerror.setBounds(300, 190, 370, 20);
        panel.add(yearlable);
        panel.add(yeartext);
        panel.add(yearerror);

        mileagelable = new JLabel("Km/h:");
        mileagelable.setBounds(350, 220, 40, 20);
        mileagetext = new TextField("");
        mileagetext.setBounds(390, 220, 100, 20);
        mileageerror = new JLabel("");
        mileageerror.setForeground(Color.red);
        mileageerror.setBounds(200, 240, 440, 20);
        panel.add(mileagelable);
        panel.add(mileagetext);
        panel.add(mileageerror);

        pricelable = new JLabel("Fiyat(nokta ile ifade ediniz,ör:2435.0):");
        pricelable.setBounds(170, 270, 220, 20);
        pricetext = new TextField("");
        pricetext.setBounds(390, 270, 200, 20);
        priceerror = new JLabel("");
        priceerror.setForeground(Color.red);
        priceerror.setBounds(170, 290, 450, 20);
        panel.add(pricelable);
        panel.add(pricetext);
        panel.add(priceerror);

        button = new JButton("Ekle");
        button.setBounds(280, 330, 80, 30);
        setButton(button);
        panel.add(button);
        return panel;
    }

    public int CarAtrributeControl(CarArrayList cars) {
        String VIN = "", make = "", model = "", newmake = "", newmodel = "", year = "", mileage = "", price = "", regular_expression, matched;
        boolean VINcorrect, makecorrect, modelcorrect, yearcorrect, mileagecorrect, pricecorrect;
        Scanner input = new Scanner(System.in);
        int i, numyear = 0, nummileage = 0, dot = 0, number, character, deci, one;
        double numprice = 0.0;
        VIN = VINtext.getText();
        VINerror.setText("");
        VINcorrect = false;
        regular_expression = "[A-Z0-9]{5}";
        matched = VIN;
        if (!Pattern.matches(regular_expression, matched)) {
            VINerror.setText("Girilecek numara 5 karakter uzunluğunda , büyük harf ve sayı karakterinden oluşmalı");
        } else {
            regular_expression = "[A-Z]*[\\d]?[A-Z]*[\\d]?[A-Z]*";
            if (!Pattern.matches(regular_expression, matched)) {
                VINerror.setText("Numarada en fazla 2 sayıdan ve diğerleri büyük harflerden oluşmalı");
            } else VINcorrect = true;
        }
        makecorrect = false;
        make = maketext.getText();
        newmake = make.replace("_", " ");
        if (newmake.length() > 14) {
            makeerror.setText("Marka ismi 13 karakterden uzun olmamalı");
        } else if (newmake.length() == 0) {
            makeerror.setText("Girdi alanı boş");
        } else makecorrect = true;
        modelcorrect = false;
        model = modeltext.getText();
        newmodel = model.replace("_", " ");
        modelerror.setText("");
        if (newmodel.length() > 20) {
            modelerror.setText("lütfen 20'den fazla karakter girmeyiniz");
        } else if (newmodel.length() == 0) {
            modelerror.setText("Gidi alanı boş");
        } else modelcorrect = true;
        yearcorrect = false;
        year = yeartext.getText();
        yearerror.setText("");
        Year curryear = Year.now();
        regular_expression = "[0-9]{4}";
        matched = year;
        if (!Pattern.matches(regular_expression, matched)) {
            yearerror.setText("Girilecek numara 4 karakterli ve sadece sayılardan olmalı");
        } else {
            one = Integer.parseInt(curryear.toString()) % 10;
            deci = (Integer.parseInt(curryear.toString()) % 100 - one) / 10;
            regular_expression = "(18(\\d)(\\d))|(19(\\d)(\\d))|20[0-" + Integer.toString(deci) + "][0-" + Integer.toString(one) + "]";
            if (!Pattern.matches(regular_expression, year)) {
                yearerror.setText("1800 ile " + curryear.toString() + " arasında bir yıl giriniz");
            } else {
                numyear = Integer.parseInt(year);
                yearcorrect = true;
            }
        }
        mileagecorrect = false;
        mileage = mileagetext.getText();
        mileageerror.setText("");
        regular_expression = "[0-9]{5,6}";
        matched = mileage;
        if (!Pattern.matches(regular_expression, matched)) {
            mileageerror.setText("Girilecek numara 6 veya 5 karakter zunluğunda ve sadece sayilardan olmalı");
        } else {
            regular_expression = "([4-9][5-9](\\d)(\\d)(\\d)|(1)?(\\d)(\\d)(\\d)(\\d)(\\d))|200000";
            if (!Pattern.matches(regular_expression, matched)) {
                mileageerror.setText("45000 ile 200000 arasında bir değer olmalı");
            } else {
                nummileage = Integer.parseInt(mileage);
                mileagecorrect = true;
            }
        }
        pricecorrect = false;
        price = pricetext.getText();
        priceerror.setText("");
        regular_expression = "(.){7,9}";
        matched = price;
        if (!Pattern.matches(regular_expression, matched)) {
            priceerror.setText("Girilecek numara 7 ile 9 karakterden arasında uzunluk olmalı");
        } else {
            regular_expression = "[2-9](\\d)(\\d)(\\d).(\\d)(\\d)?|(1)?(\\d)(\\d)(\\d)(\\d)(\\d).(\\d)(\\d)?|200000.(\\d)(\\d)?";
            if (!Pattern.matches(regular_expression, matched)) {
                priceerror.setText("2000.0 ile 200000.99 arasında sayısal bir değer olmalı ve nokta bulunmalı");
            } else {
                numprice = Double.parseDouble(price);
                pricecorrect = true;
            }
        }

        if (VINcorrect && makecorrect && modelcorrect && yearcorrect && mileagecorrect && pricecorrect) {
            setNewCar(new Car(VIN, newmake, newmodel, numyear, nummileage, numprice));
            VINtext.setText("");
            VINerror.setText("");
            maketext.setText("");
            makeerror.setText("");
            modeltext.setText("");
            modelerror.setText("");
            yeartext.setText("");
            yearerror.setText("");
            mileagetext.setText("");
            mileageerror.setText("");
            pricetext.setText("");
            priceerror.setText("");
            System.out.println("=============================Yeni_Araba_Kaydı-Eklendi==========================\n");
            return 0;
        } else return 1;
    }

}
