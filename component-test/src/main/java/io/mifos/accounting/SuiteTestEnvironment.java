/*
 * Copyright 2017 The Mifos Initiative.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mifos.accounting;

import io.mifos.core.test.env.TestEnvironment;
import io.mifos.core.test.fixture.cassandra.CassandraInitializer;
import io.mifos.core.test.fixture.mariadb.MariaDBInitializer;
import org.junit.ClassRule;
import org.junit.rules.RuleChain;
import org.junit.rules.RunExternalResourceOnce;
import org.junit.rules.TestRule;

/**
 * @author Myrle Krantz
 */
public class SuiteTestEnvironment {
  static final String APP_NAME = "accounting-v1";
  static final TestEnvironment testEnvironment = new TestEnvironment(APP_NAME);
  static final CassandraInitializer cassandraInitializer = new CassandraInitializer();
  static final MariaDBInitializer mariaDBInitializer = new MariaDBInitializer();

  @ClassRule
  public static TestRule orderClassRules = RuleChain
      .outerRule(new RunExternalResourceOnce(testEnvironment))
      .around(new RunExternalResourceOnce(cassandraInitializer))
      .around(new RunExternalResourceOnce(mariaDBInitializer));
}