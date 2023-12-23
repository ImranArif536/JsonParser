package org.jsonparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testTokenizer()
    {
        Tokenizer tokenizer = new Tokenizer();
        List<JsonToken> tokens = tokenizer.tokenize("{}");
        assertEquals(JsonTokenType.OPEN_CURLY_BRACKET, tokens.get(0).getTokenType());
        assertEquals(JsonTokenType.CLOSING_CURLY_BRACKET, tokens.get(1).getTokenType());
    }

    @Test
    public void validJson(){
        String json = "{}";
        JsonParser parser = new JsonParser();
        boolean result = parser.validateJson(json);
        assertEquals(result, true);
    }

    @Test
    public void invalidJson(){
        String json = "{{";
        JsonParser parser = new JsonParser();
        boolean result = parser.validateJson(json);
        assertEquals(result, false);
    }
}
