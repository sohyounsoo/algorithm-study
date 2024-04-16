package kim;

import java.util.Arrays;

public class PM_2016 {

    static String solution(int a, int b){
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] monthDays = {31,29,31,30,31,30,31,31,30,31,30,31};
        // 둠스데이 알고리즘, -1 은 배열 days를 맞추기 위함.
        int totalDays = (Arrays.stream(monthDays).limit(a-1).sum() + b) - 1 ;

        return days[totalDays%7];
    }


    public static void main(String[] args) {
        int a = 5, b= 24;
        System.out.println(solution(a,b));
    }
}
