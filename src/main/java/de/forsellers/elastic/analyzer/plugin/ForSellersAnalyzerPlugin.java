package de.forsellers.elastic.analyzer.plugin;

import de.forsellers.elastic.analyzer.analysis.ForSellersAnalysisModule;

import de.forsellers.elastic.analyzer.index.analysis.ForSellersAnalysisBinderProcessor;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.plugins.Plugin;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by mohammadreza.roohian on 24.05.2016.
 */
public class ForSellersAnalyzerPlugin extends Plugin {

    @Override
    public String name() {
        return "analysis-forsellers";
    }

    @Override
    public String description() {
        return "An analyzer designed specifically for shop search queries.";
    }

    @Override
    public Collection<Module> nodeModules() {
        return Collections.singletonList(new ForSellersAnalysisModule());
    }

    public void onModule(AnalysisModule module) {
        module.addProcessor(new ForSellersAnalysisBinderProcessor());
    }
}
