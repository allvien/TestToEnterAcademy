import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

        static HashMap<String, Integer> fruits = new HashMap<String, Integer>();
        static Scanner scanner = new Scanner(System.in);

        public static void main (String[]args){


            // sammanställningen av de funktioner som gör att programmet körs i rätt ordning
            do {
                displayFruits();
                displayMenu();
                int option = getOption();

                if (option == 1) {
                    addFruit();
                } else if (option == 2) {
                    highestPrice();
                } else if (option == 3) {
                    lowestPrice();
                } else if (option == 4) {
                    System.out.println("Exit program.");
                    break;
                }
            } while (true);
        }
        // Listan som visar frukterna som användaren matat in.
        static void displayFruits () {
            System.out.println("____________________________\n-    Fruitlist    -\n");
            if (fruits.isEmpty()) {
                System.out.println("Fruitlist is empty!");
                return;
            }
            for (Map.Entry<String, Integer> FruitEntry : fruits.entrySet()) {
                System.out.println(FruitEntry.getKey() + " " + FruitEntry.getValue() + " $.");
            }
        }
        // funktionen som räknar ut vilken frukt som är dyrast
        static void highestPrice () {
            int highestPrice = 0;
            String fruit = "";

            for (Map.Entry<String, Integer> FruitEntry : fruits.entrySet()) {

                if (FruitEntry.getValue() > highestPrice) {
                    highestPrice = FruitEntry.getValue();
                    fruit = FruitEntry.getKey();
                }

            }
            if (!fruit.isEmpty()) {
                System.out.println("Most expensive fruit is: " + fruit + " " + highestPrice);
            }
        }
        // funktion som räknar ut den billigaste frukten.
        static void lowestPrice () {
            int lowestPrice = 999999999;
            String fruit = "";

            for (Map.Entry<String, Integer> FruitEntry : fruits.entrySet()) {

                if (FruitEntry.getValue() < lowestPrice) {
                    lowestPrice = FruitEntry.getValue();
                    fruit = FruitEntry.getKey();
                }

            }
            if (!fruit.isEmpty()) {
                System.out.println("Cheapest fruit is: " + fruit + " " + lowestPrice);
            }


        }


        // funktion som gör själva menyn
        static void displayMenu () {
            System.out.println("____________________________\n-    Menu    -\n");
            System.out.println("1 - Add Fruit and price");
            System.out.println("2 - Most expensive Fruit");
            System.out.println("3 - Least exepensive fruit");
            System.out.println("4 - Exit");

        }
        // funktion som tar användarens val i menyn
        static int getOption () {
            System.out.println("Option:  ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            return option;
        }

        // funktion för att addera frukt plus pris
        static void addFruit () {
            System.out.println("Name of fruit you want to add:");
            String name = scanner.next();
            System.out.println("Price of fruit you want to add:");
            int price = scanner.nextInt();
            fruits.put(name, price);

        }
    }
