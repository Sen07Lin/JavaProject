
public class BruteForce {
    
    
    public static int bruteSearch(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        int p = 0;
        for (int t=0; t < n - m + 1; t++) {
            for (p=0;p < m; p++) {
                if (text.charAt(t+p) != pattern.charAt(p)) {
                    break;
                }
            }
            if (p == m) {
                return t;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
        System.out.println(bruteSearch("ABC", "SABC"));
    }
}
