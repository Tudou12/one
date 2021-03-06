/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.gradle.buildinit.plugins.internal;

import org.gradle.api.internal.DocumentationRegistry;
import org.gradle.internal.file.PathToFileResolver;
import org.gradle.util.GradleVersion;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.util.*;

public class TemplateOperationFactory {

    private final String templatepackage;
    private final PathToFileResolver fileResolver;
    private final DocumentationRegistry documentationRegistry;
    private final Map defaultBindings;

    public TemplateOperationFactory(String templatepackage, PathToFileResolver fileResolver, DocumentationRegistry documentationRegistry) {
        this.documentationRegistry = documentationRegistry;
        this.fileResolver = fileResolver;
        this.templatepackage = templatepackage;
        this.defaultBindings = loadDefaultBindings();
    }

    private Map<String, String> loadDefaultBindings() {
        String now = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());
        Map<String, String> map = new LinkedHashMap<String, String>(3);
        map.put("genDate", now);
        map.put("genUser", System.getProperty("user.name"));
        map.put("genGradleVersion", GradleVersion.current().toString());
        return map;
    }

    public TemplateOperationBuilder newTemplateOperation() {
        return new TemplateOperationBuilder(defaultBindings);
    }

    public class TemplateOperationBuilder {
        private File target;
        private Map<String, String> bindings =  new HashMap<String, String>();
        private URL templateUrl;

        public TemplateOperationBuilder(Map defaultBindings) {
            this.bindings.putAll(defaultBindings);
        }

        public TemplateOperationBuilder withTemplate(final String relativeTemplatePath) {
            this.templateUrl = getClass().getResource(templatepackage + "/" + relativeTemplatePath);
            return this;
        }

        public TemplateOperationBuilder withTemplate(URL templateURL) {
            this.templateUrl = templateURL;
            return this;
        }

        public TemplateOperationBuilder withTarget(String targetFilePath) {
            this.target = fileResolver.resolve(targetFilePath);
            return this;
        }

        public TemplateOperationBuilder withDocumentationBindings(Map<String, String> documentationBindings) {
            for (Map.Entry<String, String> entry : documentationBindings.entrySet()){
                bindings.put(entry.getKey(), documentationRegistry.getDocumentationFor(entry.getValue()));
            }
            return this;
        }

        public TemplateOperationBuilder withBindings(Map<String, String> bindings) {
            this.bindings.putAll(bindings);
            return this;
        }

        public TemplateOperation create() {
            final Set<Map.Entry<String, String>> entries = bindings.entrySet();
            Map wrappedBindings = new HashMap(entries.size());
            for (Map.Entry<String, String> entry : entries) {
                if (entry.getValue() == null) {
                    throw new IllegalArgumentException("Null value provided for binding '" + entry.getKey() + "'.");
                }
                wrappedBindings.put(entry.getKey(), new TemplateValue(entry.getValue()));
            }
            return new SimpleTemplateOperation(templateUrl, target, wrappedBindings);
        }
    }
}
