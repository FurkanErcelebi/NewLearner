package CarProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.nio.file.Files;

public class CarArrayList {
    ArrayList<Car> carArrayList;
    JPanel panel;
    JTable table;
    JScrollPane scrollpane;
    int i;

    public CarArrayList() {
        carArrayList = new ArrayList<Car>();
        this.i = i;
    }

    public ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return this.i;
    }

    public int AddNewCar(Car newCar) {
        boolean findVIN = false, findMakeModel = false;
        int result = 0;
        for (Car aCar : carArrayList) {
            findVIN = false;
            findMakeModel = false;
            if (aCar.getVIN().equals(newCar.getVIN())) findVIN = true;
            if ((aCar.getMake().equals(newCar.getMake())) && (aCar.getModel().equals(newCar.getModel())))
                findMakeModel = true;
            if (findVIN || findMakeModel) break;
        }
        if (!findVIN && !findMakeModel) {
            carArrayList.add(newCar);
            result = 0;
        } else if (findVIN && !findMakeModel) result = 1;

        else if (!findVIN && findMakeModel) result = 2;

        else if (findVIN && findMakeModel) result = 3;

        return result;
    }

    public boolean DeleteCar(Car oldCar) {
        boolean find = false;
        for (Car aCar : carArrayList) {
            if (aCar == oldCar) {
                System.out.println(oldCar.getVIN() + " numaralı " + oldCar.getMake() + " " + oldCar.getModel() + " adlı araç kaldırıldı");
                carArrayList.remove(oldCar);
                find = true;
                break;
            }
        }
        if (!find)
            System.err.println(oldCar.getVIN() + " numaralı " + oldCar.getMake() + " " + oldCar.getModel() + " adlı araç bulunamadı");

        return find;
    }

    public JPanel SearchCars(String searchedVIN) {
        panel = new JPanel();
        String cells[][] = new String[carArrayList.size()][7];
        String column[] = {"No", "VIN", "Marka", "Model", "Yıl", "Km/h", "Fiyat"};
        boolean find = false;
        setI(0);
        for (Car aCar : carArrayList) {
            if (aCar.getVIN().equals(searchedVIN)) {
                setI(getI() + 1);
                cells[getI() - 1] = new String[]{Integer.toString(getI()), aCar.getVIN(), aCar.getMake(), aCar.getModel(), Integer.toString(aCar.getYear()), Integer.toString(aCar.getMileage()), Double.toString(aCar.getPrice())};
                find = true;
            }
        }

        if (!find) System.err.println(searchedVIN + " numaralı araç bulunamadı");


        table = new JTable(cells, column);
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(140);
        table.getColumnModel().getColumn(4).setPreferredWidth(35);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.setBounds(0, 0, 600, 450);
        scrollpane = new JScrollPane(table);
        scrollpane.setVisible(true);
        panel.add(scrollpane);
        panel.setBounds(0, 0, 740, 500);
        return panel;
    }

    public JPanel ShowCars() {
        panel = new JPanel();
        String cells[][] = new String[carArrayList.size()][7];
        String column[] = {"No", "VIN", "Marka", "Model", "Yıl", "Km/h", "Fiyat"};
        setI(0);
        for (Car aCar : carArrayList) {
            setI(getI() + 1);
            cells[getI() - 1] = new String[]{Integer.toString(getI()), aCar.getVIN(), aCar.getMake(), aCar.getModel(), Integer.toString(aCar.getYear()), Integer.toString(aCar.getMileage()), Double.toString(aCar.getPrice())};
        }
        table = new JTable(cells, column);
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(140);
        table.getColumnModel().getColumn(4).setPreferredWidth(35);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(70);
        table.setBounds(0, 0, 600, 450);
        scrollpane = new JScrollPane(table);
        panel.add(scrollpane);
        panel.setBounds(0, 0, 740, 500);
        return panel;
    }

    public JPanel ListCars(double lowprice, double highprice) {
        panel = new JPanel();
        String cells[][] = new String[carArrayList.size()][7];
        String column[] = {"No", "VIN", "Marka", "Model", "Yıl", "Km/h", "Fiyat"};
        setI(0);
        for (Car aCar : carArrayList) {
            if (lowprice <= aCar.getPrice() && aCar.getPrice() <= highprice) {
                setI(getI() + 1);
                cells[getI() - 1] = new String[]{Integer.toString(getI()), aCar.getVIN(), aCar.getMake(), aCar.getModel(), Integer.toString(aCar.getYear()), Integer.toString(aCar.getMileage()), Double.toString(aCar.getPrice())};
            }
        }

        if (getI() == 0)
            System.out.println("Verilen Fiyat aralığında araç bulunamamıştır , bulmak için  başka bir fiyat aralığı giriniz");

        table = new JTable(cells, column);
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(140);
        table.getColumnModel().getColumn(4).setPreferredWidth(35);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.setBounds(0, 0, 600, 450);
        scrollpane = new JScrollPane(table);
        scrollpane.setVisible(true);
        panel.add(scrollpane);
        panel.setBounds(0, 0, 740, 500);
        return panel;
    }


}
