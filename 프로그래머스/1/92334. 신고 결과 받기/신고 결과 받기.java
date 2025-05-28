import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k){
        int []answer=new int [id_list.length];
        //일단 중복 신고가 불가능함.->즉 report={신고자, 신고 대상자} 중복을 제거해야함.-> 중복을 제거하는건 Set
        Set<String>reportSet=new HashSet<>(Arrays.asList(report));
        //중복을 제거했으니 각 유저가 신고한 유저들의 리스트, 신고당한 횟수를 카운트하는 리스트를 만들어야함
        Map<String, Integer>reportCount=new HashMap<>();
        Map<String, List<String>>toFromList=new HashMap<>();
        for(String s:reportSet){
            String[] part=s.split(" ");
            String from=part[0];
            String to=part[1];

            reportCount.put(to,reportCount.getOrDefault(to,0)+1);//to가 있다면 +1, 없으면 0(기본값)으로 초기화
            if(!toFromList.containsKey(from)){
                toFromList.put(from,new ArrayList<>());
            }
            toFromList.get(from).add(to);//신고자:[신고당한 사람] 추가
        }
        for(int i=0;i<id_list.length;i++){
            String from=id_list[i];
            //신고자가 신고한 리스트를 불러와야함
            for(String to:toFromList.getOrDefault(from,new ArrayList<>())){
                if(reportCount.get(to)>=k){
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}