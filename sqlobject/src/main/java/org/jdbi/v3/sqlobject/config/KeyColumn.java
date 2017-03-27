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
package org.jdbi.v3.sqlobject.config;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import org.jdbi.v3.core.config.ConfigRegistry;
import org.jdbi.v3.core.mapper.MapEntryMapper;

/**
 * Configures the column to use for map keys, for SQL methods that return {@link java.util.Map}, or Guava's Multimap.
 * <p>Example:</p>
 * <pre>
 * &#64;SqlQuery("select * from user")
 * &#64;KeyColumn("id")
 * Map&lt;Long, User&gt; getUsersById();
 * </pre>
 */
@ConfiguringAnnotation(KeyColumn.Impl.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface KeyColumn {
    /**
     * The column name to use for map keys.
     */
    String value();

    class Impl implements Configurer {
        @Override
        public void configureForMethod(ConfigRegistry registry, Annotation annotation, Class<?> sqlObjectType, Method method) {
            KeyColumn keyColumn = (KeyColumn) annotation;
            registry.get(MapEntryMapper.Config.class).setKeyColumn(keyColumn.value());
        }
    }
}