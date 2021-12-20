package org.elasticsearch.plugin.esTest;

import java.io.IOException;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.plugin.analysis.DooPlugin;


public class ChosungTest extends AbstractPluginTest {

    
    /**
     * 초성 필터를 테스트한다.
     * 
     * @throws IOException
     */
    public void testChosungFilter() throws Exception {
                
        String source = "자바카페 한글";
        
        String[] result = new String[]{
                "ㅈㅂㅋㅍ", 
                "ㅎㄱ"
        };
        
        String filterName = "doo_chosung";
        

        // 실행
        TestAnalysis analysis = createTestAnalysis(
                new Index("test", ""), Settings.builder().build(), new DooPlugin()
        );
        
        TokenFilterFactory myFilter = analysis.tokenFilter.get(filterName);
        runFilter(myFilter, source, result);
    }
    


    
}
