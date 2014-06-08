import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedNesting {
    public static boolean isBalanced(String s){
        Map<Character,Character> oppeners = new HashMap<> ();
        Stack<Character> stack = new Stack<>();
        oppeners.put('[',']');
        oppeners.put('<','>');
        oppeners.put('(',')');
        oppeners.put('{','}');
        for (int i = 0; i < s.length(); i ++){
            Character c = s.charAt(i);
            if (oppeners.keySet().contains(c)){
                stack.push(c);
            } else if (oppeners.values().contains(c)){
                if (stack.empty()){
                    return false;
                }
                Character c2 =  stack.pop();
                // System.out.println(oppeners.get(c));
                if (!oppeners.get(c2).equals(c)){
                    return false;
                }
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        String[] testStrings = {
                "( { [ ] } )", "( { [ } ] )", "} ( { [ ] } )",
                "(map (lambda (x) (* x x)) (list 1 2 3 4))",
                "(map (lambda (x) (* x x)) (list 1 2 3 4)))"
        };
        for (String s: testStrings) {
            System.out.printf("%s is balanced: %s.%n", s, isBalanced(s));
        }
    }
}
/*Map<Character, Character> openers = new HashMap<>();
openers.put(')', '(');
openers.put(']', '[');
openers.put('}', '{');
openers.put('>', '<');
LinkedStack<Character> stack = new LinkedStack<>();
for (int i = 0; i < s.length(); i++) {
    Character c = s.charAt(i);
    //System.out.println(openers.values());
    if (openers.values().contains(c)) {
        System.out.println("hi" + c);
        stack.push(c);
    } else if (openers.keySet().contains(c)) {
        System.out.println("hi2" + c);
        if (stack.isEmpty()) {
            System.out.println("hi3" + c);
            return false;
        }
        Character opener = stack.pop();
        if (!opener.equals(openers.get(c))) {
            return false;
        }
    }
}
return stack.isEmpty();*/