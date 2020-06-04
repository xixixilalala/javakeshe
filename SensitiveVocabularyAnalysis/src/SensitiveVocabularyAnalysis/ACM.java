package SensitiveVocabularyAnalysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class node{
    boolean isWord;
    Map<Character,node> nxt;
    node fail;
    int cnt;
    node(){
        nxt = new HashMap<>();
        cnt=0;
    }
}

public class ACM{

    node rt;
    private StringBuilder sb;
    private VocabularyTable vt;

    ACM(VocabularyTable t){
        for(int i=0;i<t.size();++i){
            insert(t.stringAt(i));
        }
        build();
    }

   public VocabularyTable solve(String s){
        match(s);
        vt = new VocabularyTable();
        sb = new StringBuilder();
        dfs(rt);
        return vt;
    }

    private void insert(String s){
        node cur = rt;
        for(int i=0;i<s.length();++i){
            Character t = s.charAt(i);
            if(!cur.nxt.containsKey(t))cur.nxt.put(t,new node());
            cur = cur.nxt.get(t);
        }
        cur.isWord = true;
    }

    private void build(){
        Queue<node> q = new LinkedList<>();
        q.offer(rt);
        while(!q.isEmpty()){
            node u=q.poll();
            u.cnt=0;
            for (Map.Entry<Character,node> e:u.nxt.entrySet()) {
                Character c = e.getKey();
                node v = e.getValue();
                node p = u;
                while(p!=rt&&!p.nxt.containsKey(c)){
                    p = p.fail;
                }
                v.fail = p;
                q.offer(v);
            }
        }
    }

    private void match(String s){
        node u = rt;
        for(int i=0;i<s.length();++i){
            Character c = s.charAt(i);
            while(u!=rt&&!u.nxt.containsKey(c)){
                u = u.fail;
            }
            if(u.nxt.containsKey(c))u=u.nxt.get(c);
            else u = rt;

            if(u.isWord){
                u.cnt += 1;
                u = rt;
            }
        }
    }

    private void dfs(node u){
        if(u.isWord){
            vt.insert(sb.toString(),u.cnt);
        }
        for (Map.Entry<Character,node> e:u.nxt.entrySet()){
            Character c = e.getKey();
            node v = e.getValue();
            sb.append(c);
            dfs(v);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
