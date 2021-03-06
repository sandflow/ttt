/*
 * Copyright 2014-15 Skynav, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY SKYNAV, INC. AND ITS CONTRIBUTORS “AS IS” AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL SKYNAV, INC. OR ITS CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.skynav.ttpe.util;

public class Strings {

    private Strings() {}

    public static boolean isWhitespace(String s) {
        for (int i = 0, n = s.length(); i < n; ++i) {
            char c = s.charAt(i);
            if (!Characters.isWhitespace(c))
                return false;
        }
        return true;
    }

    public static String toHalfWidth(String s) {
        boolean hasHalf = false;
        for (int i = 0, n = s.length(); i < n; ++i) {
            if (Characters.hasHalfWidth(s.charAt(i))) {
                hasHalf = true;
                break;
            }
        }
        if (hasHalf) {
            StringBuffer sb = new StringBuffer(s.length());
            for (int i = 0, n = s.length(); i < n; ++i)
                sb.append((char) Characters.toHalfWidth(s.charAt(i)));
            return sb.toString();
        } else
            return s;
    }

    public static String toFullWidth(String s) {
        boolean hasFull = false;
        for (int i = 0, n = s.length(); i < n; ++i) {
            if (Characters.hasFullWidth(s.charAt(i))) {
                hasFull = true;
                break;
            }
        }
        if (hasFull) {
            StringBuffer sb = new StringBuffer(s.length());
            for (int i = 0, n = s.length(); i < n; ++i)
                sb.append((char) Characters.toFullWidth(s.charAt(i)));
            return sb.toString();
        } else
            return s;
    }

    public static String toVertical(String s) {
        boolean hasVertical = false;
        for (int i = 0, n = s.length(); i < n; ++i) {
            if (Characters.hasVertical(s.charAt(i))) {
                hasVertical = true;
                break;
            }
        }
        if (hasVertical) {
            StringBuffer sb = new StringBuffer(s.length());
            for (int i = 0, n = s.length(); i < n; ++i) {
                int c  = s.charAt(i);
                int vc = Characters.toVertical(c);
                if (vc <= 0)
                    vc = c;
                sb.append((char) vc);
            }
            return sb.toString();
        } else
            return s;
    }

}
