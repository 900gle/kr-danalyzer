package org.elasticsearch.plugin.esTest;

import java.io.IOException;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.plugin.analysis.DooPlugin;


public class Eng2KorTest extends AbstractPluginTest {

    
    /**
     * 영한 오타 변환기를 테스트한다.
     * 
     * @throws IOException
     */
    public void test() throws Exception {
                
        String source = "wkqkzkvp gksrmf";
        
        String[] result = new String[]{
                "자바카페", 
                "한글"
        };
        
        String filterName = "doo_eng2kor";
        

        // 실행
        TestAnalysis analysis = createTestAnalysis(
                new Index("test", ""), Settings.builder().build(), new DooPlugin()
        );
        
        TokenFilterFactory myFilter = analysis.tokenFilter.get(filterName);
        runFilter(myFilter, source, result);
    }
    
    
    
}
