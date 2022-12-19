import java.util.*;

public class 打印机队列 {

    public static void main(String[] args) {

        List<PriorityQueue<Integer>> printerList = new ArrayList<>();
        for (int num = 0; num < 5;num++) {
            printerList.add(new PriorityQueue<>());
        }
        Scanner scanner = new Scanner(System.in);

        int eventNum = scanner.nextInt();

        for (int i = 0; i < eventNum; i++) {
            String line = scanner.nextLine();
            String[] lineArr = line.split(" ");
            String inout = lineArr[0];
            int printNo = Integer.parseInt(lineArr[1]);
            int level = Integer.parseInt(lineArr[2]);

            if ("IN".equals(inout)) {
            } else if ("OUT".equals(inout)) {

            }
        }
    }
}
