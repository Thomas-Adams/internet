package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class TagDTO extends BasicDTO<Long> {


	private String name;

	@Builder.Default
	@JsonManagedReference("tag-map-blog-tags-dto")
	private List<MapBlogTagsDTO> blogTags = new ArrayList<>(0);

}
