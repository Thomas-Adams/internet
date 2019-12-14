package org.enargit.karaf.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Table(name="blog")
public class Blog extends BasicEntity<Long> {

    private static final long serialVersionUID = -2931212678407021728L;


    private String title;
    private String text;
    private String summary;
    private String author;

    @Builder.Default
    @JsonIgnore
    @JsonManagedReference("blog-map-blog-tags")
    @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY)
    private List<MapBlogTags> blogTags = new ArrayList<>(0);

}
