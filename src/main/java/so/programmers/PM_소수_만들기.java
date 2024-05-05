package so.programmers;

import java.util.ArrayList;
import java.util.List;

public class PM_소수_만들기 {

    public static void main(String[] args) {

        int[] nums = {1,2,7,6,4};

        System.out.println(solution(nums));

    }

    public static int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
        int sum = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                for (int k = j+1; k < length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for (int i : list) {
            int std = 2;

            while(i > std) {
                if(i % std == 0) break;
                if(i == std+1) answer++;
                std++;
            }
        }

        return answer;

    }
}
