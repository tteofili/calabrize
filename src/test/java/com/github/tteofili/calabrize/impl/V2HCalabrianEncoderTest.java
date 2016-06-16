/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.github.tteofili.calabrize.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link V2HCalabrianEncoder}
 */
public class V2HCalabrianEncoderTest {

    @Test
    public void testEncode() throws Exception {
        String italianText = "quest'estate vado in vacanza a Soverato";
        V2HCalabrianEncoder encoder = new V2HCalabrianEncoder();
        String encodedText = encoder.encode(italianText);
        assertEquals("qhhst'hsthth vhdh hn vhchnzh h Shvhrhth", encodedText);
    }

    @Test
    public void testEncodeStream() throws Exception {
        String italianText = "quest'estate vado in vacanza a Soverato";
        V2HCalabrianEncoder encoder = new V2HCalabrianEncoder();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        encoder.encode(new ByteArrayInputStream(italianText.getBytes()), outputStream);
        assertEquals("qhhst'hsthth vhdh hn vhchnzh h Shvhrhth", new String(outputStream.toByteArray(),
                Charset.forName("UTF-8")));
    }

    @Test
    public void testEncodeStreamWithCharset() throws Exception {
        Charset charset = Charset.forName("UTF-8");
        String italianText = "quest'estate vado in vacanza a Soverato";
        V2HCalabrianEncoder encoder = new V2HCalabrianEncoder();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        encoder.encode(new ByteArrayInputStream(italianText.getBytes()), outputStream, charset.name());
        assertEquals("qhhst'hsthth vhdh hn vhchnzh h Shvhrhth", new String(outputStream.toByteArray(), charset));
    }
}