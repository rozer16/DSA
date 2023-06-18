package j_stack;

/*
* 1 3 0
* 90
* 93.35
*
* 37
*
* */
public class B_QueueImplUsingArray {
    int len;
    int arr[];
    int front=0;
    int rear=0;
    int count = 0;
    public B_QueueImplUsingArray(int len){
        this.len = len;
        this.arr = new int[len];
    }

    public int size(){
        return count;
    }
    public static void main(String[] args) {
        B_QueueImplUsingArray test = new B_QueueImplUsingArray(5);
        test.push(3);
        test.push(2);
        test.push(1);
        test.push(8);
        test.push(6);
        test.push(7);
        test.display();
        System.out.println("Top : " +test.peek());
        test.pop();
        test.pop();
        test.push(9);
        test.display();
    }
    public int push(int val){
        if(count >= len){
            System.out.println("Stack is full! so not adding : "+val);
            return -1;
        }
        arr[rear%len] = val;
        rear++;
        count++;
        return val;
    }

    public int pop(){
        if(front == rear) {
            System.out.println("Queue is empty");
            return -1;

        }
        int temp = arr[front%len];
        arr[front%len]  = -1;
        front++;
        count --;
        System.out.println("Popped element : "+temp);
        return temp;
    }

    public int peek(){
        if(front == rear)
            return -1;

        return arr[front%len];
    }

    public void display(){
        System.out.println("Queue : ");
        if(front == rear)
            return;
        for (int i = 0; i < count; i++) {
            System.out.print(arr[(front+i)%len]+"\t");
        }
        System.out.println("Front : "+front+" Rear : "+rear);
    }

}



