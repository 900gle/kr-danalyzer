package org.elasticsearch.index.analysis.doo;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.index.common.custom.CustomConverter;

import java.io.IOException;

/**
 * 한글 커스텀 필터
 *
 * @author doo
 *
 */
public final class DooTokenFilter extends TokenFilter {

    private CustomConverter converter;
    private CharTermAttribute termAtt;


    public DooTokenFilter(TokenStream stream){
        super(stream);
        this.converter = new CustomConverter();
        this.termAtt = addAttribute(CharTermAttribute.class);

    }

    @Override
    public boolean incrementToken() throws IOException {

        if (input.incrementToken()) {
            CharSequence parserdData = converter.convert(termAtt.toString());
            termAtt.setEmpty();
            termAtt.append(parserdData);

            return true;
        }
        return false;
    }
}
