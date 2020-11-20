package CarProject;

import javax.swing.*;
import java.awt.*;

public class CatTable extends JPanel {

    JScrollPane sp;
    JTable jt;

    public CatTable() {
        Car Car1 = new Car("1GTN1", "Volkswagen", "Touareg", 2007, 153325, 73684.52);
        Car Car2 = new Car("1N4AA", "Lamborghini", "Diablo", 1993, 112682, 147119.08);
        Car Car3 = new Car("WVGAV", "Land Rover", "Range Rover Sport", 2012, 159904, 99251.8);
        CarArrayList cars = new CarArrayList();
        cars.AddNewCar(Car1);
        cars.AddNewCar(Car2);
        cars.AddNewCar(Car3);
        String cells[][] = new String[cars.carArrayList.size()][7];
        int i = 1;
        for (Car aCar : cars.carArrayList) {
            cells[i - 1] = new String[]{Integer.toString(i++), aCar.getVIN(), aCar.getMake(), aCar.getModel(), Integer.toString(aCar.getYear()), Integer.toString(aCar.getMileage()), Double.toString(aCar.getPrice())};
        }
       /* String cells[][]={{Car1.getVIN(),Car1.getMake(),Car1.getModel(),Integer.toString(Car1.getYear()),Integer.toString(Car1.getMileage()),Double.toString(Car1.getPrice())},
                {Car2.getVIN(),Car2.getMake(),Car2.getModel(),Integer.toString(Car2.getYear()),Integer.toString(Car2.getMileage()),Double.toString(Car2.getPrice())},
                {Car3.getVIN(),Car3.getMake(),Car3.getModel(),Integer.toString(Car3.getYear()),Integer.toString(Car3.getMileage()),Double.toString(Car3.getPrice())}};*/
        String column[] = {"No", "VIN", "Marka", "Model", "Yıl", "Km/h", "Fiyat"};
        jt = new JTable(cells, column);
        jt.setDefaultEditor(Object.class, null);
        jt.getColumnModel().getColumn(0).setPreferredWidth(25);
        jt.getColumnModel().getColumn(1).setPreferredWidth(70);
        jt.getColumnModel().getColumn(2).setPreferredWidth(90);
        jt.getColumnModel().getColumn(3).setPreferredWidth(140);
        jt.getColumnModel().getColumn(4).setPreferredWidth(35);
        jt.getColumnModel().getColumn(5).setPreferredWidth(60);
        jt.getColumnModel().getColumn(6).setPreferredWidth(80);
        jt.setBounds(0, 0, 600, 450);
        sp = new JScrollPane(jt);
        sp.setVisible(true);
        this.setBounds(0, 0, 740, 500);
        this.add(sp);
        this.setBackground(Color.cyan);
    }
}

