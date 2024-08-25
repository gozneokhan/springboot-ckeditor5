package com.example.demo.service;

import com.example.demo.dto.SaveDTO;
import com.example.demo.entity.ContentEntity;
import com.example.demo.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    private ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {

        this.contentRepository = contentRepository;
    }

    public void saveContent(SaveDTO saveDTO) {

        String title = saveDTO.getTitle();
        String content = saveDTO.getContent();

        ContentEntity contentEntity = new ContentEntity();

        contentEntity.setTitle(title);
        contentEntity.setContent(content);

        contentRepository.save(contentEntity);

        return;
    }

    public List<ContentEntity> slectContent() {

        return contentRepository.findAll();
    }
}