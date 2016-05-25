package de.forsellers.elastic.analyzer.index.analysis.tokenizer;

import junit.framework.TestCase;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public class ForSellersTokenizerTest extends TestCase {
    public void testTokenizer() throws IOException {
        String text = "MODUL-PLUS Bewegungsmelder, silber, 250V~/5A, UP " +
                "Me&Myself " +
                "٩٠ 90 و and 中國 اما but 923 a " +
                " 化計劃 " +
                " 10x333ml " +
                "Aäüxa, 䋨みょ ৯০ Äa_sds $ ABSDS διδασ-ϰάλια جُمله ἐς ९० τοὺς here Ελληνα ႠႡႢႣ ͲͳͰͱ ӐӑӒӓӔӕ " +
                "Ԣԣ Ātsā 4Sellers 8 and Das Kochbuch für Reiter " +
                " Know-it-all ";

        Tokenizer tokenizer = new ForSellersTokenizer();
        tokenizer.setReader(new StringReader(text));

        tokenizer.reset();
        CharTermAttribute charTermAttribute = tokenizer.getAttribute(CharTermAttribute.class);
        TypeAttribute typeAttribute = tokenizer.getAttribute(TypeAttribute.class);

        while (tokenizer.incrementToken()) {
            System.out.println(charTermAttribute.toString() + " " + typeAttribute.type());
        }

        tokenizer.end();

        tokenizer.close();
    }
}