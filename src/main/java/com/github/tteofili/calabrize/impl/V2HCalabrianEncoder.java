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

import java.util.BitSet;

import com.github.tteofili.calabrize.CalabrianEncoder;

/**
 * An Italian to Calabrian encoder using the V2H algorithm.
 * V2H algorithm transforms each vowel into an 'h' and leaves everything else untouched.
 */
public class V2HCalabrianEncoder implements CalabrianEncoder {

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

    public String encode(String text) {
        StringBuilder b = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (vowels.get(c)) {
                b.append('h');
            } else {
                b.append(c);
            }
        }
        return b.toString();
    }
}
