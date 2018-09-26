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
package com.github.tteofili.calabrize;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * A Calabrian to Italian encoder
 */
public interface CalabrianDecoder {

    /**
     * Decode a Calabrian text, read from the input, into Italian, written directly to the output.
     *
     * @param input the input where the Calabrian text is read
     * @param output the output where the Italian text is written
     * @throws IOException
     */
    void decode(InputStream input, OutputStream output) throws IOException;

    /**
     * Decode a Calabrian text, read from the input, into Italian, written directly to the output., specifying the char set.
     *
     * @param input the input where the Calabrian text is read
     * @param output the output where the Italian text is written
     * @param charsetName the input/output text char set
     * @throws IOException if any read/write error occurs
     */
    void decode(InputStream input, OutputStream output, String charsetName) throws IOException;

    /**
     * Decode a Calabrian text, read from the input, into Italian, written directly to the output.
     *
     * @param input the input where the Calabrian text is read
     * @param output the output where the Italian text is written
     * @throws IOException if any read/write error occurs
     */
    void decode(Reader input, Writer output) throws IOException;

    /**
     * Decode a Calabrian text into Italian.
     *
     * @param text an Calabrian text
     * @return an Italian text
     */
    String decode(String text);

}
