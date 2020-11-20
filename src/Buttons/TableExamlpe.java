package Buttons;

import CarProject.Car;
import CarProject.CarArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class TableExamlpe {
    public static void main(String[] a) {
        Car Car1 = new Car("1GTN1", "Volkswagen", "Touareg", 2007, 153325, 73684.52);
        Car Car2 = new Car("1N4AA", "Lamborghini", "Diablo", 1993, 112682, 147119.08);
        Car Car3 = new Car("1GYUK", "Buick", "Regal", 2012, 107870, 86333.26);
        CarArrayList cars = new CarArrayList();
        cars.AddNewCar(Car1);
        cars.AddNewCar(Car2);
        cars.AddNewCar(Car3);
        JFrame f = new JFrame("Table Example");
        /*String data[][]={ {"101","Amit","670000"},
                {"102","Jai","780000"},
                {"101","Sachin","700000"}};*/
        String cells[][] = {{Car1.getVIN(), Car1.getMake(), Car1.getModel(), Integer.toString(Car1.getYear()), Integer.toString(Car1.getMileage()), Double.toString(Car1.getPrice())},
                {Car2.getVIN(), Car2.getMake(), Car2.getModel(), Integer.toString(Car2.getYear()), Integer.toString(Car2.getMileage()), Double.toString(Car2.getPrice())},
                {Car3.getVIN(), Car3.getMake(), Car3.getModel(), Integer.toString(Car3.getYear()), Integer.toString(Car3.getMileage()), Double.toString(Car3.getPrice())}};
        String column[] = {"VIN", "Marka", "Model", "Yıl", "Km/h", "Fiyat"};//{"ID","NAME","SALARY",};
        /*final*/
        JTable jt = new JTable(cells, column);/*
        jt.setCellSelectionEnabled(true);
        ListSelectionModel select= jt.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = jt.getSelectedRows();
                int[] columns = jt.getSelectedColumns();
                for (int i = 0; i < row.length; i++) {
                    for (int j = 0; j < columns.length; j++) {
                        Data = (String) jt.getValueAt(row[i], columns[j]);
                    } }
                System.out.println("Table element selected is: " + Data);
            }
        });*/
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
