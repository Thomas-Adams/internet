package org.enargit.karaf.data.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.data.entities.Blog;
import org.enargit.karaf.data.entities.Tag;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Data
public class MapBlogTagsDto extends BasicDto<Long> {

    @JsonBackReference("blog-map-blog-tags-dto")
    private Blog blog;

    @JsonBackReference("tag-map-blog-tags-dto")
    private Tag tag;
}
