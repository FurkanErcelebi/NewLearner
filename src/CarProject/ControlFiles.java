package CarProject;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.FileReader;
import java.util.Arrays;

public class ControlFiles {
    String path;
    String file;

    public ControlFiles(String path, String file) {
        this.path = path;
        this.file = file;
    }

    public String getPath() {
        return this.path;
    }

    public String getFile() {
        return this.file;
    }

    public void ReadCarFile(CarArrayList cars) throws IOException {
        StringBuilder element = new StringBuilder();
        FileReader fr = new FileReader(getPath() + getFile());
        String VIN = "", make = "", model;
        int i = 1, c, index = 0, a, j, space[] = new int[3], k, year, mileage, reuslt;
        double price;
        boolean exit = false;
        c = fr.read();
        do {
            if (c == 32 || c == 10) {
                if (i == 1) {
                    index++;
                    System.out.println("\n" + index + ". Araba");
                    VIN = String.valueOf(element).trim();
                    element = new StringBuilder("");
                } else if (i == 2) {
                    if (element.toString().equals("Land")) {
                        i = 1;
                        element.append((char) c);
                    } else {
                        make = String.valueOf(element);
                        element = new StringBuilder("");
                    }
                } else {
                    if (element.length() >= 3) {
                        j = element.length();
                        element.trimToSize();
                        if (element.charAt(j - 3) == 46 || element.charAt(j - 2) == 46) {
                            k = 0;
                            while (k < 3) {
                                j--;
                                if (element.charAt(j) == 32) {
                                    space[k] = j;
                                    k++;
                                }
                            }
                            model = element.substring(0, space[2]);
                            year = Integer.parseInt(element.substring(space[2] + 1, space[1]));
                            mileage = Integer.parseInt(element.substring(space[1] + 1, space[0]));
                            price = Double.parseDouble(element.substring(space[0] + 1, element.length()));
                            element = new StringBuilder("");
                            i = 0;

                            Car newcar = new Car(VIN, make, model, year, mileage, price);
                            reuslt = cars.AddNewCar(newcar);
                            System.out.println(cars.carArrayList.indexOf(newcar));
                            if (0 == reuslt) System.out.println("Araç kaydı eklendi");
                            else if (1 == reuslt) System.out.println("Araçla aynı VIN numaralı kayıt var");
                            else if (2 == reuslt)
                                System.out.println("Araçla aynı marka ve model ismine sahisp kayıt var");
                            else if (3 == reuslt)
                                System.out.println("Araçla yanı VIN , marka ve model ismine sahip kayıt var");
                        }
                    }
                    if (c == 32) element.append((char) c);
                }
                i++;
            } else if (c != -1) element.append((char) c);
            if (c == -1) exit = true;
            else c = fr.read();
        } while (!exit);

        fr.close();
    }

    public void WriteCarFile(CarArrayList cars) {
        try {
            FileWriter fw = new FileWriter(getPath() + getFile());
            fw.write("");
            for (Car aCar : cars.getCarArrayList())
                fw.append(aCar.VIN + " " + aCar.make + " " + aCar.model + " " + aCar.year + " " + aCar.mileage + " " + aCar.price + "\n");
            cars.getCarArrayList().clear();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Yeni Kayıtlar Yazıldı");
    }
}
