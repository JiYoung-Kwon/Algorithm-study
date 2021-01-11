import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<Integer>();
        int push = 1;
        for (int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i]; //남은 작업량
            int day = remain/speeds[i]; //소요 작업일
            if(remain%speeds[i]>0)
                day++;
            //소요 작업일로 변경
            progresses[i]=day;
        }

        int max = progresses[0];

        //배포
        for (int i=1; i<progresses.length; i++){
            if(max < progresses[i]){//지금 기능이 더 빨리 완성되면
                //배포하기. 배포 하면 continue
                answer.add(push);
                push = 1;
                max = progresses[i];
            }
            else //더 오래걸리면 배포 하루 미뤄
                push++;
                if(i+1==progresses.length)
                    answer.add(push);
        }
        return answer;
    }
}
