package hee;

public class PM_콜라문제 {

    public static int solution(int a, int b, int n){

        int answer =0;

        while(n >= a){
            answer += (n/a)*b;
            n =  (n / a) * b + n % a;
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(3, 1, 21));
    }


}
