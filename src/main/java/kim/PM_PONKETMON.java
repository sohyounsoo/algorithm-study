package kim;

import java.util.Arrays;

public class PM_PONKETMON {

    static int solution(int[] nums){
        int maxPonketMon = nums.length/2;
        return Arrays.stream(nums).distinct().limit(maxPonketMon).toArray().length;
    }

    public static void main(String[] args) throws Exception {
        int[] testCase = {3,1,2,3};
        System.out.println(solution(testCase));
    }
}
