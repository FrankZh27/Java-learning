// Using two stacks to implement a queue
import java.util.Stack;

public class myQueue<ValueType>{

	Stack<ValueType> input = new Stack<ValueType>();
	Stack<ValueType> output = new Stack<ValueType>();

	public void push(ValueType x){
		input.push(x);
	}

	public ValueType pop(){
		ValueType x = peek();
		output.pop();
		return x;
	}

	public ValueType peek(){
		if (output.isEmpty()){
			while(!input.isEmpty()){
				output.push(input.pop());
			}
		}
		return output.peek();
	}
	
	public static void main(String args[]){
		myQueue<Integer> mq = new myQueue<Integer>();
		mq.push(3);
		int x = mq.pop();
		System.out.println(x);
	}
}