package org.enargit.karaf.core.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Data
@Audited
@Entity
@Table(name = "user_role")
public class UserRole extends BasicEntity<Long> {

    @JsonBackReference("role-user-roles")
    @ManyToOne(optional = false)
    private Role role;


    @JsonBackReference("user-user-roles")
    @ManyToOne(optional = false)
    private User user;

}
