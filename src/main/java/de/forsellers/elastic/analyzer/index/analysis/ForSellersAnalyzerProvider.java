package de.forsellers.elastic.analyzer.index.analysis;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import org.elasticsearch.index.settings.IndexSettingsService;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public class ForSellersAnalyzerProvider extends AbstractIndexAnalyzerProvider<ForSellersAnalyzer> {

    private final ForSellersAnalyzer analyzer;

    @Inject
    public ForSellersAnalyzerProvider(Index index, IndexSettingsService indexSettings, @Assisted String name,
                                      @Assisted Settings settings) {
        super(index, indexSettings.getSettings(), name, settings);
        analyzer = new ForSellersAnalyzer(settings);
    }

    @Override
    public ForSellersAnalyzer get() {
        return this.analyzer;
    }
}
