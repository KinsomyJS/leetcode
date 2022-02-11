public class medium275H指数II {
    public static int hIndex(int[] citations) {
        int length = citations.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (length - mid == citations[mid]) {
                return citations[mid];
            } else if (citations.length - mid > citations[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return length - left;
    }

    private static long startValue = -1;

    static {
        Thread t = new Thread() {
            public void run() {
                System.out.println("dddddd"+startValue);
                startValue = 365;
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        };
        t.start();
//        try {
//            t.join();
//        } catch (Exception e) {
//            System.out.println("dddddd"+startValue);
//            e.printStackTrace();
//        }
    }


    public static void main(String[] args) {
        System.out.println(startValue);
    }

}
