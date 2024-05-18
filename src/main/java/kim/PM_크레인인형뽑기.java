package kim;

import java.util.ArrayList;
import java.util.List;

public class PM_크레인인형뽑기 {

    static int solution(int[][] board, int[] moves){
        int answer = 0;
        List<Integer> machine = new ArrayList<>();

        for (int move : moves){
            for (int i = 0 ; i < board[move-1].length ; i++){
                if(board[i][move-1] > 0){
                    machine.add(board[i][move-1]);
                    board[i][move-1] = -1;
                    break;
                }
            }
        }

        for (int i = 1 ; i < machine.size() ; i++ ) {
            if (machine.get(i-1).equals(machine.get(i))) {
                answer += 2;
                machine.remove(i-1); machine.remove(i-1);
                i = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board= {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 4, 4, 0}, {1, 2, 2, 1}};
        int[] moves = {2, 3, 1, 4, 2, 3};

        System.out.println(solution(board,moves));
    }
}
