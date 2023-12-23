package org.jsonparser;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private List<JsonToken> tokens=new ArrayList<>();

    public List<JsonToken> tokenize(String json){
        char[] chars = json.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< chars.length; i++){
            switch (chars[i]){
                case '{':
                    sb.append(chars[i]);
                    tokens.add(new JsonToken(JsonTokenType.OPEN_CURLY_BRACKET, sb.toString()));
                    sb = new StringBuilder();
                    break;
                case '}':
                    sb.append(chars[i]);
                    tokens.add(new JsonToken(JsonTokenType.CLOSING_CURLY_BRACKET, sb.toString()));
                    sb = new StringBuilder();
                    break;
            }
        }
        return this.tokens;
    }
}
