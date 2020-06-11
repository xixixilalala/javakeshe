package SensitiveVocabularyAnalysis;

public class test {
    public static void main(String[] args){
        SensitiveDectiveInterface sdi = new SensitiveDective();
        VocabularyTable vt = new VocabularyTable();
        vt.insert("abc");
        vt.insert("b");
        sdi.build(vt);
        System.out.println(sdi.solve("abcabcaabbcc"));
        System.out.println(sdi.desensitize("bbcabbbbc"));
    }
}
