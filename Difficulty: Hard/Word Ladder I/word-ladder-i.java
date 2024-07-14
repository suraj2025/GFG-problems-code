//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    class Pair{
        String str;
        int val;
        Pair(String s,int v){
            str=s;
            val=v;
        }
    }
    public int wordLadderLength(String beginWord, String endWord, String[] wordList) {
        Queue<Pair> q=new LinkedList<>();
        HashSet<String> set= new HashSet<>();
        q.offer(new Pair(beginWord,1));
        for(String s:wordList){
            set.add(s);
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair p=q.poll();
            String word=p.str;
            int step=p.val;
            if(word.equals(endWord)) return step;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    String s1=word.substring(0,i)+ch+word.substring(i+1);
                    if(set.contains(s1)){
                        q.offer(new Pair(s1,step+1));
                        set.remove(s1);
                    }
                }
            }
            
        }
        return 0;
    }
    
    
}