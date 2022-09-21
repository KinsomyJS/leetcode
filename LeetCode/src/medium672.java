import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class medium672 {
    static Set<String> res = new HashSet<>();
    static int length;
    static Set<String> seen = new HashSet<>();

    public static int flipLights(int n, int presses) {
        length = n;
        int[] status = new int[n];
        Arrays.fill(status, 1);
        seen.add(Arrays.toString(status));
        dfs(status, 1, presses);
        return res.size();
    }

    private static void dfs(int[] status, int current, int press) {
        if (current > press) {
            res.add(Arrays.toString(status));
            return;
        }
        dfs(transform1(status), current + 1, press);
        dfs(transform2(status), current + 1, press);
        dfs(transform3(status), current + 1, press);
        dfs(transform4(status), current + 1, press);
    }

    private static int[] transform1(int[] status) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Math.abs(status[i] - 1);
        }
        return arr;
    }

    private static int[] transform2(int[] status) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            if (i % 2 != 0) {
                arr[i] = Math.abs(status[i] - 1);
            } else {
                arr[i] = status[i];
            }

        }
        return arr;
    }

    private static int[] transform3(int[] status) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                arr[i] = Math.abs(status[i] - 1);
            } else {
                arr[i] = status[i];
            }
        }
        return arr;
    }

    private static int[] transform4(int[] status) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            if (i % 3 == 0) {
                arr[i] = Math.abs(status[i] - 1);
            } else {
                arr[i] = status[i];
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        flipLights(2, 2);
    }
}