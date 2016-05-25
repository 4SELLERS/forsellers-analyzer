package de.forsellers.elastic.analyzer.index.analysis;

import de.forsellers.elastic.analyzer.index.analysis.tokenizer.ForSellersTokenizer;
import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public class ForSellersTokenizerFactory extends AbstractTokenizerFactory {
    @Inject
    public ForSellersTokenizerFactory(Index index, Settings indexSettings, String name, Settings settings) {
        super(index, indexSettings, name, settings);
    }

    @Override
    public Tokenizer create() {
        return new ForSellersTokenizer();
    }
}
