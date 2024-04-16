package kim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PM_문자열내마음대로정렬하기 {

    static List<String> solution(String[] testCode, int n){
        List<String> answers = Arrays.stream(testCode).sorted((o1, o2) -> {
            char compareA = o1.toCharArray()[n];
            char compareB = o2.toCharArray()[n];

            if (compareA == compareB) {
                return o1.compareTo(o2);
            }

            return compareA - compareB;

        }).collect(Collectors.toList());

        return answers;
    }

    public static void main(String[] args) {
        String[] testCode = {"abce", "abcd", "cdx"};
        solution(testCode,1);
    }

}
