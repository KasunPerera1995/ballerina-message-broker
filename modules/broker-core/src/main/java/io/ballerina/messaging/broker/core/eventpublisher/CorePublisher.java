package io.ballerina.messaging.broker.core.eventpublisher;

import java.util.Map;

/**
 * CorePublisher handles broker publishing.
 */
public interface CorePublisher {

    void publishNotification(int id, Map<String, String> properties);

    String getRoutingKey(int id, Map<String, String> properties);
}
