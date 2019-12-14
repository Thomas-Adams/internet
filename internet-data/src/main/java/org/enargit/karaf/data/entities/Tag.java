package org.enargit.karaf.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Data
@Entity
@Table(name = "tag")
public class Tag extends BasicEntity<Long> {

    private static final long serialVersionUID = 8218189640944604667L;
    private String name;

    @JsonIgnore
    @JsonManagedReference("tag-map-blog-tags")
    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private List<MapBlogTags> blogTags = new ArrayList<>(0);

}
