package io.gs2.cdk.core.model;

import java.util.HashMap;
import java.util.Map;

public class NotificationSetting {

    String gatewayNamespaceId;
    Boolean enableTransferMobileNotification;
    String sound;

    public NotificationSetting(
    ) {
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("GatewayNamespaceId", gatewayNamespaceId);
                put("EnableTransferMobileNotification", enableTransferMobileNotification);
                put("Sound", sound);
            }
        };
    }
}
