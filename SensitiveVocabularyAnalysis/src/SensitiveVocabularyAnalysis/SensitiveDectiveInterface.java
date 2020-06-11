package SensitiveVocabularyAnalysis;

public interface SensitiveDectiveInterface {
    void build(VocabularyTable vt);
    VocabularyTable solve(String s);
    String desensitize(String s);
}
