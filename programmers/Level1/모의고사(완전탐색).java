import java.util.*; 

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int max = 0;
        //��� ��� �迭
        int[] student1 = {1,2,3,4,5}; //5��
        int[] student2 = {2,1,2,3,2,4,2,5}; //8��
        int[] student3 = {3,3,1,1,2,2,4,4,5,5}; //10��

        //���� ����
        int[] score = {0,0,0};

        //����� ��
        for(int i=0; i<answers.length; i++){
            //������ 1
            if(answers[i] == student1[i%5])
                score[0] ++;
            //������ 2
            if(answers[i] == student2[i%8])
                score[1] ++;
            //������ 3
            if(answers[i] == student3[i%10])
                score[2] ++;
        }

        //���� ���� ���� ��
        for(int i=0; i<3; i++){
            if(score[i] >= max)
                max = score[i];
        }

        //���� ���� ���� ���� ���
        for(int i=0; i<3; i++){
            if(score[i] == max)
                answer.add(i+1);
        }

        return answer;
    }
}
