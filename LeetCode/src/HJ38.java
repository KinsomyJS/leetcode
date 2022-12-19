import java.util.Scanner;

public class HJ38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double initialHeight = in.nextDouble();

        System.out.println(2.875 * initialHeight);

        System.out.println(initialHeight / 32.0);
    }
}
