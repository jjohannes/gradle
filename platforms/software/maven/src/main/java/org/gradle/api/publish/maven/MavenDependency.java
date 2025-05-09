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
package org.gradle.api.publish.maven;

import org.gradle.internal.HasInternalProtocol;
import org.jspecify.annotations.Nullable;

/**
 * A dependency declared as part of an {@link MavenPublication}.
 *
 * @deprecated This type is not referenced by any other public API classes. It will be removed in Gradle 9.0
 */
@Deprecated
@HasInternalProtocol
public interface MavenDependency {
    /**
     * The groupId value for this dependency.
     */
    String getGroupId();

    /**
     * The artifactId value for this dependency.
     */
    String getArtifactId();

    /**
     * The version value for this dependency.
     */
    String getVersion();

    /**
     * The type value for this dependency.
     */
    @Nullable
    String getType();
}
