package org.enargit.karaf.data.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.data.entities.MapBlogTags;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Data
public class TagDto extends BasicDto<Long> {

    private String name;

    @JsonManagedReference("tag-map-blog-tags-dto")
    private List<MapBlogTags> blogTags = new ArrayList<>(0);

}
