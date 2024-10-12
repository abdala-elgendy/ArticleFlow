package com.abdala.demo.service;

import com.abdala.demo.entity.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(Tag tag);
    Tag getTagByName(String name);
    List<Tag> getAllTags();
    void deleteTag(String name);
}
