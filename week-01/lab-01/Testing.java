import java.util.Scanner;


public class Testing {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Age: ");
        int age = input.nextInt();
        if (age >= 18 || age <= 66) {
    System.out.println("You are within the permitted employment age");
} else {
    System.out.println("You are not within the permitted employment age");
}
    }
}