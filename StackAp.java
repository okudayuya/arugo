import java.io.*;

class StackAp {

    static StackExample stack;
    static BufferedReader in;

    public static void main(String args[]) throws Exception {//メイン文
	int value;
	stack = new StackExample();
	in = new BufferedReader(new InputStreamReader(System.in));
	while (true) {
	    System.out.print("Input: 1. push, 2. pop, 3. exit: ");
	    value = (new Integer(new String(in.readLine()))).intValue();
	    if (value == 1) {
		push();
	    } else if (value == 2) {
		pop();
	    } else {
		break;
	    }
	    stack.printIntValue();
	}
    }

    static void push() throws Exception {
	System.out.print("Insert element: ");
	Integer element = new Integer(new String(in.readLine()));
	stack.push(element);
    }

    static void pop() {
	Integer element = (Integer) stack.pop();
	System.out.println("Pop value is " + element.intValue());
    }

}