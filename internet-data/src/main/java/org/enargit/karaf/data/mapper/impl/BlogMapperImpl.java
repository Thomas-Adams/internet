package org.enargit.karaf.data.mapper.impl;

import org.enargit.karaf.data.dto.BlogDto;
import org.enargit.karaf.data.dto.BlogDto.BlogDtoBuilder;
import org.enargit.karaf.data.entities.Blog;
import org.enargit.karaf.data.entities.Blog.BlogBuilder;
import org.enargit.karaf.data.mapper.api.BlogMapper;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component(service = BlogMapper.class, immediate = true, name="BlogMapper")
public class BlogMapperImpl implements BlogMapper {



    @Override
    public List<Blog> convertToEntityList(List<BlogDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Blog> list = new ArrayList<Blog>( dtoList.size() );
        for ( BlogDto blogDto : dtoList ) {
            list.add( convertToEntity( blogDto ) );
        }
        return list;
    }

    @Override
    public List<BlogDto> convertToDTOList(List<Blog> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BlogDto> list = new ArrayList<BlogDto>( entityList.size() );
        for ( Blog blog : entityList ) {
            list.add( convertToDTO( blog ) );
        }

        return list;
    }

    @Override
    public Set<Blog> convertToEntitySet(Set<BlogDto> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<Blog> set = new HashSet<Blog>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( BlogDto blogDto : dtoSet ) {
            set.add( convertToEntity( blogDto ) );
        }

        return set;
    }

    @Override
    public Set<BlogDto> convertToDTOSet(Set<Blog> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<BlogDto> set = new HashSet<BlogDto>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( Blog blog : entitySet ) {
            set.add( convertToDTO( blog ) );
        }

        return set;
    }

    @Override
    public Blog convertToEntity(BlogDto dto) {
        if ( dto == null ) {
            return null;
        }

        BlogBuilder<?, ?> blog = Blog.builder();

        blog.id( dto.getId() );
        blog.version( dto.getVersion() );
        blog.created( dto.getCreated() );
        blog.modified( dto.getModified() );
        blog.createdBy( dto.getCreatedBy() );
        blog.modifiedBy( dto.getModifiedBy() );
        blog.title( dto.getTitle() );
        blog.text( dto.getText() );
        blog.summary( dto.getSummary() );
        blog.author( dto.getAuthor() );

        return blog.build();
    }

    @Override
    public BlogDto convertToDTO(Blog entity) {
        if ( entity == null ) {
            return null;
        }

        BlogDtoBuilder<?, ?> blogDto = BlogDto.builder();

        blogDto.id( entity.getId() );
        blogDto.version( entity.getVersion() );
        blogDto.created( entity.getCreated() );
        blogDto.modified( entity.getModified() );
        blogDto.createdBy( entity.getCreatedBy() );
        blogDto.modifiedBy( entity.getModifiedBy() );
        blogDto.title( entity.getTitle() );
        blogDto.text( entity.getText() );
        blogDto.summary( entity.getSummary() );
        blogDto.author( entity.getAuthor() );

        return blogDto.build();
    }
}
