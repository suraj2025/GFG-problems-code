//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String sentences[] = new String[n];
            int times[] = new int[n];
            for(int i = 0; i < n; i++){
                sentences[i] = sc.nextLine();
                times[i] = sc.nextInt();
            }
            AutoCompleteSystem obj = new AutoCompleteSystem(sentences, times);
            int q = sc.nextInt();
            for(int i = 0; i < q; i++){
                String query = sc.nextLine();
                StringBuilder qq = new StringBuilder();
                for(int j = 0; j < query.length(); j++){
                    char x = query.charAt(j);
                    qq.append(String.valueOf(x));
                    ArrayList<String> suggestions = obj.input(x);
                    if(x == '#')
                        continue;
                    out.print("Typed : \"" + qq.toString() + "\" , Suggestions: \n");
                    for(String y : suggestions)
                        out.print(y + "\n");
                }
            }
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

// class AutoCompleteSystem{
//     public AutoCompleteSystem(String sentences[], int times[]){

//     }

//     ArrayList<String> input(char c){
        
//     }
// }

class AutoCompleteSystem {
    private TrieNode root;
    private StringBuilder currentInput;

    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;

        public TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
        }
    }

    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        currentInput = new StringBuilder();

        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    private void insert(String sentence, int times) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            node.counts.put(sentence, node.counts.getOrDefault(sentence, 0) + times);
        }
    }

    public ArrayList<String> input(char c) {
        if (c == '#') {
            insert(currentInput.toString(), 1);
            currentInput = new StringBuilder();
            return new ArrayList<>();
        }

        currentInput.append(c);
        TrieNode node = root;
        for (char ch : currentInput.toString().toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return new ArrayList<>();
            }
            node = node.children.get(ch);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        pq.addAll(node.counts.entrySet());
        ArrayList<String> result = new ArrayList<>();
        while (!pq.isEmpty() && result.size() < 3) {
            result.add(pq.poll().getKey());
        }

        return result;
    }
}