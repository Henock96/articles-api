package com.dreesis.articles.service;

import com.dreesis.articles.domaine.Source;
import com.dreesis.articles.repository.SourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {
    private final SourceRepository sourceRepository;

    public SourceService(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    public List<Source> getSources(){
        return sourceRepository.findAll();
    }
}
