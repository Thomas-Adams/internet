package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class MapBlogTagsDTO extends BasicDTO<Long> {
	
	@JsonBackReference("blog-map-blog-tags-dto")
	private BlogDTO blog;

	@JsonBackReference("tag-map-blog-tags-dto")
	private TagDTO tag;
}
