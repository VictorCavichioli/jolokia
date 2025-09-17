/*
 * Copyright 2009-2013 Roland Huss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jolokia.service.serializer.json.simplifier;

import java.net.URL;

/**
 * Simplifier for URLs which result in a map with a single key <code>url</code>
 *
 * @author roland
 * @since Jul 27, 2009
 */
public class UrlSimplifier extends SimplifierAccessor<URL> {

    /**
     * No arg constructor as required for simplifiers
     */
    public UrlSimplifier() {
        super(URL.class);
        addExtractor("url", new UrlAttributeExtractor());
    }

    @Override
    public String extractString(Object pValue) {
        return ((URL) pValue).toExternalForm();
    }

    private static class UrlAttributeExtractor implements AttributeExtractor<URL> {
        @Override
        public Object extract(URL pUrl) {
            return pUrl.toExternalForm();
        }
    }

}
