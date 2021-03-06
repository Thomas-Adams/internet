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
@EqualsAndHashCode
@Data
@Audited
@Entity
@Table(name = "campaign_attributes")
public class CampaignAttributes extends BasicEntity<Long> {


    @JsonBackReference("campaign-attributes-campaign")
    @ManyToOne(optional = false)
    private Campaign campaign;

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
