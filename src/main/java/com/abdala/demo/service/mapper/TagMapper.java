//package com.abdala.demo.service.mapper;
//import com.abdala.demo.entity.Tag;
//import com.abdala.demo.service.dto.TagDTO;
//import org.springframework.stereotype.Component;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class TagMapper {
//
//    public TagDTO toDTO(Tag tag) {
//        if (tag == null) {
//            return null;
//        }
//
//        TagDTO tagDTO = new TagDTO();
//       // tagDTO.setId(tag.getId());
//        tagDTO.setName(tag.getName());
//        return tagDTO;
//    }
//
//    public Tag toEntity(TagDTO tagDTO) {
//        if (tagDTO == null) {
//            return null;
//        }
//
//        Tag tag = new Tag();
//        //tag.setId(tagDTO.getId());
//        tag.setName(tagDTO.getName());
//        return tag;
//    }
//}
//
//
