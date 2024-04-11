class Vehicle {
    private String regNo;
    private String model;
    private int yearOfManufacture;
    private double value;

    public Vehicle(String regNo, String model, int yearOfManufacture, double value) {
        this.regNo = regNo;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.value = value;
    }
    public String getRegNo() {
        return regNo;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public int calculateAge(int currentYear) {
        return currentYear - yearOfManufacture;
    }
    
    @Override
    public String toString() {
        return "Registration Number: " + regNo + ", Model: " + model + ", Year of Manufacture: " + yearOfManufacture + ", Value: Php" + value;
    }
}