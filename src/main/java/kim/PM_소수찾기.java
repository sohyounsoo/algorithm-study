package kim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PM_소수찾기 {

    static int solution(int n){
        int answer = 0;
        int[] answers = new int[n+1];

        for(int i = 2 ; i <= n ; i++){
            answers[i] = i;
        }

        for(int i = 2 ; i <= n ; i++){
            for(int j = i ; j <= n ; j = j + i){
                if(j%i ==0 && j != i) answers[j] = 0;
            }
            if(answers[i] != 0) answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        int testCase = 10;
        System.out.println(solution(testCase));
    }
}
