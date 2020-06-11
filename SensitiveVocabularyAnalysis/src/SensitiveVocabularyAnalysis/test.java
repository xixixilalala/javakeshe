package SensitiveVocabularyAnalysis;

public class test {
    public static void main(String[] args){
        SensitiveDectiveInterface sdi = new SensitiveDective();
        VocabularyTable vt = new VocabularyTable();
        vt.insert("abbb");
        vt.insert("bbc");
        sdi.build(vt);
        VocabularyTable res = sdi.solve("bbcabbbbc");
        System.out.println(res);
    }
}
