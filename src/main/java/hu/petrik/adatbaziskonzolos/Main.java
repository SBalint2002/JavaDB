package hu.petrik.adatbaziskonzolos;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            DogDB db = new DogDB();
            List<Dog> dogs = db.getDogs();
            System.out.println(dogs);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
