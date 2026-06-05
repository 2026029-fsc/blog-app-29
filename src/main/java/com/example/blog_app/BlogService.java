package com.example.blog_app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void tourokuBlog( String title, String text) {

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setText(text);
        
        blogRepository.save(blog);
    }
}
