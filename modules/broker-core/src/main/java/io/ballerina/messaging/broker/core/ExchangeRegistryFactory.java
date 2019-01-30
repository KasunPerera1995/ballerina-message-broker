/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package io.ballerina.messaging.broker.core;

import io.ballerina.messaging.broker.common.EventSync;
import io.ballerina.messaging.broker.core.configuration.BrokerCoreConfiguration;
import io.ballerina.messaging.broker.core.store.dao.BindingDao;
import io.ballerina.messaging.broker.core.store.dao.ExchangeDao;

import java.util.Objects;

/**
 * Factory for creating exchange registry objects.
 */
public class ExchangeRegistryFactory {

    private final ExchangeDao exchangeDao;

    private final BindingDao bindingDao;

    private final EventSync eventSync;

    private final BrokerCoreConfiguration.EventConfig eventConfig;

    public ExchangeRegistryFactory(ExchangeDao exchangeDao, BindingDao bindingDao, EventSync eventSync,
                                   BrokerCoreConfiguration.EventConfig eventConfig) {
        this.exchangeDao = exchangeDao;
        this.bindingDao = bindingDao;
        this.eventSync = eventSync;
        this.eventConfig = eventConfig;
    }

    /**
     * Create a observable or a non observable exchange registry with the give arguments.
     * @return ExchangeRegistryImpl object
     */
    public ExchangeRegistry getExchangeRegistry() {
        if (Objects.nonNull(this.eventSync) && eventConfig.getEnableExchangeAdminEvents()) {
            ExchangeRegistryImpl exchangeRegistry = new ExchangeRegistryImpl(exchangeDao, bindingDao);
            return new ObservableExchangeRegistryImpl(exchangeRegistry, eventSync);
        } else {
            return new ExchangeRegistryImpl(exchangeDao, bindingDao);
        }
    }
}
