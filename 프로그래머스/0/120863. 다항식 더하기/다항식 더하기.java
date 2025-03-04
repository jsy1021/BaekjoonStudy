class Solution {
    public String solution(String polynomial){
        String answer="";
        int x_count=0;
        int count=0;
        String [] result=polynomial.split(" \\+ ");
        for(String str:result){
            if(str.equals("x")){
                x_count+=1;
            }
            else if(str.contains("x")){
                x_count+=Integer.parseInt(str.replace("x",""));
            }
            else if(!str.equals("+"))//+가 아닌 경우
            {
                count+=Integer.parseInt(str);
            }
        }
        if (x_count == 0) return String.valueOf(count);
        if (count == 0) return x_count == 1 ? "x" : x_count + "x";
        return (x_count == 1 ? "x" : x_count + "x") + " + " + count;
    }
}