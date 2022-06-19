package org.elasticsearch.index.common.custom;

public class CustomConverter {

    public String convert(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append(string.toLowerCase());
        return sb.toString();
    }
}
