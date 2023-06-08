package bitmanipulation;

public class NoOfOne {
    public int hammingWeight(int n) {
        int x = 1;
        int count = 0;
        while(x <= n){
            if((n & x) == 1)
                count++;
            x = x<<1;
        }

        return count;

    }

    public static void main(String[] args) {
        NoOfOne test = new NoOfOne();
        //System.out.println(test.hammingWeight(13));
        System.out.println(1<<3);
        System.out.println(Math.pow(2,3));
    }
}
