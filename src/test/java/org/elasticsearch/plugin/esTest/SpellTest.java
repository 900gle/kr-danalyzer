package org.elasticsearch.plugin.esTest;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.plugin.analysis.DooPlugin;


public class SpellTest extends AbstractPluginTest {

    
    public void test1() throws Exception {
        
        String source = "자바카페 한글";
        
        String[] result = new String[]{
                "ㅈㅏㅂㅏㅋㅏㅍㅔ", 
                "ㅎㅏㄴㄱㅡㄹ"
        };
        
        String filterName = "doo_spell";
        

        // 실행
        TestAnalysis analysis = createTestAnalysis(
                new Index("test", ""), Settings.builder().build(), new DooPlugin()
        );
        
        TokenFilterFactory myFilter = analysis.tokenFilter.get(filterName);
        runFilter(myFilter, source, result);
    }
    

    public void test2() throws Exception {
                
        String source = "삼성전자";
        
        String[] result = new String[] {
                "",
                "ㅅㅏㅁㅅㅓㅇㅈㅓㄴㅈㅏ"
        };
        
        String filterName = "javacafe_spell";
        

        // 실행
        TestAnalysis analysis = createTestAnalysis(
                new Index("test", ""), Settings.builder().build(), new DooPlugin()
        );
        
        TokenFilterFactory myFilter = analysis.tokenFilter.get(filterName);
        runFilter(myFilter, source, result);
    }
    

    
    
    
}
