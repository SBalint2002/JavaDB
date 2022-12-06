package hu.petrik.adatbaziskonzolos;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static DogDB db;
    public static void main(String[] args) {
        try{
            db = new DogDB();
            DogDB db = new DogDB();
            ListDogs(db);
            readDogsFromConsole();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private static void ListDogs(DogDB db) throws SQLException {
        List<Dog> dogs = db.getDogs();
        dogs.forEach(System.out::println);
        System.out.println();
    }

    private static void readDogsFromConsole() {
        System.out.print("Adja meg hogy hány kutyát szeretne felvenni: ");
        Scanner sc = new Scanner(System.in);
        try {
            int count = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < count; i++) {
                System.out.print("Név: ");
                String name = sc.nextLine();
                System.out.print("Életkor: ");
                int age = Integer.parseInt(sc.nextLine());
                System.out.print("Faj: ");
                String breed = sc.nextLine();
                Dog dog = new Dog(name, age, breed);
                db.createDog(dog);
            }
        } catch (NumberFormatException e) {
            System.out.println("Nem számot adott meg, a felvétel megszakadt!");
        } catch (SQLException e) {
            System.out.print("Hiba történt a kutya felvétele során: ");
            e.printStackTrace(System.out);
        }
    }
}
