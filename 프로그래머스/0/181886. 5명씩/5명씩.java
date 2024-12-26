import java.util.ArrayList;
import java.util.List;
class Solution {
    public String[] solution(String[] names) {
        List<String>arr=new ArrayList<>();
        String[] answer = {};
        for(int i=0;i<names.length;i++){
            if(i%5==0){
                arr.add(names[i]);
            }
        }
        answer=arr.toArray(new String[0]);
        return answer;
    }
}