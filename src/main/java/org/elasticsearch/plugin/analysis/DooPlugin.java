package org.elasticsearch.plugin.analysis;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.chosung.ChosungTokenFilterFactory;
import org.elasticsearch.index.analysis.eng2kor.Eng2KorConvertFilterFactory;
import org.elasticsearch.index.analysis.jamo.JamoTokenFilterFactory;
import org.elasticsearch.index.analysis.kor2eng.Kor2EngConvertFilterFactory;
import org.elasticsearch.index.analysis.spell.SpellFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

/**
 * Javacafe에서 개발한 필터 리스트
 *
 * @author hrkim
 *
 */
public class DooPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {        
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
        
        // (1) 한글 자모 분석 필터
        extra.put("doo-jamo", JamoTokenFilterFactory::new);
        
        // (2) 한글 초성 분석 필터
        extra.put("doo-chosung", ChosungTokenFilterFactory::new);
        
        // (3) 영한 오타 변환 필터
        extra.put("doo-eng2kor", Eng2KorConvertFilterFactory::new);
        
        // (4) 한영 오타 변환 필터
        extra.put("doo-kor2eng", Kor2EngConvertFilterFactory::new);

        // (5) 한글 스펠링 체크 필터
        extra.put("doo-spell", SpellFilterFactory::new);
                        
        return extra;
    }

}



