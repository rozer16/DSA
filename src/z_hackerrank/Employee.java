package z_hackerrank;


import java.util.*;

class Employee1 {
    private int id  = 0;

    public Employee1(int id) {
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return id == employee1.id;
    }

    @Override
    public int hashCode() {
        int [] a  = new int[1];
        a[0] = this.id;


        if (a == null)
            return 0;

        int result = 1;

        for (Object element : a)
            result = 31 * result + (element == null ? 0 : element.hashCode());

        return result;

    }
}
public class Employee {

    public static void main(String[] args) {
        Set<Employee1> hset = new HashSet<Employee1>();

        String inputValues ="10 10 10" ;

        String[] values = inputValues.split("\\s");
        for (String v: values) {
            hset.add(new Employee1(Integer.parseInt(v)));
        }

        System.out.println(hset.size());


    }

}
