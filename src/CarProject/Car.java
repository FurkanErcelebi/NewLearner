package CarProject;

public class Car {
    String VIN;
    String make;
    String model;
    int year;
    int mileage;
    double price;

    public Car(String VIN, String make, String model, int year, int mileage, double price) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getVIN() {
        return this.VIN;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public int getMileage() {
        return this.mileage;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String makespace = "", modelspace = "", mileagespace = "", pricespace = "";
        while (makespace.length() + make.length() < 14) {
            makespace += " ";
        }
        while (modelspace.length() + model.length() < 20) {
            modelspace += " ";
        }
        while (mileagespace.length() + Integer.toString(mileage).length() < 7) {
            mileagespace += " ";
        }
        while (pricespace.length() + Double.toString(price).length() < 10) {
            pricespace += " ";
        }

        return "|" + getVIN() + " " +
                "|" + getMake() + makespace +
                "|" + getModel() + modelspace +
                "|" + getYear() + " " +
                "|" + getMileage() + mileagespace +
                "|" + getPrice() + pricespace +
                "|";
    }
}
