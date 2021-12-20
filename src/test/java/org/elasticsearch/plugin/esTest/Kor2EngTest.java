package org.elasticsearch.plugin.esTest;

import java.io.IOException;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.plugin.analysis.DooPlugin;


public class Kor2EngTest extends AbstractPluginTest {

    
    /**
     * 한영 오타 변환기를 테스트한다.
     * 
     * @throws IOException
     */
    public void test() throws Exception {
                
        String source = "ㅓㅁㅍㅁㅊㅁㄹㄷ ㅑㅔㅗㅐㅜㄷ";
        
        String[] result = new String[]{
                "javacafe", 
                "iphone"
        };
        
        String filterName = "doo_kor2eng";
        

        // 실행
        TestAnalysis analysis = createTestAnalysis(
                new Index("test", ""), Settings.builder().build(), new DooPlugin()
        );
        
        TokenFilterFactory myFilter = analysis.tokenFilter.get(filterName);
        runFilter(myFilter, source, result);
    }
    
    
    
}
