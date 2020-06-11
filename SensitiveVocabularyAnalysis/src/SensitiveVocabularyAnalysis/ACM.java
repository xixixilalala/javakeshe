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

    private node rt;
    private StringBuilder sb;
    private VocabularyTable vt;

    ACM(VocabularyTable t){
        rt = new node();
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

    public String desensitize(String s){
        StringBuilder res=new StringBuilder();
        int cur=0;
        node u = rt;
        for(int i=0;i<s.length();++i){
            Character c = s.charAt(i);
            res.append(c);
            cur = cur + 1;
            while(u!=rt&&!u.nxt.containsKey(c)){
                u = u.fail;
                cur = cur - 1;
            }
            if(u.nxt.containsKey(c))u=u.nxt.get(c);
            else u = rt;

            if(u.isWord){
                u = rt;
                while(cur>0){
                    cur = cur - 1;
                    res.deleteCharAt(res.length()-1);
                }
                if(res.length()==0||res.charAt(res.length()-1)!='*')res.append("**");
            }
        }
        return res.toString();
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
        rt.fail = rt;
        while(!q.isEmpty()){
            node u=q.poll();
            u.cnt=0;
            for (Map.Entry<Character,node> e:u.nxt.entrySet()) {
                Character c = e.getKey();
                node v = e.getValue();
                node p = u.fail;
                while(p!=rt&&!p.nxt.containsKey(c)){
                    p = p.fail;
                }
                if(p.nxt.containsKey(c)&&u!=rt)v.fail = p.nxt.get(c);
                else  v.fail=rt;
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

            node p = u;
            while (p!=rt){
                if(p.isWord){
                    p.cnt+=1;
                }
                p = p.fail;
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
