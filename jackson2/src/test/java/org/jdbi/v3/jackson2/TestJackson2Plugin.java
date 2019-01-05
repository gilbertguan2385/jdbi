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
package org.jdbi.v3.jackson2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.jdbi.v3.core.rule.DatabaseRule;
import org.jdbi.v3.core.rule.PgDatabaseRule;
import org.jdbi.v3.json.AbstractJsonMapperTest;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.junit.Before;
import org.junit.Rule;

public class TestJackson2Plugin extends AbstractJsonMapperTest {
    @Rule
    public DatabaseRule db = new PgDatabaseRule()
        .withPlugin(new SqlObjectPlugin())
        .withPlugin(new Jackson2Plugin())
        .withPlugin(new PostgresPlugin());

    @Before
    public void before() {
        jdbi = db.getJdbi();
        jdbi.getConfig(Jackson2Config.class).setMapper(new ObjectMapper().registerModule(new ParameterNamesModule()));
    }
}
