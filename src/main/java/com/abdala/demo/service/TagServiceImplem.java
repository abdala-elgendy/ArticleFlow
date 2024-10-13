package com.abdala.demo.service;

import com.abdala.demo.entity.Tag;
import com.abdala.demo.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepo tagRepo;

    @Override
    public Tag createTag(Tag tag) {
        return tagRepo.save(tag);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepo.findArticlesByName(name)
                .orElseThrow(() -> new RuntimeException("Tag not found with name: " + name));
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepo.findAll();
    }

    @Override
    public void deleteTag(String name) {
        tagRepo.deleteById(name);
    }
}
