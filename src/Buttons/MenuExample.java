package Buttons;

import CarProject.Car;
import CarProject.CarArrayList;
import CarProject.CarPanel;
import CarProject.CatTable;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;

public class MenuExample implements ActionListener {
    JLabel label, inputlable, errorlable;
    JFrame f;
    JMenuBar mb;
    JMenu file;//edit,help;
    JMenuItem cut, copy, paste, selectAll, newone;
    CatTable table;
    CarPanel panel;
    JTextArea ta;
    JButton button;
    TextField text;
    JPanel labelpanel;

    MenuExample() {
        panel = new CarPanel();
        labelpanel = new JPanel();
        labelpanel.setBounds(15, 25, 700, 25);
        label = new JLabel("Girlecek kayıt için arabanın sırasıyla VIN,marka,model,üretim yılı,kilometre performansı ve fiyatını giriniz");
        label.setBounds(15, 25, 300, 30);
        labelpanel.add(label);
        int i = 0;
        inputlable = new JLabel("VIN(5 karakter giriniz,A-Z veye 0-9 karakterler bulunmalı) :");
        inputlable.setBounds(20, 20 + 50 * (i), 340, 20);
        text = new TextField("");
        text.setBounds(360, 20 + 50 * (i), 270, 20);
        errorlable = new JLabel("Girilen küçük değerde gerekli yerlerde nokta bulunmamaktadır");
        errorlable.setForeground(Color.red);
        errorlable.setBounds(20, 20 + 50 * (i) + 20, 370, 20);
        panel.add(inputlable);
        panel.add(text);
        panel.add(errorlable);
        i++;
        inputlable = new JLabel("Marka( en fazla 13 karakter giriniz ve boşlukları (_) ile doldurun) :");
        inputlable.setBounds(20, 20 + 50 * (i), 370, 20);
        text = new TextField("");
        text.setBounds(390, 20 + 50 * (i), 240, 20);
        errorlable = new JLabel("Girilen küçük değerde gerekli yerlerde nokta bulunmamaktadır");
        errorlable.setForeground(Color.red);
        errorlable.setBounds(20, 20 + 50 * (i) + 20, 370, 20);
        panel.add(inputlable);
        panel.add(text);
        panel.add(errorlable);
        i++;
        inputlable = new JLabel("Model(en fazla 19 karakter giriniz ve boşlukları (_) ile doldurun) :");
        inputlable.setBounds(20, 20 + 50 * (i), 370, 20);
        text = new TextField("");
        text.setBounds(390, 20 + 50 * (i), 240, 20);
        errorlable = new JLabel("Girilen küçük değerde gerekli yerlerde nokta bulunmamaktadır");
        errorlable.setForeground(Color.red);
        errorlable.setBounds(20, 20 + 50 * (i) + 20, 370, 20);
        panel.add(inputlable);
        panel.add(text);
        panel.add(errorlable);
        i++;
        inputlable = new JLabel("Yıl:");
        inputlable.setBounds(20, 20 + 50 * (i), 40, 20);
        text = new TextField("");
        text.setBounds(50, 20 + 50 * (i), 170, 20);
        errorlable = new JLabel("Girilen küçük değerde gerekli yerlerde nokta bulunmamaktadır");
        errorlable.setForeground(Color.red);
        errorlable.setBounds(20, 20 + 50 * (i) + 20, 370, 20);
        panel.add(inputlable);
        panel.add(text);
        panel.add(errorlable);
        i++;
        inputlable = new JLabel("Km/h:");
        inputlable.setBounds(20, 20 + 50 * (i), 50, 20);
        text = new TextField("");
        text.setBounds(50, 20 + 50 * (i), 200, 20);
        errorlable = new JLabel("Girilen küçük değerde gerekli yerlerde nokta bulunmamaktadır");
        errorlable.setForeground(Color.red);
        errorlable.setBounds(20, 20 + 50 * (i) + 20, 370, 20);
        panel.add(inputlable);
        panel.add(text);
        panel.add(errorlable);
        i++;
        inputlable = new JLabel("Fiyat(nokta ile ifade ediniz,ör:2435,0):");
        inputlable.setBounds(20, 20 + 50 * (i), 240, 20);
        text = new TextField("");
        text.setBounds(240, 20 + 50 * (i), 200, 20);
        errorlable = new JLabel("Girilen küçük değerde gerekli yerlerde nokta bulunmamaktadır");
        errorlable.setForeground(Color.red);
        errorlable.setBounds(20, 20 + 50 * (i) + 20, 370, 20);
        panel.add(inputlable);
        panel.add(text);
        panel.add(errorlable);
        i++;
        button = new JButton("Geri");
        button.setBounds(150, 30 + 50 * (i), 80, 30);
        button.addActionListener(this);
        panel.add(button);
        table = new CatTable();
        f = new JFrame();
        /*cut=new JMenuItem("cut");
        copy=new JMenuItem("copy");
        paste=new JMenuItem("paste");
        selectAll=new JMenuItem("selectAll");*/
        newone = new JMenuItem("new");
        /*cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);*/
        newone.addActionListener(this);
        mb = new JMenuBar();
        file = new JMenu("File");
        //edit=new JMenu("Edit");
        //help=new JMenu("Help");
        //edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);
        file.add(newone);
        mb.add(file);
        //mb.add(edit);mb.add(help);
        //ta=new JTextArea();
        //ta.setBounds(5,5,360,320);
        labelpanel.setEnabled(false);
        labelpanel.setVisible(false);
        panel.setVisible(false);
        panel.setEnabled(false);
        table.setEnabled(true);
        table.setVisible(true);
        f.add(table);
        f.add(labelpanel);
        f.add(panel);
        f.add(mb);//f.add(ta);
        f.setJMenuBar(mb);
        f.setSize(740, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
        if (e.getSource() == newone) {
            System.out.println("Menüler kaldırıldı");
            table.setEnabled(false);
            table.setVisible(false);
            panel.setEnabled(true);
            panel.setVisible(true);
            labelpanel.setEnabled(true);
            labelpanel.setVisible(true);
        }
        if (e.getSource() == button) {
            System.out.println("Menüler eklendi");
            labelpanel.setEnabled(false);
            labelpanel.setVisible(false);
            panel.setVisible(false);
            panel.setEnabled(false);
            table.setEnabled(true);
            table.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MenuExample();
    }
}
