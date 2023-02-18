package lk.ijse.spring.dto;

public class CarRoutesDTO {
    private String id;
    private String brand;
    private String type;
    private String numOfPassenger;
    private String transmissiontype;
    private String fueltype;
    private String dailyRate;
    private String monthlyRate;

    public CarRoutesDTO() {
    }

    public CarRoutesDTO(String id, String brand, String type, String numOfPassenger, String transmissiontype, String fueltype, String dailyRate, String monthlyRate) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.numOfPassenger = numOfPassenger;
        this.transmissiontype = transmissiontype;
        this.fueltype = fueltype;
        this.dailyRate = dailyRate;
        this.monthlyRate = monthlyRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumOfPassenger() {
        return numOfPassenger;
    }

    public void setNumOfPassenger(String numOfPassenger) {
        this.numOfPassenger = numOfPassenger;
    }

    public String getTransmissiontype() {
        return transmissiontype;
    }

    public void setTransmissiontype(String transmissiontype) {
        this.transmissiontype = transmissiontype;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(String dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(String monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    @Override
    public String toString() {
        return "CarRoutesDTO{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", numOfPassenger='" + numOfPassenger + '\'' +
                ", transmissiontype='" + transmissiontype + '\'' +
                ", fueltype='" + fueltype + '\'' +
                ", dailyRate='" + dailyRate + '\'' +
                ", monthlyRate='" + monthlyRate + '\'' +
                '}';
    }
}
