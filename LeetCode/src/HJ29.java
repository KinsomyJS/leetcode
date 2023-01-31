import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuilder enc = new StringBuilder();
        for (char c : in.nextLine().toCharArray()) {
            enc.append(encrypt(c));
        }
        System.out.println(enc);

        StringBuilder dec = new StringBuilder();
        for (char c : in.nextLine().toCharArray()) {
            dec.append(decrypt(c));
        }
        System.out.println(dec);
    }

    //    a-97 A-65 0-48
    private static char encrypt(char ch) {
        if (ch >= 'a' && ch < 'z') {
            return (char) (ch - 31);
        }
        if (ch == 'z') {
            return 'A';
        }

        if (ch >= 'A' && ch < 'Z') {
            return (char) (ch + 33);
        }
        if (ch == 'Z') {
            return 'a';
        }

        if (ch >= '0' && ch < '9') {
            return (char) (ch + 1);
        }
        return '0';
    }

    private static char decrypt(char ch) {
        if (ch >= 'b' && ch <= 'z') {
            return (char) (ch - 33);
        }
        if (ch == 'a') {
            return 'Z';
        }

        if (ch >= 'B' && ch <= 'Z') {
            return (char) (ch + 31);
        }
        if (ch == 'A') {
            return 'z';
        }

        if (ch > '0' && ch <= '9') {
            return (char) (ch - 1);
        }
        return '9';
    }
}
