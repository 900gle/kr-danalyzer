package org.elasticsearch.index.analysis.chosung;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class ChosungTokenFilterFactory extends AbstractTokenFilterFactory {

    
    public ChosungTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
    }
    

    @Override
    public TokenStream create(TokenStream stream) {
        return new ChosungTokenFilter(stream);
    }

    
    
}
