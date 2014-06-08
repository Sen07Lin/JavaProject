import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Count {
    public static Integer countNum(Integer[] array) {
        Integer maxCount = 0;
        if (array != null) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (Integer i : array) {
                if (countMap.keySet().contains(i)) {
                    countMap.put(i, countMap.get(i) + 1);
                } else {
                    countMap.put(i, 1);
                }
            }
            Integer key = null;
            for (Integer j : countMap.keySet()) {
                if (countMap.get(j) > maxCount) {
                    maxCount = countMap.get(j);
                    key = j;
                }
            }
            //System.out.println(countMap.toString());
            return key;
        }
        return null;
    }
    // print out max three num
    public static int maxProduct(int[] arr) {
        if (arr.length >= 3 && arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    arr[i] = -arr[i];
                }
            }
            Arrays.sort(arr);
            return arr[arr.length - 1] * arr[arr.length - 2]
                    * arr[arr.length - 3];
        }
        return 0;
    }
    public static int divide(int x, int y) {
        int i = 0;
        while (x - y >= 0) {
            x = x - y;
            i += 2;
        }
        return i;
    }
    public static int divideRe(int x, int y, int i) {
        if (x <= 0) {
            return i;
        }
        return divideRe(x - y, y, i + 1);
    }
    public static int module(int x, int y){
        while ( x- y >= 0){
            x = x - y;
        }
        return x;

    }
    public static int moduleRe(int x, int y){
        if (x < y){
            return x;
        }
        return moduleRe(x - y, y);
    }
    public static void main(String[] args) {
        Integer array[] = { -1, 1, 1, -1, 1, 1, 1, 2, 1, 2, 2, 1, 2, 2, 3, -4,
                2, 2, 2, 2, -5, 2 };
        int array2[] = { -1, 1, 1, -1, 1, 1, 1, 2, 1, 2, 2, 1, 2, 2, 3, -4, 2,
                2, 2, 2, -5, 2 };
        System.out.println(countNum(array));
        System.out.println(maxProduct(array2));
        System.out.println(divideRe(6, 3, 0));
        System.out.println(moduleRe(6, 4));
    }
}
