package so.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PM_문자열_내_마음대로_정렬하기 {

    public static void main(String[] args) {

        String[] str = {"sun", "bed", "car"};
        int n = 1;
        Solution solution = new Solution();


        System.out.println(Arrays.toString(solution.solution(str, n)));

    }

    static class Solution {
        public String[] solution(String[] str, int n) {
            String[] answer = new String[str.length];
            List<String> arr = new ArrayList<>();
            for(int i=0; i< str.length; i++) {
                arr.add("" + str[i].charAt(n) + str[i]);
            }
            Collections.sort(arr);
            for(int i=0; i< str.length; i++) {
                answer[i] = arr.get(i).substring(1);
            }
            return answer;
        }
    }
}
