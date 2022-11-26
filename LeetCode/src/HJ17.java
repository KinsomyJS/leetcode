import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] arr = input.split(";");
        int x = 0, y = 0;
        for (String str : arr) {
            if (str.matches("^[AWSD]{1}[1-9][0-9]{0,1}$")) {
                String direction = str.substring(0, 1);
                int steps = Integer.parseInt(str.substring(1));
                switch (direction) {
                    case "A":
                        x -= steps;
                        break;
                    case "D":
                        x += steps;
                        break;
                    case "W":
                        y += steps;
                        break;
                    case "S":
                        y -= steps;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(x + "," + y);
    }
}
