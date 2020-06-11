package SensitiveVocabularyAnalysis;

public class SensitiveDective implements SensitiveDectiveInterface {

    ACM acm;

    @Override
    public void build(VocabularyTable vt) {
        acm = new ACM(vt);
    }

    @Override
    public VocabularyTable solve(String s) {
        return acm.solve(s);
    }

    @Override
    public String desensitize(String s) {
        return acm.desensitize(s);
    }
}
