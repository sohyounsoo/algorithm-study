package hee;

public class PM_햄버거만들기 {
    public static int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for(int k : ingredient){
            sb.append(k);
            if(sb.length() > 3 && sb.substring(sb.length()-4).equals("1231")){
                answer++;
                sb.delete(sb.length()-4,sb.length());
            }
        }
        return answer;
    }


    public static void main(String[] args){
        int [] ingredient =  {2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 3, 1, 3, 1};
        System.out.println(solution(ingredient));
    }

}
