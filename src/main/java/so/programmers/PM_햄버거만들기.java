package so.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PM_햄버거만들기 {

    public static int solution(int[] ingredient) {
        int ret=0;
        int[] seq = new int[]{1,3,2,1};
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i<ingredient.length ; i++) {
            stack.push(ingredient[i]);

            if(stack.peek()==1 && stack.size()>=4) {
                List<Integer> list = new ArrayList<>();
                for(int j=0 ; j<seq.length ; j++) {
                    if(stack.peek()!=seq[j]) {
                        break;
                    }
                    list.add(stack.pop());
                }

                if(list.size()==4) {
                    ret++;
                } else {
                    for(int j=list.size()-1 ; j>=0 ; j--) {
                        stack.push(list.get(j));
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] testcade = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        System.out.println(solution(testcade));
    }
}
