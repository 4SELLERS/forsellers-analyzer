package de.forsellers.elastic.analyzer.index.analysis;

import org.elasticsearch.index.analysis.AnalysisModule;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public class ForSellersAnalysisBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {

    @Override
    public void processAnalyzers(AnalyzersBindings analyzersBindings) {
        analyzersBindings.processAnalyzer("forsellers-analyzer", ForSellersAnalyzerProvider.class);
    }

    @Override
    public void processTokenizers(TokenizersBindings tokenizersBindings) {
        tokenizersBindings.processTokenizer("forsellers-tokenizer", ForSellersTokenizerFactory.class);
    }
}
