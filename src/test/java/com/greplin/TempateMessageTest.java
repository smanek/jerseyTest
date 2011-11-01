/*
 * Copyright 2010 Greplin, Inc. All Rights Reserved.
 */

package com.greplin;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Test (de)serialization of TemplateMessages
 */
public class TempateMessageTest {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  @Test
  public void testRoundTrip() throws IOException {
    final String param = "stuff etc.";
    final TemplateMessage tm = new TemplateMessage(param);
    final String jsonTM = MAPPER.writeValueAsString(tm);

    Assert.assertEquals(param, tm.getParam());
    Assert.assertTrue(jsonTM.length() > 0);
    Assert.assertEquals('{', jsonTM.charAt(0));

    final TemplateMessage deserializedTM = MAPPER.readValue(jsonTM, TemplateMessage.class);
    Assert.assertEquals(param, deserializedTM.getParam());
  }
}
