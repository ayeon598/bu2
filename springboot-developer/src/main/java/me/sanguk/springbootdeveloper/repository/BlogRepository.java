package me.sanguk.springbootdeveloper.repository;

import me.sanguk.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long>{

}