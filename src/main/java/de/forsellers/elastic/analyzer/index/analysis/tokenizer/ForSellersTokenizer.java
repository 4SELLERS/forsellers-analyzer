package de.forsellers.elastic.analyzer.index.analysis.tokenizer;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public class ForSellersTokenizer extends Tokenizer {
    private final OffsetAttribute offsetAtt;
    private final PositionIncrementAttribute posIncrAtt;
    private final TypeAttribute typeAtt;
    private final CharTermAttribute termAtt;

    private int maxTokenLength = 255;

    private IForSellersTokenizerLogic scanner;

    public ForSellersTokenizer() {
        this.scanner = null;
        this.termAtt = this.addAttribute(CharTermAttribute.class);
        this.offsetAtt = this.addAttribute(OffsetAttribute.class);
        this.posIncrAtt = this.addAttribute(PositionIncrementAttribute.class);
        this.typeAtt = this.addAttribute(TypeAttribute.class);
    }

    public void setMaxTokenLength(int length) {
        this.maxTokenLength = length;
    }

    public int getMaxTokenLength() {
        return this.maxTokenLength;
    }

    private IForSellersTokenizerLogic getScanner(Reader input) {
        return new ForSellersTokenizerLogic(input);
    }

    @Override
    public final boolean incrementToken() throws IOException {
        if (scanner == null) {
            scanner = getScanner(input);
        }

        this.clearAttributes();
        int posIncr = 1;

        while(true) {
            TokenTypes tokenType = this.scanner.GetNextToken();
            if(tokenType == null) {
                return false;
            }

            if(this.scanner.GetMatchedLength() <= this.maxTokenLength) {
                this.posIncrAtt.setPositionIncrement(posIncr);
                this.scanner.GetMatchedText(this.termAtt);
                int start = this.scanner.GetMatchedStart();
                this.offsetAtt.setOffset(this.correctOffset(start), this.correctOffset(start + this.termAtt.length()));
                this.typeAtt.setType(tokenType.getTypeName());

                return true;
            }

            ++posIncr;
        }
    }

    @Override
    public final void end() {
        int finalOffset = this.correctOffset(this.scanner.GetMatchedStart() + this.scanner.GetMatchedLength());
        this.offsetAtt.setOffset(finalOffset, finalOffset);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        this.scanner = null;
    }
}
