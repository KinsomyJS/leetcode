import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.HashMap;
import java.util.Map;

//public class Test2 {
//    public static void main(String[] args) {
//        int[] caseArr = new int[]{2, 1, 3, 5, 4, 6, 8, 7};
//        for (int i = 0; i < caseArr.length; i++) {
//            for (int j = i + 1; j < caseArr.length; j++) {
//                if (caseArr[i] > caseArr[j]) {
//                    int temp = caseArr[j];
//                    caseArr[j] = caseArr[i];
//                    caseArr[i] = temp;
//                }
//            }
//        }
//        for (int i : caseArr) {
//            System.out.printf(i + ",");
//        }
//
//    }
//}

class SingleInstance {
    private SingleInstance() {

    }
    public static volatile SingleInstance instance;

    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if(instance == null) {
                    instance = new SingleInstance();
                }

            }
        }
        return instance;
    }



    public static void test() {
        Map<Class,Object> map = new HashMap<>();
        map.put(IApi.class,new IApiImpl());
        IApi i = (IApi) map.get(IApi.class);
        i.jumpTo();
    }

    public static void main(String[] args) {
        test();
    }

}

interface IApi {
    void jumpTo();
}

class IApiImpl implements IApi {

    @Override
    public void jumpTo() {
        System.out.println("hahahahhaha");
    }
}

