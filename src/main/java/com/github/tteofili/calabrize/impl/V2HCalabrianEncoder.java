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

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.BitSet;

import com.github.tteofili.calabrize.CalabrianEncoder;

/**
 * An Italian to Calabrian encoder using the V2H algorithm.
 * V2H algorithm transforms each vowel into an 'h' and leaves everything else untouched.
 */
public class V2HCalabrianEncoder implements CalabrianEncoder {

    private static final String UTF_8 = "UTF-8";

    private static final BitSet vowels = new BitSet(10);

    static {
        vowels.set('a');
        vowels.set('A');
        vowels.set('e');
        vowels.set('E');
        vowels.set('i');
        vowels.set('I');
        vowels.set('o');
        vowels.set('O');
        vowels.set('u');
        vowels.set('U');
    }

    @Override
    public void encode(InputStream input, OutputStream output) throws IOException {
        encode(input, output, UTF_8);
    }

    @Override
    public void encode(InputStream input, OutputStream output, String charsetName) throws IOException {
        InputStreamReader reader = null;
        OutputStreamWriter writer = null;
        try {
            reader = new InputStreamReader(input, charsetName);
            writer = new OutputStreamWriter(output, charsetName);
            encode(input, output);
        } finally {
            close(reader);
            close(writer);
        }
    }

    @Override
    public void encode(Reader input, Writer output) throws IOException {
        int i;
        while ((i = input.read()) != -1) {
            if (vowels.get(i)) {
                output.append('h');
            } else {
                output.append((char) i);
            }
        }
    }

    public String encode(String text) {
        StringReader input = new StringReader(text);
        StringWriter output = new StringWriter();
        try {
            encode(input, output);
        } catch (IOException e) {
            // this should not happen
        } finally {
            close(input);
            close(output);
        }
        return output.toString();
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // just swallow it
            }
        }
    }
}
