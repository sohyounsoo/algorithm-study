package so.programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PM_명예의_전당 {

    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        for (int i : solution(k, score)) {
            System.out.println(i);
        }
    }

    public static int[] solution(int k, int[] score) {
        int length = score.length;
        int[] answer = new int[length];

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < length; i++) {
            queue.add(score[i]);
            if (queue.size() > k) {
                queue.poll();
            }
            answer[i] = queue.peek();
        }

        return answer;

    }

}
