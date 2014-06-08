

public class Merge {
    public static Integer[] sortedArrayMerge(Integer a[], Integer b[]) {
        Integer result[] = new Integer[a.length +b.length];
        int i = 0; int j = 0;int k = 0;
        while(i<a.length && j <b.length) {
            if(a[i]<b[j]) {
                result[k] = a[i];
                k++;
                i++;
            } else {
                result[k] = b[j];
                k++;
                j++;
            }
        }
        System.arraycopy(a, i, result, k, (a.length -i));
        System.arraycopy(b, j, result, 4 , (b.length -j));
        return result;
        /*       Set<Integer> result2 = new HashSet<Integer>();
        for (Integer ele: result){
            System.out.println("r1:" +ele);
            result2.add(ele);
        }
        // don't know why it doesn't work here.
        int kk = 0;
        Integer result3[] = new Integer[result2.size()];
        for (Integer elements: result2){
            System.out.println("r2:" +elements);
            result3[kk++] = elements;
        }*/

    }
    public static void main(String[] args){
        Integer a[] = {1,2,3,4,};
        Integer b[] = {5,6,6,7,8,90,888,999};
        for (Integer num: sortedArrayMerge(a,b)) {
            System.out.println(num);
        }
    }

}
