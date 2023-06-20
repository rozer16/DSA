package j_stack;


/*
*
* https://leetcode.com/problems/asteroid-collision/description/
*
*
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
*
*
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
*
*
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
*
*/

import java.util.*;

public class T_AsteroidCollision {

    public static void main(String[] args) {
        T_AsteroidCollision test = new T_AsteroidCollision();
        int [] arr = {-2,-2,1,-1};
        System.out.println(Arrays.toString(test.asteroidCollision(arr)));
    }
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if(asteroids[i] > 0){
                stack.push(asteroids[i]);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i]))
                    stack.pop();

                if(!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }else {
                    if(stack.isEmpty() || stack.peek() < 0)
                        stack.push(asteroids[i]);
                }
            }
        }
        int [] ans = new int[stack.size()];
        int n = stack.size()-1;
        while(!stack.isEmpty())
            ans[n--] = stack.pop();

        return ans;
    }
}
