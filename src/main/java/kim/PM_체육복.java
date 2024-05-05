package kim;

import java.util.Arrays;

public class PM_체육복 {
    static int solution(int n, int[] lost, int[] reserve) {

        int[] real_reserve = Arrays.stream(reserve).filter(item -> {
            for(int i = 0 ; i < lost.length ; i++){
                if(lost[i] == item) {
                    lost[i] = -1;
                    return false;
                }
            }
            return true;
        }).sorted().toArray();

        int[] real_lost = Arrays.stream(lost).filter(num -> num != -1).sorted().toArray();

        int count = 0;

        for(int real_lost_val : real_lost){
            for(int i = 0 ; i < real_reserve.length ; i++){
                if(real_reserve[i] == 0) continue;

                int prev = real_reserve[i] - 1;
                int next = real_reserve[i] + 1;

                if(real_lost_val == prev || real_lost_val == next) {
                    real_reserve[i] = 0;
                    count++;
                    break;
                }
            }
        }

        return  n - (real_lost.length - count);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};

        System.out.println(solution(n, lost, reserve));
    }
}
