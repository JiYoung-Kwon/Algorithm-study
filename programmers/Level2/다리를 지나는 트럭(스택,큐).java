import java.util.*;
class Solution {
    class Truck{
        public int weight;
        public int time;

        Truck(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; 
        int bridge_weight = 0;
        Queue<Truck> w_truck = new LinkedList<>(); //대기 트럭    
        Queue<Truck> b_truck = new LinkedList<>(); //다리 건너는 트럭        
        //대기 트럭 추가
        for(int i=0; i<truck_weights.length; i++){
            w_truck.add(new Truck(truck_weights[i],0));
        }
        while(!(w_truck.isEmpty() && b_truck.isEmpty())){
            answer++; 
            //건너는 트럭 존재할 경우
            if(!b_truck.isEmpty()){
                if((answer - b_truck.peek().time)>=bridge_length){
                    bridge_weight -= b_truck.peek().weight;
                    b_truck.poll();
                }
            }
            //대기트럭 존재할 경우
            if(!w_truck.isEmpty()){
                if(bridge_weight + w_truck.peek().weight <= weight){
                    bridge_weight += w_truck.peek().weight;             
                    b_truck.add(new Truck(w_truck.peek().weight,answer));
                    w_truck.poll();
                }    
            }
        }        
        return answer;
    }
}
