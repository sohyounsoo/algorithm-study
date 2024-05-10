package kim;

import com.sun.corba.se.impl.legacy.connection.USLPort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PM_명예의전당1다른방법 {

    static List<Integer> solution(int k, int[] score){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();

        for (int point : score){
            queue.offer(point);

            if (queue.size() >= k + 1)
                queue.remove(queue.peek());

            answer.add(queue.peek());
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
    }
}
