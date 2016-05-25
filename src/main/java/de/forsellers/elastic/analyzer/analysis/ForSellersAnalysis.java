package de.forsellers.elastic.analyzer.analysis;

import de.forsellers.elastic.analyzer.index.analysis.ForSellersAnalyzer;
import de.forsellers.elastic.analyzer.index.analysis.tokenizer.ForSellersTokenizer;
import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.analysis.AnalyzerScope;
import org.elasticsearch.index.analysis.PreBuiltAnalyzerProviderFactory;
import org.elasticsearch.index.analysis.PreBuiltTokenizerFactoryFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.IndicesAnalysisService;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public class ForSellersAnalysis extends AbstractComponent {
    @Inject
    public ForSellersAnalysis(Settings settings, IndicesAnalysisService indicesAnalysisService) {
        super(settings);

        //analyzers
        indicesAnalysisService.analyzerProviderFactories().put("forsellers-analyzer",
                new PreBuiltAnalyzerProviderFactory("forsellers-analyzer", AnalyzerScope.GLOBAL,
                        new ForSellersAnalyzer(settings)));

        //Tokenizers
        indicesAnalysisService.tokenizerFactories().put("forsellers-tokenizer",
                new PreBuiltTokenizerFactoryFactory(new TokenizerFactory() {
                    @Override
                    public String name() {
                        return "forsellers-tokenizer";
                    }

                    @Override
                    public Tokenizer create() {
                        return new ForSellersTokenizer();
                    }
                }));
    }
}
