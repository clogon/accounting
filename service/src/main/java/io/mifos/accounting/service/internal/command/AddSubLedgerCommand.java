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
package io.mifos.accounting.service.internal.command;

import io.mifos.accounting.api.v1.domain.Ledger;

public class AddSubLedgerCommand {

  private final String parentLedgerIdentifier;
  private final Ledger subLedger;

  public AddSubLedgerCommand(final String parentLedgerIdentifier, final Ledger subLedger) {
    super();
    this.parentLedgerIdentifier = parentLedgerIdentifier;
    this.subLedger = subLedger;
  }

  public String parentLedgerIdentifier() {
    return this.parentLedgerIdentifier;
  }

  public Ledger subLedger() {
    return this.subLedger;
  }

  @Override
  public String toString() {
    return "AddSubLedgerCommand{" +
            "parentLedgerIdentifier='" + parentLedgerIdentifier + '\'' +
            ", subLedger=" + subLedger.getIdentifier() +
            '}';
  }
}
