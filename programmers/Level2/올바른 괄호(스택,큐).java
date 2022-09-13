class Solution {
    boolean solution(String s) {
        int checkStr = 0;
        
        if(s.charAt(0) == ')')
            return false;
        
        for(int i=0; i<s.length(); i++){
            if(checkStr < 0)
                return false;
            
            if(s.charAt(i)=='('){
                checkStr++;
            }else{
                checkStr--;
            }
        }
        
        if(checkStr != 0)
            return false;

        return true;
    }
}
