package org.jsonparser;

import java.util.List;

public class JsonParser {

    public boolean validateJson(String json){
        Tokenizer tokenizer = new Tokenizer();
        List<JsonToken> tokens = tokenizer.tokenize(json);
        if(tokens.get(0).getTokenType() == JsonTokenType.OPEN_CURLY_BRACKET
                && tokens.get(tokens.size()-1).getTokenType() == JsonTokenType.CLOSING_CURLY_BRACKET){
            return true;
        }
        else return false;
    }
}
