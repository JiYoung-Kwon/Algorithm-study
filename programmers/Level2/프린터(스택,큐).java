import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int k = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i= 0; i<priorities.length; i++){ // list 초기화
            list.add(priorities[i]);
        }

        while(!list.isEmpty()){ //모두 출력 시 종료
            int max = list.get(0);

            for(int i=0; i<list.size(); i++){
                if(list.get(0) < list.get(i)){ //나머지 중 큰거 있으면      
                    if(location == 0)
                        location = list.size()-1; //마지막으로
                    else
                        location--; //하나씩 땡기기                    
                    //list 첫 번째 값 -> 마지막으로 이동
                    int empty = list.get(0);
                    list.remove(0);
                    list.add(empty);

                    max = 0;
                    break;          
                }
            }

            if(max !=0){ //중요도 제일 클 경우 출력
                list.remove(0);
                answer++;

                if(location == 0) //인쇄 요청 문서 출력 시 종료
                    break;
                else
                    location--; //땡기기
            }
        }
        return answer;
    }
}