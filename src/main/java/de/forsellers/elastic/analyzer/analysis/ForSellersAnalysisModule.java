package de.forsellers.elastic.analyzer.analysis;

import org.elasticsearch.common.inject.AbstractModule;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public class ForSellersAnalysisModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ForSellersAnalysis.class).asEagerSingleton();
    }
}
