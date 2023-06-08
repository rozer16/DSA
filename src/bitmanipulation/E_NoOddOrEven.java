package bitmanipulation;


/*
*
* Last bit of any odd no will always be set.
* Last bit on any even no will always be unset.
* */
public class E_NoOddOrEven {
    public boolean NoOddOrEven(int n){
        return (n & 1) == 1 ?  true :  false;
    }

    public static void main(String[] args) {
        System.out.println(new E_NoOddOrEven().NoOddOrEven(5));
    }
}
