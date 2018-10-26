package io.ballerina.messaging.broker.core.eventpublisher;

import java.util.Map;

/**
 * Default implementation of {@link CorePublisher}.
 */
public class NullCorePublisher implements CorePublisher {

    @Override
    public void publishNotification(int id, Map<String, String> properties) {
        //No need
    }

    @Override
    public String getRoutingKey(int id, Map<String, String> properties) {

        //No need
        return null;
    }

}
