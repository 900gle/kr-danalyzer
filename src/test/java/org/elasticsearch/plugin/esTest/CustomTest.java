package org.elasticsearch.plugin.esTest;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.plugin.analysis.DooPlugin;

import java.io.IOException;


public class CustomTest extends AbstractPluginTest {

    
    /**
     * 자모 필터를 테스트한다.
     * 
     * @throws IOException
     */
    public void testJamoFilter() throws Exception {
                
        String source = "doo coo doo eoo";
        
        String[] result = new String[]{
                "doo",
                "coo",
                "eoo"
        };
        
        String filterName = "doo-custom";
        

        // 실행
        TestAnalysis analysis = createTestAnalysis(
                new Index("test", ""), Settings.builder().build(), new DooPlugin()
        );
        
        TokenFilterFactory myFilter = analysis.tokenFilter.get(filterName);
        runFilter(myFilter, source, result);
    }
    

    
    
    
}
