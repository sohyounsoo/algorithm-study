package hee;

import java.util.ArrayList;
import java.util.List;

public class PM_같은숫자는싫어 {
    public int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();
        List<Integer>  answerList = new ArrayList<>();

        for(int val : arr){
            list.add(val);
        }
        answerList.add(list.get(0));
        for(int i=1; i<list.size(); i++){

            if(!list.get(i).equals(list.get(i-1))){
                answerList.add(list.get(i));

            }
        }
        int answer[] =  answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer ;

    }
}

