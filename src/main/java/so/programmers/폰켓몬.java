package so.programmers;

import java.io.IOException;
import java.util.HashSet;

public class 폰켓몬 {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        int[] nums = {3,1,2,3};
        System.out.println(solution.solution(nums));
    }

    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            int pick = nums.length/2;

            HashSet<Integer> set = new HashSet<>();
            for(int num : nums) {
                set.add(num);
            }

            if(set.size() > pick) {
                answer = pick;
            }else {
                answer = set.size();
            }

            return answer;
        }
    }
}
