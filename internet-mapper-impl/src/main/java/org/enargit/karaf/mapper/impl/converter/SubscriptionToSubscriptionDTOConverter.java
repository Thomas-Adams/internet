package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.SubscriptionDTO;
import org.enargit.karaf.core.entities.Subscription;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class SubscriptionToSubscriptionDTOConverter extends AbstractConverter<Subscription, SubscriptionDTO> {

    private int level;

    public SubscriptionToSubscriptionDTOConverter() {
        this.level = 0;
    }

    public SubscriptionToSubscriptionDTOConverter(int level) {
        this.level = level;
    }

    @Override
    protected SubscriptionDTO convert(Subscription source) {
        SubscriptionDTO.SubscriptionDTOBuilder subscriptionDTOBuilder = SubscriptionDTO.builder()
                .attributes(new ArrayList<>()).id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            subscriptionDTOBuilder.campaign(new CampaignToCampaignDTOConverter().convert(source.getCampaign()))
                    .user(new UserToUserDTOConverter(this.level + 1).convert(source.getUser()));
        }
        return subscriptionDTOBuilder.build();
    }
}
