package so.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class PM_같은숫자는싫어 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1,1,3,3,0,1,1};
        for (int i : solution.soulition(arr)) {
            System.out.print(i);
        }
    }

    static class Solution {
        public int[] soulition(int[] arr) {
            ArrayList<Integer> tempList = new ArrayList<>();
            int preNum = -1;

            for(int n : arr) {
                if(preNum != n) tempList.add(n);
                preNum = n;
            }

            int[] answer = new int[tempList.size()];
            int idx = 0;
            for(int n : tempList) {
                answer[idx] = tempList.get(idx++);
            }

            return answer;

        }
    }
}
