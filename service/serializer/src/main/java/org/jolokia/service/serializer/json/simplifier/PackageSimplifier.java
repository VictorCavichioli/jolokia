/*
 * Copyright 2009-2025 Roland Huss
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

public class PackageSimplifier extends SimplifierAccessor<Package> {

    public PackageSimplifier() {
        super(Package.class);

        addExtractor("package", new NameAttributeExtractor());
    }

    @Override
    public String extractString(Object pValue) {
        return ((Package) pValue).getName();
    }

    private static class NameAttributeExtractor implements AttributeExtractor<Package> {
        @Override
        public Object extract(Package pkg) {
            return pkg.getName();
        }
    }

}
