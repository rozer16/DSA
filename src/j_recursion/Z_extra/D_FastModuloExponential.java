package j_recursion.Z_extra;

public class D_FastModuloExponential {

    public int recursiveFatModuloExponential(int no, int power, int mod){
        if(power == 0)
            return 1;
        if(power %2 == 0){
            //no ^ power = (no ^2)^power/2
            return recursiveFatModuloExponential((int) ((1l*no*no) % mod),power/2,mod);
        }
        //no ^ power = no*(no^power-1)
        return (no*recursiveFatModuloExponential(no,power-1,mod)) % mod;
    }

    public static void main(String[] args) {
        D_FastModuloExponential test = new D_FastModuloExponential();
        System.out.println(test.recursiveFatModuloExponential(5,100000007,13));
    }
}
