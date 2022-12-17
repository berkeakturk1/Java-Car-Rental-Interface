import java.util.ArrayList;
import java.util.List;

public class Car {
    private String carPlate;
    private List<String> rentDate, returnDate;
    private int rentalCount = 0;

    public Car(String carPlate){
        this.carPlate = carPlate;
        rentDate = new ArrayList<>();
        returnDate = new ArrayList<>();
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
    
}
