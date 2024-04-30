package kim;

import java.util.Stack;

public class PM_햄버거만들기 {
    static boolean checkStack(Stack<Integer> stack) {
        int[] validate = {1, 3, 2, 1};
        if (stack.size() < 4) return false;

        for (int i = 0; i < 4; i++) {
            if (stack.get(stack.size() - 1 - i) != validate[i]) return false;
        }

        for (int i = 0; i < 4; i++) stack.pop();

        return true;
    }

    static int solution(int[] testCase) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for (int n : testCase) {
            stack.push(n);
            if(checkStack(stack)) total++;
        }

        return total;
    }


    public static void main(String[] args) {
        int[] testCase = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(testCase));
    }
}
