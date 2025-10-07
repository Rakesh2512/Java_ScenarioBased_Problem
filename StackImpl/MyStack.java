package StackImpl;

public class MyStack {

    int top;
    int[] a;
    int capacity;
    MyStack(int capacity){
        this.capacity = capacity;
        a = new int[capacity];
        top = -1;
    }
    public void add(int value){
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
        top++;
        a[top] = value;
    }
    public int top(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return a[top];
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        int value = a[top];
        top--;
        return value;
    }
    public boolean isFull(){
        return top == capacity-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public static void main(String[] args) {
        MyStack st = new MyStack(3);
        st.add(1);
        st.add(2);
        System.out.println(st.top);
        st.add(3);
        System.out.println(st.top());
        
    }
}
