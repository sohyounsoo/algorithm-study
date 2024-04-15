package so.programmers;

import java.io.IOException;

public class 날짜 {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        int a = 5, b = 24;
        System.out.println(solution.solution(a, b));
    }

    private static class Solution {
        public String solution(int a, int b) {
            String answer = "";
            String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
            int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int allDate = 0;
            for (int i = 0; i < a - 1; i++) {
                allDate += date[i];
            }
            allDate += (b - 1);
            answer = day[allDate % 7];
            return answer;
        }
    }
}
