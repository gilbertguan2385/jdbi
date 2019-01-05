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
package org.jdbi.v3.json.internal;

import java.sql.PreparedStatement;
import java.sql.Types;
import org.jdbi.v3.core.argument.AbstractArgumentFactory;
import org.jdbi.v3.core.argument.Argument;
import org.jdbi.v3.core.argument.internal.strategies.LoggableBinderArgument;
import org.jdbi.v3.core.config.ConfigRegistry;
import org.jdbi.v3.json.Json;

/**
 * Default {@code @Json String} argumentfactory that just binds as a varchar.
 */
@Json
public class JsonStringArgumentFactory extends AbstractArgumentFactory<String> {
    public JsonStringArgumentFactory() {
        super(Types.VARCHAR);
    }

    @Override
    public Argument build(String value, ConfigRegistry config) {
        return new LoggableBinderArgument<>(value, PreparedStatement::setString);
    }
}
