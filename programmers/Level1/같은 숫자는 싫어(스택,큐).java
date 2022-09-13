import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> list = new ArrayList<Integer>();
        int j = 0;
        
        for(int i=0; i<arr.length; i++){
            if(i==0){
                list.add(arr[i]);
            }else if(i>0){
                if(list.get(j) != arr[i]){
                    list.add(arr[i]);
                    j++;
                }
            }
        }
       
        return list;
    }
}
