package kim;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 치킨먹기 {

    static String[] solution(int[] test_case){
        String[] answer = new String[test_case.length];

        loop:
        for(int i = 0 ; i < test_case.length ; i++){
            int temp = 1;
            int cnt = 0;
            while (temp <= test_case[i] && temp > 0){
                temp =  test_case[i] - (3 * cnt++);
                if (temp % 7 == 0){
                    answer[i] = "YES";
                    continue loop;
                }
            }
            answer[i] = "NO";
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] test_case = {88, 4, 96, 76, 69, 56, 2, 41, 76, 14};
        String[] solution = solution(test_case);
        for (String a : solution){
            System.out.print(a +  " ");
        }
    }
}
