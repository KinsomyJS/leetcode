import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ77 {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        List<Integer> trainNoList = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 0; i < total; i++) {
            trainNoList.add(in.nextInt());
        }
        List<Integer> inList = new ArrayList<>();
        inList.add(trainNoList.get(0));
        bfs(total, 1, 0, trainNoList, inList, new ArrayList<>());
        Collections.sort(res);
        for (String str : res) {
            System.out.println(str);
        }
    }

    private static void bfs(int total, int addCount, int removeCount, List<Integer> trainNoList, List<Integer> inTrainList, List<Integer> leaveTrainList) {
        if (addCount == total && removeCount == total) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int no : leaveTrainList) {
                stringBuilder.append(no).append(" ");
            }
            res.add(stringBuilder.toString());
//            System.out.println(stringBuilder.toString());
            return;
        }
        if (addCount > removeCount) {
            // 出站
            List<Integer> newInList = new ArrayList<>(inTrainList);
            int outNo = newInList.remove(inTrainList.size() - 1);
            List<Integer> newLeaveList = new ArrayList<>(leaveTrainList);
            newLeaveList.add(outNo);
            bfs(total, addCount, removeCount + 1, trainNoList, newInList, newLeaveList);
        }
        if (addCount < total) {
            // 还有火车可以进站
            List<Integer> newInList2 = new ArrayList<>(inTrainList);
            newInList2.add(trainNoList.get(addCount));
            bfs(total, addCount + 1, removeCount, trainNoList, newInList2, leaveTrainList);
        }
    }
}
