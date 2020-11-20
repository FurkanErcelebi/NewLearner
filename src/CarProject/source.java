package CarProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.regex.*;


public class source implements ActionListener {
    JPanel table, alttable, addertitle, adderpanel, delltitle, dellpanel, searchtitle, searchpanel, listingtitle, listingpanel;
    JButton adderbutton, dellbutton, searchbutton, listingbutton;
    JMenuItem add, dell, view, search, listing;
    JFrame app;
    CarArrayList cars = new CarArrayList();
    CarAddValidation adding = new CarAddValidation();
    CarDeleteValidation deleting = new CarDeleteValidation();
    CarSearchValidation searching = new CarSearchValidation();
    CarListingValidation listingcar = new CarListingValidation();

    source() {
        String path = "C:\\Users\\ifurk\\OneDrive\\Desktop\\";
        ControlFiles files = new ControlFiles(path, "car.txt");

        try {
            files.ReadCarFile(cars);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("=======================================================\n");
        app = new JFrame("Araba tablosu");
        JMenu record = new JMenu("Kayıt");
        JMenu list = new JMenu("Liste");
        JMenu select = new JMenu("Seçim");
        add = new JMenuItem("Ekle");
        dell = new JMenuItem("Sil");
        view = new JMenuItem("Gör");
        search = new JMenuItem("Ara");
        listing = new JMenuItem("Listele");
        add.addActionListener(this);
        dell.addActionListener(this);
        view.addActionListener(this);
        search.addActionListener(this);
        listing.addActionListener(this);
        JMenuBar menubar = new JMenuBar();
        select.add(search);
        select.add(listing);
        record.add(add);
        record.add(dell);
        list.add(view);
        menubar.add(list);
        menubar.add(record);
        menubar.add(select);
        table = cars.ShowCars();
        alttable = new JPanel();
        if (1 == cars.getI()) JOptionPane.showMessageDialog(app, "Kayıtlar boş", "Dikkat", JOptionPane.WARNING_MESSAGE);
        addertitle = adding.Header("Girlecek kayıt için arabanın sırasıyla VIN,marka,model,üretim yılı,kilometre performansı ve fiyatını giriniz");
        adderpanel = adding.CarAttributesValidation();
        app.add(addertitle);
        app.add(adderpanel);
        adderbutton = adding.getButton();
        adderbutton.addActionListener(this);
        delltitle = deleting.Header("");
        dellpanel = deleting.DeleteValidation(cars);
        app.add(delltitle);
        app.add(dellpanel);
        dellbutton = deleting.getButton();
        dellbutton.addActionListener(this);
        searchtitle = searching.Header("");
        searchpanel = searching.CarSearchValidation(cars);
        app.add(searchtitle);
        app.add(searchpanel);
        searchbutton = searching.getButton();
        searchbutton.addActionListener(this);
        listingtitle = listingcar.Header("");
        listingpanel = listingcar.CarListingValidation(cars);
        app.add(listingtitle);
        app.add(listingpanel);
        listingbutton = listingcar.getButton();
        listingbutton.addActionListener(this);
        app.setSize(700, 500);
        app.add(table);
        app.add(alttable);
        app.setJMenuBar(menubar);
        EnableandVisible(0);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                files.WriteCarFile(cars);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }


    public static void main(String[] args) {

        //new source();
        String regular_expression = "^(.*)@gmail\\.com$"; //"[0-9a-f]{8}(-)[0-9a-f]{4}(-)[0-9a-f]{4}(-)[0-9a-f]{4}(-)[0-9a-f]{12}";
        String matched ="ifurkan480@gmail.com"; //"c7f87bf4-fa81-11ea-b0ec-482ad3841cf6";
        System.out.println("Is "
                + matched + " actual expression of '"
                + regular_expression + "'? : "
                + Pattern.matches(regular_expression, matched));

    }

    public void EnableandVisible(int i) {
        boolean t_enablevisible = false, a_enablevisible = false, d_enablevisible = false, s_enablevisible = false, l_enablevisible = false, alt_enablevisible = false;
        if (i == 0) t_enablevisible = true;
        else if (i == 1) a_enablevisible = true;
        else if (i == 2) d_enablevisible = true;
        else if (i == 3) s_enablevisible = true;
        else if (i == 4) l_enablevisible = true;
        else if (i == 5) alt_enablevisible = true;
        table.setEnabled(t_enablevisible);
        table.setVisible(t_enablevisible);
        addertitle.setEnabled(a_enablevisible);
        addertitle.setVisible(a_enablevisible);
        adderpanel.setEnabled(a_enablevisible);
        adderpanel.setVisible(a_enablevisible);
        delltitle.setEnabled(d_enablevisible);
        delltitle.setVisible(d_enablevisible);
        dellpanel.setEnabled(d_enablevisible);
        dellpanel.setVisible(d_enablevisible);
        searchtitle.setEnabled(s_enablevisible);
        searchtitle.setVisible(s_enablevisible);
        searchpanel.setEnabled(s_enablevisible);
        searchpanel.setVisible(s_enablevisible);
        listingtitle.setEnabled(l_enablevisible);
        listingtitle.setVisible(l_enablevisible);
        listingpanel.setEnabled(l_enablevisible);
        listingpanel.setVisible(l_enablevisible);
        alttable.setEnabled(alt_enablevisible);
        alttable.setVisible(alt_enablevisible);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view) {
            if (!table.isAncestorOf(app)) {
                if (cars.getI() == 0) {
                    table = cars.ShowCars();
                }
                app.add(table);
                app.repaint();
            }
            EnableandVisible(0);
        }
        if (e.getSource() == add) {
            EnableandVisible(1);
        }
        if (e.getSource() == dell) {
            if (cars.getCarArrayList().isEmpty()) delltitle = deleting.Header("Silmek için kayıt yoktur");
            else delltitle = deleting.Header("Silinecek kaydın sıra numarasını giriniz");
            app.add(delltitle);
            EnableandVisible(2);
        }
        if (e.getSource() == search) {
            if (cars.getCarArrayList().isEmpty()) searchtitle = searching.Header("Aramak için kayıt yoktur");
            else searchtitle = searching.Header("Aranacak Kayıt için VIN numarasını giriniz");
            app.add(searchtitle);
            EnableandVisible(3);
        }
        if (e.getSource() == listing) {
            if (cars.getCarArrayList().isEmpty()) listingtitle = listingcar.Header("Listelemek için kayıt yoktur");
            else
                listingtitle = listingcar.Header("Aradığınız fiyattaki arabaları bulmak için enbüyük ve en küçük fiyat aralığını giriniz");
            app.add(listingtitle);
            EnableandVisible(4);
        }
        if (e.getSource() == adderbutton) {
            app.remove(table);
            int i;
            if (adding.CarAtrributeControl(cars) == 0) {
                i = cars.AddNewCar(adding.getNewCar());
                if (i == 0) {
                    table = cars.ShowCars();
                    app.add(table);
                    EnableandVisible(0);
                    JOptionPane.showMessageDialog(app, "Yeni kayıt eklendi", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                } else if (i == 1)
                    JOptionPane.showMessageDialog(app, "Aynı VIN numarasına sahip kayıt var", "Dikkat", JOptionPane.WARNING_MESSAGE);
                else if (i == 2)
                    JOptionPane.showMessageDialog(app, "Aynı marka ve model numarasına sahip kayıt var", "Dikkat", JOptionPane.WARNING_MESSAGE);
                else if (i == 3)
                    JOptionPane.showMessageDialog(app, "Aynı VIN,marka ve model numarasına sahip kayıt var", "Dikkat", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == dellbutton) {
            app.remove(table);
            int i = deleting.CarDeleteControl(cars);
            if (i == 0) {
                if (cars.DeleteCar(cars.carArrayList.get(deleting.getResult() - 1))) {
                    table = cars.ShowCars();
                    app.add(table);
                    EnableandVisible(0);
                    JOptionPane.showMessageDialog(app, "Kayıt silindi", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(app, "Kayıt içerisinki bir sıra numarası değil", "Dikkat", JOptionPane.WARNING_MESSAGE);
            }
            //else if (i == 2) JOptionPane.showMessageDialog(app, "Geçerli bir sıra numarası değil", "Dikkat", JOptionPane.WARNING_MESSAGE);
        }
        if (e.getSource() == searchbutton) {
            app.remove(table);
            if (searching.CarSearchControl()) {
                alttable = cars.SearchCars(searching.getResult());
                app.add(alttable);
                EnableandVisible(5);
                if (cars.getI() == 0)
                    JOptionPane.showMessageDialog(app, "Kayıt içerisinde bulunamadı", "Dikkat", JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(app, "Kayıt içerisinde bulunuldu", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource() == listingbutton) {
            String lowprice, highprice;
            int slh, len;
            app.remove(table);
            if (listingcar.CarListingControl() == 0) {
                len = listingcar.getResult().length();
                slh = listingcar.getResult().indexOf("-");
                lowprice = listingcar.getResult().substring(0, slh);
                highprice = listingcar.getResult().substring(slh + 1, len);
                alttable = cars.ListCars(Double.parseDouble(lowprice), Double.parseDouble(highprice));
                app.add(alttable);
                EnableandVisible(5);
                if (cars.getI() == 0)
                    JOptionPane.showMessageDialog(app, "Listelinecek kayıt bulunamadı", "Dikkat", JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(app, "Kayıtlar listelendi", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
