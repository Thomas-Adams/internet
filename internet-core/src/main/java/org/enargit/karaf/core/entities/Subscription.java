package org.enargit.karaf.core.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode
@Audited
@Entity
@Table(name = "subscription")
public class Subscription extends BasicEntity<Long> {


    @ManyToOne(optional = false)
    private Campaign campaign;

    @ManyToOne
    private User user;

    @JsonManagedReference("subscription-subscription-attributes")
    @OneToMany(mappedBy = "subscription")
    private List<SubscriptionAttributes> attributes = new ArrayList<>(0);
}
