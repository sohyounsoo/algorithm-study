package kim;

import java.util.Arrays;

public class PM_둘만의암호 {


    static String solution(String s, String skip, int index){

        StringBuffer sb = new StringBuffer();
        char[] skipChar = skip.toCharArray();

        Arrays.sort(skipChar);

        for(char c : s.toCharArray()){
            int step = index;
            char newChar = c;

            while (step > 0){
                newChar++;
                if (newChar > 'z') newChar = 'a';
                if (Arrays.binarySearch(skipChar, newChar) < 0) step--;
            }
            sb.append(newChar);

        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        System.out.println(solution(s,skip,index));
    }

}
