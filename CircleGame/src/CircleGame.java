import java.util.ArrayList;


public class CircleGame {
    public static int CardLeft(String deck){
        ArrayList<Character> temp = new ArrayList<Character>();
        for (int i = 0; i < deck.length(); i++){
            if (deck.charAt(i) != 'k'){
                temp.add(deck.charAt(i));
            }
        }
        int j = temp.size();
        while (j>0){
            for (int i = 0; i < temp.size() -1 ; i ++){
                int x = getCardValue(temp.get(i)) + getCardValue(temp.get(i+1));
                if (x == 13){
                    temp.remove(i);
                    temp.remove(i);
                    i = -1;
                }
            }
            j--;
        }

        return temp.size();
    }
    public static int getCardValue(char c){
        int value = 0;
        if (c == 'A'){
            value = 1;
        } else if (c == '2'){
            value = 2;
        } else if (c == '3'){
            value = 3;
        } else if (c == '4'){
            value = 4;
        } else if (c == '5'){
            value = 5;
        } else if (c == '6'){
            value = 6;
        } else if (c == '7'){
            value = 7;
        } else if (c == '8'){
            value = 8;
        } else if (c == '9'){
            value = 9;
        }else if (c == 'T'){
            value = 10;
        } else if (c == 'J'){
            value = 11;
        } else if (c == 'Q'){
            value = 12;
        }
        return value;
    }
    public static void main(String arg[]){
        //System.out.println(CardLeft("kkk"));
        System.out.println(CardLeft("QAAAA2224444kkkAQTT33A"));
    }
}
