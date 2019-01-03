/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdbi.v3.core;

import org.jdbi.v3.core.config.JdbiConfig;

/**
 * Configuration for behavior related to {@link Enum}s.
 */
public class EnumConfig implements JdbiConfig<EnumConfig> {
    private EnumHandling handling;

    public EnumConfig() {
        handling = EnumHandling.BY_NAME;
    }

    private EnumConfig(EnumConfig other) {
        handling = other.handling;
    }

    /**
     * Applies to both binding and mapping.
     *
     * @return true if enums are handled by name, false if enums are handled by ordinal
     */
    @Deprecated
    public boolean isEnumHandledByName() {
        return handling == EnumHandling.BY_NAME;
    }

    /**
     * Applies to both binding and mapping.
     *
     * @param byName true if enums should be handled by name, false if enums should be handled by ordinal
     */
    @Deprecated
    public void setEnumHandledByName(boolean byName) {
        handling = byName ? EnumHandling.BY_NAME : EnumHandling.BY_ORDINAL;
    }

    public EnumHandling getEnumHandling() {
        return handling;
    }

    public EnumConfig setEnumHandling(EnumHandling handling) {
        this.handling = handling;
        return this;
    }

    @Override
    public EnumConfig createCopy() {
        return new EnumConfig(this);
    }
}
