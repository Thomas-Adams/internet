package org.enargit.karaf.data.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Data
@Entity
@Table(name = "map_blog_tags")
public class MapBlogTags extends BasicEntity<Long> {

    private static final long serialVersionUID = -859478640043556971L;


    @JsonBackReference("blog-map-blog-tags")
    @ManyToOne(fetch = FetchType.EAGER)
    private Blog blog;

    @JsonBackReference("tag-map-blog-tags")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tag tag;
}
