import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
@SuppressWarnings("hiding")
public class MyStack<T> implements Iterable<T> {
    ArrayList<T> backArray = new ArrayList<>();
    private class StackIterator<T> implements Iterator<T> {
        int current = 0;
        @Override
        public boolean hasNext() {
            if (current < backArray.size() && backArray.get(current) != null) {
                return true;
            }
            return false;
        }
        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return (T) backArray.get(current++);
        }
        @Override
        public void remove() {
            // TODO Auto-generated method stub
        }
    }
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }
    public void push(T str) {
        backArray.add(0,str);
    }
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return backArray.remove(0);
    }
    public boolean isEmpty() {
        return backArray.size() == 0;
    }
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        for (int i = 0; i< 9; i++){
            stack.push(""+i);
        }
        Iterator<String> it = stack.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        /*for (int j = 0; j< 9; j++){
            System.out.println(stack.pop());
        }*/
    }
}
