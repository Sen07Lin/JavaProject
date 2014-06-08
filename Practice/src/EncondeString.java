import java.util.HashMap;
import java.util.Map;


public class EncondeString {
    public static String encode(String str){
        Map<Character,Integer> strMap = new HashMap<>();
        for (int i = 0;  i< str.length(); i++){
            Character c = str.charAt(i);
            if(strMap.keySet().contains(c)){
                strMap.put(c, strMap.get(c) + 1);
            } else{
                strMap.put(c, 1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character c: strMap.keySet()){
            sb.append(c);
            sb.append(strMap.get(c));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(encode("aaaaabbbbbnsnsnsnaaa"));
    }
}
