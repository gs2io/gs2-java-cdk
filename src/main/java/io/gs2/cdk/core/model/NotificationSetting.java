package io.gs2.cdk.core.model;

import io.gs2.cdk.core.model.options.NotificationSettingOptions;
import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class NotificationSetting {

    private String gatewayNamespaceId;
    private Boolean enableTransferMobileNotification;
    private String sound;

    public NotificationSetting(
            NotificationSettingOptions options
    ) {
        this.gatewayNamespaceId = options.gatewayNamespaceId;
        this.enableTransferMobileNotification = options.enableTransferMobileNotification;
        this.sound = options.sound;
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
