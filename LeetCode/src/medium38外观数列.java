import java.util.Optional;

public class medium38外观数列 {
    public static String countAndSay(int n) {
        String result = "1";
        if (n == 1) {
            return result;
        }
        for (int i = 2; i <= n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            char prev = result.charAt(0);
            int num = 1;
            for (int j = 1; j < result.length(); j++) {
                if (prev == result.charAt(j)) {
                    prev = result.charAt(j);
                    num++;
                } else {
                    stringBuilder.append(num);
                    stringBuilder.append(prev);
                    prev = result.charAt(j);
                    num = 1;
                }
            }
            if (num != 0) {
                stringBuilder.append(num);
                stringBuilder.append(prev);
            }
            result = stringBuilder.toString();
        }

        return result;
    }

    public static void main(String[] args) {
//        countAndSay(4);
        Optional<Chestnut> opChest = Optional.empty();

        if(!opChest.isPresent()){

            System.out.println("容器里没有栗子");

        }
    }

}
class Chestnut {

    private String name;

    public String getName(){

        return name;

    }

}