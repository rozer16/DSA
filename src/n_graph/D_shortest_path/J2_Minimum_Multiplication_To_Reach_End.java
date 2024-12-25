package n_graph.D_shortest_path;

import java.util.*;

public class J2_Minimum_Multiplication_To_Reach_End {
    public static void main(String[] args) {
        J2_Minimum_Multiplication_To_Reach_End solver = new J2_Minimum_Multiplication_To_Reach_End();

        int[] arr = {2, 3, 5}; // Array of multipliers
        int start = 2;         // Starting integer
        int end = 30;          // Ending integer

        int result = solver.minimumMultiplications(arr, start, end);
        System.out.println("Minimum multiplications to reach " + end + " from " + start + ": " + result);
    }


   int minimumMultiplications(int[] arr, int start, int end) {
    if (start == end) return 0;

    int[] steps = new int[100000];
    Arrays.fill(steps, Integer.MAX_VALUE);
    steps[start] = 0;

    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(start, 0));
    int mod = 100000;

    while (!queue.isEmpty()) {
        Pair p = queue.poll();
        int mult = p.node;
        int stepSoFar = p.steps;

        for (int num : arr) {
            int newMult = (mult * num) % mod;

            if (steps[newMult] > stepSoFar + 1) {
                if (newMult == end) return stepSoFar + 1;
                steps[newMult] = stepSoFar + 1;
                queue.offer(new Pair(newMult, stepSoFar + 1));
            }
        }
    }
    return -1;
}

static class Pair {
    int node;
    int steps;

    Pair(int node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}
}
