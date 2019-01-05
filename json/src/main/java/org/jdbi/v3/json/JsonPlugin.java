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
package org.jdbi.v3.json;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.json.internal.JsonArgumentFactory;
import org.jdbi.v3.json.internal.JsonColumnMapperFactory;
import org.jdbi.v3.json.internal.JsonStringArgumentFactory;
import org.jdbi.v3.json.internal.JsonStringColumnMapperFactory;

public class JsonPlugin implements JdbiPlugin {
    @Override
    public void customizeJdbi(Jdbi jdbi) {
        jdbi.registerArgument(new JsonStringArgumentFactory());
        jdbi.registerArgument(new JsonArgumentFactory());
        jdbi.registerColumnMapper(new JsonStringColumnMapperFactory());
        jdbi.registerColumnMapper(new JsonColumnMapperFactory());
    }
}
