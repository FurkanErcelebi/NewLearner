package Learner;

import java.lang.String;

public class Testclass implements NewInterface {

    int tamsayi;

    public Testclass(int tamsayi) {
        this.tamsayi = tamsayi;
    }

    public void setTamsayi(int tamsayi) {
        this.tamsayi = tamsayi;
    }

    public int getTamsayi() {
        return this.tamsayi;
    }

    public int TestInterface(String TestString) {
        if (!TestString.contains("@gmail")) {
            System.out.println("Lütfen gmail adresi giriniz");
            setTamsayi(2);
        } else if (!TestString.contains("@hotmail")) {
            System.out.println("Lütfen hotmail adresi giriniz");
            setTamsayi(3);
        }
        return getTamsayi();
    }
}
