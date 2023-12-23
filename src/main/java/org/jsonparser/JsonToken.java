package org.jsonparser;

public class JsonToken {
    public JsonTokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(JsonTokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private JsonTokenType tokenType;
    private String value;

    public JsonToken(JsonTokenType type, String value){
        this.tokenType = type;
        this.value = value;
    }
}
