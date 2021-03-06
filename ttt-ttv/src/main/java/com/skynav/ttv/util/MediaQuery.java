/*
 * Copyright 2016 Skynav, Inc. All rights reserved.
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

package com.skynav.ttv.util;

import java.util.Map;

public class MediaQuery {

    @SuppressWarnings("unused")
    private Query query;

    private MediaQuery(Query query) {
        assert query != null;
        this.query = query;
    }

    public boolean evaluate(Map<String,Object> parameters) {
        throw new UnsupportedOperationException();
    }

    public static MediaQuery valueOf(String query) throws ParserException {
        throw new UnsupportedOperationException();
    }

    public static class Query {
        public Query() {
        }
    }

    public static class ParserException extends RuntimeException {
        static final long serialVersionUID = 0;
        public ParserException(String message) {
            super(message);
        }
    }

    public static class EvaluatorException extends RuntimeException {
        static final long serialVersionUID = 0;
        public EvaluatorException(String message) {
            super(message);
        }
    }


}
