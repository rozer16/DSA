package j_stack;

public class AB_StackImplUsingArray {
    int len = 0;
    int arr [] ;
    int front = -1;

    public AB_StackImplUsingArray(int len){
        this.len = len;
        arr = new int[50];
    }


    public static void main(String[] args) {
        AB_StackImplUsingArray test = new AB_StackImplUsingArray(50);
        test.push(5);
        test.push(4);
        test.push(3);
        test.display();
        test.pop();
        System.out.println("Top : "+test.peek());
        test.display();
    }
    public void display(){
        System.out.print("Stack : ");
        for (int i=front; i>=0;i--){
            System.out.print(arr[i]+"\t");
        }
        System.out.println("front: "+front);
    }
    public int push(int val){
        try {
            if (front == this.len - 1) {
                throw new UnsupportedOperationException("Stack is full");
            }

            arr[++front] = val;
            return val;
        }catch(Exception e){
            val = -1;
            throw e;

        }finally {
            return val;
        }
    }

    public int pop(){
        int result = -1;
        if(front != -1){
            result = arr[front];
            arr[front] = -1;
            front--;

        }
        return result;
    }

    public int peek(){
        int result = -1;
        if(front != -1){
            result = arr[front];

        }
        return result;
    }
}
