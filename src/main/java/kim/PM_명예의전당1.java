package kim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PM_명예의전당1 {

    static int findMinValue(List<Integer> temp_list){
        return temp_list.stream().min((n, m) -> {
            if (n > m) return 1;
            else return 0;
        }).orElse(0).intValue();
    }

    static List<Integer> solution(int k, int[] score){
        List<Integer> temp_list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for(int point : score){
            temp_list.add(point);

            if (temp_list.size() >= k + 1)
                temp_list.remove(temp_list.indexOf(findMinValue(temp_list)));

            answer.add(findMinValue(temp_list));
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        solution(k, score);
    }
}
