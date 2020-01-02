package org.enargit.karaf.core.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Data
@Audited
@Entity
@Table(name = "campaign")
public class Campaign extends BasicEntity<Long> {


    @NotNull
    @Size(min=1, max=50)
    @Column(length = 50, nullable = false)
    private String name;

    @NotNull
    @Size(min=1, max=50)
    @Column(length = 50, nullable = false)
    private String code;

    @Size(max=50)
    @Column(nullable = true, length = 50)
    private String title;

    @Size(max=10485760)
    @Column(nullable = true, length = 10485760)
    private String description;

    @NotNull
    @Column(nullable = false)
    private boolean needsLogin;

    @NotNull
    @Column(nullable = false)
    private boolean hasMailings;

    @JsonManagedReference("campaign-attributes-campaign")
    @OneToMany(mappedBy = "campaign",fetch = FetchType.LAZY)
    private List<CampaignAttributes> attributes = new ArrayList<>(0);

    @JsonManagedReference("campaign-formdefinition")
    @OneToMany(mappedBy = "campaign")
    private List<FormDefinition> formDefinitions = new ArrayList<>(0);
}
