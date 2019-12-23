package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.SubscriptionDTO;
import org.enargit.karaf.core.entities.Subscription;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class SubscriptionDTOToSubscriptionConverter extends AbstractConverter<SubscriptionDTO, Subscription> {

    private int level;

    public SubscriptionDTOToSubscriptionConverter() {
        this.level = 0;
    }

    public SubscriptionDTOToSubscriptionConverter(int level) {
        this.level = level;
    }

    @Override
    protected Subscription convert(SubscriptionDTO source) {
        Subscription.SubscriptionBuilder subscriptionBuilder = Subscription.builder()
                .attributes(new ArrayList<>()).id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            subscriptionBuilder.campaign(new CampaignDTOToCampaignConverter().convert(source.getCampaign()))
                    .user(new UserDTOToUserConverter(this.level + 1).convert(source.getUser()));
        }
        return subscriptionBuilder.build();
    }
}
