package org.jsonparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jsonparser.enums.JsonTokenType;
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
        Tokenizer tokenizer = new Tokenizer("{}");
        JsonParser parser = new JsonParser();
        boolean res = parser.validateJson("{}");
        assertEquals(true, res);
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
