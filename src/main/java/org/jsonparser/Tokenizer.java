package org.jsonparser;

import org.jsonparser.enums.JsonTokenType;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private String json;
    private int index=-1;
    private List<JsonToken> tokens=new ArrayList<>();

    public Tokenizer(String json){
        this.json = json;
    }

    public JsonToken nextToken(){
        index++;
        if(index >= this.json.length()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        switch (json.charAt(index)){
            case '{':
                return new JsonToken(JsonTokenType.OPEN_CURLY_BRACKET, sb.toString());
            case '}':
                return new JsonToken(JsonTokenType.CLOSING_CURLY_BRACKET, sb.toString());
            case ',':
                return new JsonToken(JsonTokenType.COMMA, sb.toString());
            default:
                return null;
        }
    }
}
