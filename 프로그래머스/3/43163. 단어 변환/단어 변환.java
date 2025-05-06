import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean targetInWords = false;
        for (String word : words) {
            if (word.equals(target)) {
                targetInWords = true;
                break;
            }
        }
        if (!targetInWords) return 0;

        Queue<Word>q=new LinkedList<>();
        boolean[] visited=new boolean[words.length];

        q.add(new Word(begin,0));//시작 단어와 카운트 0을 큐에 넣음

        while(!q.isEmpty()){
            Word current=q.poll();

            if(current.word.equals(target)){
                return current.count;
            }
            for(int i=0;i<words.length;i++){
                if(!visited[i]&&diff(current.word,words[i])){
                    visited[i]=true;
                    q.add(new Word(words[i],current.count+1));//한 글자만 다른 단어는 count+1후 단어와 함께 큐에 add
                }
            }
        }

    return 0;
    }
    private boolean diff(String a,String b){// 한글자만 다른지 판별하는 함수
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
    private static class Word{
        String word;
        int count;
        Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}