package me.yubin.springbootdeveloper.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.yubin.springbootdeveloper.domain.Article;
import me.yubin.springbootdeveloper.dto.AddArticleRequest;
import me.yubin.springbootdeveloper.dto.UpdateArticleRequest;
import me.yubin.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
