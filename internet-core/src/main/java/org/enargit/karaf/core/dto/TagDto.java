package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.entities.MapBlogTags;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Data
public class TagDto extends BasicDto<Long> {

	private static final long serialVersionUID = 1L;

	private String name;

	@Builder.Default
    @JsonManagedReference("tag-map-blog-tags-dto")
    private List<MapBlogTags> blogTags = new ArrayList<>(0);

}
