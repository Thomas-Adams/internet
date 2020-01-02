package org.enargit.karaf.core.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode
@Audited
@Entity
@Table(name = "subscription_attributes")
public class SubscriptionAttributes extends BasicEntity<Long> {

    @JsonBackReference("subscription-subscription-attributes")
    @ManyToOne(optional = false)
    private Subscription subscription;

    @ManyToOne(optional = false)
    private Attribute attribute;


    @Column(nullable = true)
    private Date dateValue;

    @Column(nullable = true)
    private Float floatValue;

    @Column(nullable = true)
    private Long longValue;

    @Column(nullable = true)
    private String stringValue;

    @Column(nullable = true)
    private Boolean booleanValue;
}
