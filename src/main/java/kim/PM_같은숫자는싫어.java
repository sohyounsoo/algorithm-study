package kim;

import java.util.*;

public class PM_같은숫자는싫어 {

    static Stack<Integer> solution(int[] testCase){
        Stack<Integer> stack = new Stack<>();
        stack.add(testCase[0]);

        for(int i = 1 ; i < testCase.length ; i++){
            if(stack.peek() != testCase[i]) stack.add(testCase[i]);
        }

        return stack;
    }


    public static void main(String[] args) {
        int[] testCase = {1,1,3,3,0,1,1};
        solution(testCase);
    }


}
