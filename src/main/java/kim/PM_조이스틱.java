package kim;

import java.util.*;

public class PM_조이스틱 {



    static int solution(String name){
        int answer = 0;

        String[] alpabet_arr = new String[26];
        for(int i = 97 ; i <= 122 ; i++){
            alpabet_arr[i-97] = String.valueOf((char)i);
        }

        String[] reverse_alpabet = alpabet_arr.clone();
        Arrays.sort(reverse_alpabet,Collections.reverseOrder());

        char[] name_arr = name.toLowerCase().toCharArray();

        for(int i = 0 ; i < name_arr.length ; i++){
            if (name_arr[i] == 'a') continue;

            String charStr = String.valueOf(name_arr[i]);

            int start = Arrays.binarySearch(alpabet_arr,charStr);
            int reverse_start = Arrays.binarySearch(reverse_alpabet,charStr);

            if (start > reverse_start) answer += start;
            else if (start < reverse_start) answer += reverse_start;

            answer += 1;
        }


        return answer;
    }


    public static void main(String[] args) {
        String name = "JAZ";
        System.out.println(solution(name));
    }
}
