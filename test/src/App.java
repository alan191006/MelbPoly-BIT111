import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            System.err.print("Age : ");

            int age = scanner.nextInt();
            String classification;

            if (age < 0) {
                classification = "Invalid age";
            } else if (age == 0) {
                classification = "Infant";
            } else if (age <= 3) {
                classification = "Toddler";
            } else if (age <= 12) {
                classification = "Child";
            } else if (age <= 19) {
                classification = "Teenager";
            } else if (age <= 29) {
                classification = "Young Adult";
            } else if (age <= 39) {
                classification = "Adult";
            } else if (age <= 49) {
                classification = "Middle-aged Adult";
            } else if (age <= 59) {
                classification = "Mature Adult";
            } else if (age <= 69) {
                classification = "Senior";
            } else if (age <= 79) {
                classification = "Elderly";
            } else if (age <= 89) {
                classification = "Old Age";
            } else if (age <= 99) {
                classification = "Very Old Age";
            } else {
                classification = "Centenarian";
            }

            System.out.println("Your are a " + classification);
        }
    }
}
