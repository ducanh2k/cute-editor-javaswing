package MyStack;
/**
 *
 * @author thaycacac
 */
public class MainStack{

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("a");
        stack.push("ab");
        stack.push("abc");
        stack.push("abcdd");
        stack.pop();
        stack.top();
        stack.pop();
//        System.out.println(stack.top());
        stack.traverse();
    }
}
