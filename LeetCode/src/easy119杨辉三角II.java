import java.util.ArrayList;
import java.util.List;

public class easy119杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            list.add(0);
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    list.set(j, 1);
                } else {
                    list.set(j, list.get(j - 1) + list.get(j));
                }
            }
        }
        return list;
    }
}
