import java.util.ArrayList;
import java.util.List;
/**
 * This class implements boyerMoore and rabinKarp.
 * @author Sen
 */
public class StringSearch implements StringSearchInterface {
    @Override
    public List<Integer> boyerMoore(String needle, String haystack) {
        if (haystack == null || needle == null) {
            throw new IllegalArgumentException();
        }
        List<Integer> arrayList = new ArrayList<Integer>();
        if (needle.length() > haystack.length()) {
            return arrayList;
        }
        int[] buildedMap = buildLastTable(needle);
        int totalOfShifts = 0;
        for (int i = needle.length() - 1; totalOfShifts + i < haystack.length(); i--) {
            int index = needle.indexOf(haystack.charAt(i + totalOfShifts));
            if (index == -1) {
                // update shifts, when character from haystack doesn't exist in
                // table
                totalOfShifts += needle.length() - i;
                i = needle.length();
            } else {
                // exist, but mismatch
                if (haystack.charAt(i + totalOfShifts) != needle.charAt(i)) {
                    totalOfShifts +=
                            buildedMap[haystack.charAt(i + totalOfShifts)];
                    i = needle.length();
                }
            }
            // match case
            if (i == 0
                    && haystack.charAt(i + totalOfShifts) == needle.charAt(0)) {
                arrayList.add(totalOfShifts);
                totalOfShifts++;
                i = needle.length();
            }
        }
        return arrayList;
    }
    @Override
    public int[] buildLastTable(String needle) {
        if (needle == null) {
            throw new IllegalArgumentException();
        }
        int[] map = new int[Character.MAX_VALUE + 1];
        // map[*] = needle.length();
        for (int i = 0; i < map.length; i++) {
            map[i] = needle.length();
        }
        // map[Character in string]
        for (int i = 0; i < needle.length(); i++) {
            map[needle.charAt(i)] =
                    Math.max(
                            needle.length()
                            - needle.lastIndexOf(needle.charAt(i)) - 1,
                            1);
        }
        return map;
    }
    @Override
    public int generateHash(String current) {
        if (current == null) {
            throw new IllegalArgumentException();
        }
        int hash = 0;
        for (int i = current.length(); i > 0; i--) {
            int m = pow(BASE, i - 1);
            hash += (current.charAt(current.length() - i)) * m;
        }
        return hash;
    }
    /**
     * private helper method to do Math.pow.
     * @param base the base
     * @param exp exponent
     * @return return calculated value
     */
    private int pow(int base, int exp) {
        if (exp >= 0) {
            int val = 1;
            for (int i = exp; i > 0; i--) {
                val *= base;
            }
            return val;
        }
        return 1;
    }
    @Override
    public int updateHash(int oldHash, int length, char oldChar, char newChar) {
        return (oldHash - (oldChar * pow(BASE, length - 1))) * BASE + newChar;
    }
    @Override
    public List<Integer> rabinKarp(String needle, String haystack) {
        if (needle == null || haystack == null) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<Integer>();
        if (needle.length() > haystack.length()) {
            return list;
        }
        // Initialize
        int hash = generateHash(needle);
        int prev = generateHash(haystack.substring(0, needle.length()));
        if (prev == hash && check(needle, haystack, 0)) {
            list.add(0);
        }
        // start comparing
        for (int i = 1; i < haystack.length() - needle.length() + 1; i++) {
            prev =
                    updateHash(prev, needle.length(), haystack.charAt(i - 1),
                            haystack.charAt(i - 1 + needle.length()));
            if (hash == prev && check(needle, haystack, i)) {
                list.add(i);
            }
        }
        return list;
    }
    /**
     * Private method to check if two string match.
     * @param needle needle
     * @param haystack substring of haystack
     * @param start starting pointer
     * @return true if both string matches, false otherwise.
     */
    private boolean check(String needle, String haystack, int start) {
        if (start + needle.length() - 1 >= haystack.length()) {
            return false;
        }
        for (int i = 0; i < needle.length(); i++) {
            if (needle.charAt(i) != haystack.charAt(i + start)) {
                return false;
            }
        }
        return true;
    }
}
