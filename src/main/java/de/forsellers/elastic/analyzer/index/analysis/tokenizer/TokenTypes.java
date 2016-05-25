package de.forsellers.elastic.analyzer.index.analysis.tokenizer;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public enum TokenTypes {
    ALPHANUM(0, "<ALPHANUM>"),
    HYPHENED_ALPHANUM(1, "<HYPHENED_ALPHANUM>"),
    APOSTROPHE(2, "<APOSTROPHE>"),
    ACRONYM(3, "<ACRONYM>"),
    NUM(7, "<NUM>"),
    HAS_DIGIT(9, "<HAS_DIGIT>"),
    CJ(8, "<CJ>");

    private final int id;
    private final String typeName;

    TokenTypes(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }
}
