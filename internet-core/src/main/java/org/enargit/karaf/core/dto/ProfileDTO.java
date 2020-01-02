package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.json.JodaDateTimeSerializer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ProfileDTO extends BasicDTO<Long> {

    @NotNull
    @Size(min = 1, max=50)
    private String givenName;

    @NotNull
    @Size(min = 1, max=50)
    private String surName;

    @JsonSerialize(using = JodaDateTimeSerializer.class)
    private Date birthday;

    private UserDTO user;


    @JsonManagedReference("profile-profile-attributes-dto")
    private List<ProfileAttributesDTO> attributes = new ArrayList<>(0);


}
