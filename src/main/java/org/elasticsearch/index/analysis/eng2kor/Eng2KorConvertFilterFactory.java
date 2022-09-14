package org.elasticsearch.index.analysis.eng2kor;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;


public class Eng2KorConvertFilterFactory extends AbstractTokenFilterFactory {

    
    public Eng2KorConvertFilterFactory(IndexSettings indexSettings, Environment env , String name, Settings settings) {
        super(name, settings);
    }
    

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new Eng2KorConvertFilter(tokenStream);
    }
    
    
}
