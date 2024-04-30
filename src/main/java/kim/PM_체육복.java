package kim;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PM_체육복 {
    static int COUNT = 0;

    static int solution(int n, int[] lost, int[] reserve) {

        int[] lost_remove_reserve = Arrays.stream(reserve).filter(item -> {
            for (int a : lost) {
                if (item == a) {
                    COUNT++;
                    return false;
                }
            }
            return true;
        }).toArray();

        Arrays.sort(lost_remove_reserve);
        Arrays.sort(lost);

        int lost_val = (int)Arrays.stream(lost).filter(lostNum -> {
            for (int i = 0 ; i < lost_remove_reserve.length ; i++) {
                if(lost_remove_reserve[i] == 0) continue;

                int prev = lost_remove_reserve[i] - 1;
                int next = lost_remove_reserve[i] + 1;

                if(lostNum == prev || lostNum == next) {
                    lost_remove_reserve[i] = 0;
                    return false;
                }
            }
            return true;
        }).count();

        return  n - lost_val + COUNT;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {1,2,3};
        int[] reserve = {3,4};

        System.out.println(solution(n, lost, reserve));
    }
}
