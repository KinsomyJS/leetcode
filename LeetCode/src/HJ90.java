import java.util.Scanner;

public class HJ90 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ipAddr = in.nextLine();

        String[] arr = ipAddr.split("\\.");
        if (arr.length != 4) {
            System.out.println("NO");
            return;
        }

        for (String part : arr) {
            if (!part.matches("^\\d{0,3}$")) {
                System.out.println("NO");
                return;
            }
            if (part.isEmpty() || (part.startsWith("0") && part.length() > 1)) {
                System.out.println("NO");
                return;
            }
            if (Integer.parseInt(part) > 255) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
