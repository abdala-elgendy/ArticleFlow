//package com.abdala.demo.service;
//
//import com.abdala.demo.entity.Tag;
//import com.abdala.demo.repository.TagRepo;
//import com.abdala.demo.service.dto.TagDTO;
//import com.abdala.demo.service.mapper.TagMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class TagServiceImplem implements TagService {
//
//    @Autowired
//    private TagRepo tagRepository;
//
//    @Autowired
//    private TagMapper tagMapper;
//
//    @Override
//    public Tag createTag(Tag tag) {
//        return null;
//    }
//
//    @Override
//    public Tag getTagByName(String name) {
//        return null;
//    }
//
//    @Override
//    public TagDTO createTag(TagDTO tagDTO) {
//        Tag tag = tagMapper.toEntity(tagDTO);
//        tag = tagRepository.save(tag);
//        return tagMapper.toDTO(tag);
//    }
//
//    @Override
//    public List<TagDTO> getAllTags() {
//        List<Tag> tags = tagRepository.findAll();
//        return tags.stream()
//                .map(tagMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public TagDTO getTagById(Long id) {
//        Tag tag = tagRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Tag not found"));
//        return tagMapper.toDTO(tag);
//    }
//
//
//}