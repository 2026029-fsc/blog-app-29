package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
    private final JdbcClient jdbcClient;

    public BlogRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void save(Blog blog) {
        jdbcClient.sql("INSERT INTO blogs ( title, text) VALUES ( :title, :text)")
                .param("title", blog.getTitle())
                .param("text", blog.getText())
                .update();
    }

    public List<Blog> findAll() {
        return jdbcClient.sql("SELECT id, title, text FROM blogs")
                .query(Blog.class)
                .list();
    }

    public Blog findById(Long id) {
        return jdbcClient.sql("SELECT id, title, text FROM blogs WHERE id = :id")
                .param("id", id)
                .query(Blog.class)
                .single();
    }

    public void deleteById(Long id) {
        jdbcClient.sql("DELETE FROM blogs WHERE id = :id")
                .param("id", id)
                .update();
    }
}