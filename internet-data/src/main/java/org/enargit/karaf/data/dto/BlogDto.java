package org.enargit.karaf.data.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Data
public class BlogDto extends BasicDto<Long> {

    private String title;
    private String text;
    private String summary;
    private String author;

    @JsonManagedReference("blog-map-blog-tags-dto")
    private List<MapBlogTagsDto> blogTags = new ArrayList<>(0);

}
