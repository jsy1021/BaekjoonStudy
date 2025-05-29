import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean changePossible=false;
        for(String s: words){
            if(s.equals(target))
                changePossible=true;
        }
        if(!changePossible)
            return 0;
        
        Queue<Word>q=new LinkedList<>();
        boolean visited[]=new boolean[words.length];
        q.add(new Word(begin,0));
        while(!q.isEmpty()){
            Word current=q.poll();
            
            if(current.word.equals(target)){
                return current.count;
            }
            for(int i=0;i<words.length;i++){
                if(!visited[i]&&diff(current.word,words[i])){
                    visited[i]=true;
                    q.add(new Word(words[i],current.count+1));   
                }
            }
        }
        
        return 0;
    }
    
    public static class Word{
        String word;
        int count;
        Word(String word, int count){
            this.word=word;
            this.count=count;
        }
        
    }
    private boolean diff(String a, String b){
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))
                count++;
        }
        if(count==1)
            return true;
        else 
            return false;
        
    }
}