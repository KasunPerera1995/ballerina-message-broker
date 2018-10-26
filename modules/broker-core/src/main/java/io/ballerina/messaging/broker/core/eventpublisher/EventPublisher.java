package io.ballerina.messaging.broker.core.eventpublisher;

import io.ballerina.messaging.broker.core.Broker;
import io.ballerina.messaging.broker.eventing.EventSync;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.metrics.core.Metrics;

import java.util.Map;
import java.util.Objects;

/**
 * Implementation of BrokerPublisher for {@link EventSync}.
 */
public class EventPublisher implements EventSync {

    private static final Logger logger = LoggerFactory.getLogger(Metrics.class);
    private CorePublisher exchangePublisher = new NullCorePublisher();
    private Broker broker = null;
    private String name = "brokerpublisher";

    @Override
    public String getName() {
        return name;
    }

    public void publish(int id, Map<String, String> properties) {

        exchangePublisher.publishNotification(id, properties);

    }

    public void setBroker(Broker broker) {

        this.broker = broker;
    }

    public void activate() {

        if (Objects.nonNull(this.broker)) {
            this.exchangePublisher = new DefaultCorePublisher(this.broker);
        }
    }

    public void deactivate() {
        this.exchangePublisher = new NullCorePublisher();
    }

}
