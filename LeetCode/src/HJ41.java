import java.util.*;

public class HJ41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        String mInput = in.nextLine();
        String[] weightInputArr = mInput.split(" ");

        String xInput = in.nextLine();
        String[] numInputArr = xInput.split(" ");

        Set<Integer> res = new HashSet<>();
        res.add(0);

        for (int i = 0; i < n; i++) {
            List<Integer> currentWeightSums = new ArrayList<>(res);
            for (int j = 0; j < currentWeightSums.size(); j++) {
                for (int k = 1; k <= Integer.parseInt(numInputArr[i]); k++) {
                    res.add(currentWeightSums.get(j) + Integer.parseInt(weightInputArr[i]) * k);
                }
            }
        }
        System.out.println(res.size());
    }
}
