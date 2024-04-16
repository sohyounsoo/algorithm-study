package hee;

import java.util.Arrays;

public class PM_PONKETMON {
    public int solution(int[] nums) {
        int answer = 1;

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(i <= nums.length && i > 0){
                if(nums[i] == nums[i-1]){

                }else answer++;
            }
        }
        answer = nums.length/2 < answer ? nums.length/2 : answer ;
        return answer;
    }
}
