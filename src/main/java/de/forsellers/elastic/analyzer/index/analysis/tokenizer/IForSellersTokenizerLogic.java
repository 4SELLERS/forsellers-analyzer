package de.forsellers.elastic.analyzer.index.analysis.tokenizer;

import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public interface IForSellersTokenizerLogic {
    /**
     * Returns the length of the matched text region.
     */
    int GetMatchedLength();

    /**
     * Returns the number of characters up to the start of the matched text.
     */
    int GetMatchedStart();

    /**
     * Fills Lucene CharTermAttribute with the current token text.
     */
    void GetMatchedText(CharTermAttribute t);

    /**
     * Create a new buffer and reset the parser
     */
    void Reset(java.io.Reader r);

    /**
     * Resumes scanning until the next regular expression is matched,
     * the end of input is encountered or an I/O-Error occurs and
     * returns null.
     *
     * @return      the next token
     */
    TokenTypes GetNextToken();
}
