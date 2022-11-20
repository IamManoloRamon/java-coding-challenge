package com.tribocode.codingchallenge;

public class Stack {
    private int array[];
    private int top;
    private int capacity;

   Stack(int capacity){
       this.array = new int[capacity];
       this.capacity = capacity;
       this.top = -1;
   }

   public void push(int item) {
       if (isFull()) {
           throw new RuntimeException("Stack is full");
       }
        array[++top] = item;
   }

    private boolean isFull() {
        return top == capacity -1;
    }

    public int pop(){
       if (isEmpty()){
           throw new RuntimeException("Stack is empty");
       }
        return  array[top--];
   }

    private boolean isEmpty() {
        return  top == -1;
    }

    public int peek(){
        return  array[top];
   }
}
