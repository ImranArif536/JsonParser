package org.jsonparser;

import org.jsonparser.enums.JsonTokenType;

import java.util.*;

public class JsonParser {

    Deque<JsonToken> stack = new ArrayDeque<>();

    static Map<JsonTokenType,List<JsonTokenType>> allowed = new HashMap<>();

    static{
        allowed.put(JsonTokenType.OPEN_CURLY_BRACKET,List.of(JsonTokenType.CLOSING_CURLY_BRACKET));
        allowed.put(JsonTokenType.EMPTY, List.of(JsonTokenType.OPEN_CURLY_BRACKET));
        allowed.put(JsonTokenType.CLOSING_CURLY_BRACKET, List.of(JsonTokenType.CLOSING_CURLY_BRACKET, JsonTokenType.COMMA));
    }
    public boolean validateJson(String json){
        Tokenizer tokenizer = new Tokenizer(json);
        stack.push(new JsonToken(JsonTokenType.EMPTY,""));
        JsonToken token = tokenizer.nextToken();
        while(token != null) {
            if (!allowed.get(stack.peek().getTokenType()).contains(token.getTokenType())) {
                return false;
            }
            if(token.getTokenType() == JsonTokenType.CLOSING_CURLY_BRACKET){
                while(stack.peek().getTokenType() != JsonTokenType.OPEN_CURLY_BRACKET){
                    stack.pop();
                }
                stack.pop();
                if(stack.isEmpty())
                    stack.push(new JsonToken(JsonTokenType.EMPTY, ""));
            }
            else {
                stack.push(token);
            }
            token = tokenizer.nextToken();
        }
        return true;
    }
}
