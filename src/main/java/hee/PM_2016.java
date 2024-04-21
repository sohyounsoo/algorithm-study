package hee;

public class PM_2016 {
    public String solution(int a, int b) {
        String dayArr[] = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int month[] = {31,29,31,30,31,30,31,31,30,31,30,31};
        String answer = "";
        int day=0;

        for(int i=0; i < a-1; i++ ){
            day += month[i];
        }
        answer = dayArr[(day + b) % 7];

        return answer;
    }
}
