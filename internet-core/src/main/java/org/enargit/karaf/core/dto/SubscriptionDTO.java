package org.enargit.karaf.core.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SubscriptionDTO extends BasicDTO<Long> {


    private CampaignDTO campaign;

    private UserDTO user;

    @Builder.Default
    @JsonManagedReference("subscription-subscription-attributes-dto")
    private List<SubscriptionAttributesDTO> attributes = new ArrayList<>(0);
}
