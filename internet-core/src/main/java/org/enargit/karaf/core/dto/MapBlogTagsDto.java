package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.entities.Blog;
import org.enargit.karaf.core.entities.Tag;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Data
public class MapBlogTagsDto extends BasicDto<Long> {

	private static final long serialVersionUID = 1L;

	@JsonBackReference("blog-map-blog-tags-dto")
    private Blog blog;

    @JsonBackReference("tag-map-blog-tags-dto")
    private Tag tag;
}
