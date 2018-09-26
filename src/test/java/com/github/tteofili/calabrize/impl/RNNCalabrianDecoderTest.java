package com.github.tteofili.calabrize.impl;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link RNNCalabrianDecoder}
 */
public class RNNCalabrianDecoderTest {
  @Test
  public void testDecoder() throws Exception {
    InputStream resourceAsStream = getClass().getResourceAsStream("/test.txt");
    String text = IOUtils.toString(resourceAsStream);
    RNNCalabrianDecoder rnnCalabrianDecoder = new RNNCalabrianDecoder(text);
    String decodedText = rnnCalabrianDecoder.decode("qhhst'hsthth vhdh hn vhchnzh h Shvhrhth");
    assertNotNull(decodedText);
  }
}
