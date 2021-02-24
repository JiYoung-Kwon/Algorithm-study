import java.util.*; 

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int max = 0;
        //찍는 방식 배열
        int[] student1 = {1,2,3,4,5}; //5개
        int[] student2 = {2,1,2,3,2,4,2,5}; //8개
        int[] student3 = {3,3,1,1,2,2,4,4,5,5}; //10개

        //맞춘 개수
        int[] score = {0,0,0};

        //정답과 비교
        for(int i=0; i<answers.length; i++){
            //수포자 1
            if(answers[i] == student1[i%5])
                score[0] ++;
            //수포자 2
            if(answers[i] == student2[i%8])
                score[1] ++;
            //수포자 3
            if(answers[i] == student3[i%10])
                score[2] ++;
        }

        //정답 많이 맞춘 수
        for(int i=0; i<3; i++){
            if(score[i] >= max)
                max = score[i];
        }

        //가장 높은 점수 받은 사람
        for(int i=0; i<3; i++){
            if(score[i] == max)
                answer.add(i+1);
        }

        return answer;
    }
}
