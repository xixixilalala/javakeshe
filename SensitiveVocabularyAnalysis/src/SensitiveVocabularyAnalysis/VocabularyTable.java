package SensitiveVocabularyAnalysis;

import java.util.ArrayList;

public class VocabularyTable {
    private ArrayList<String> stringList;
    private ArrayList<Integer> integerList;
    private int n;
    VocabularyTable(){
        stringList = new ArrayList<>();
        integerList = new ArrayList<>();
        n=0;
    }
    public void insert(String s,Integer i){
        stringList.add(s);
        integerList.add(i);
        n+=1;
    }
    public String stringAt(int i){
        return stringList.get(i);
    }
    public int intAt(int i){
        return integerList.get(i);
    }
    public int size(){
        return n;
    }
}
