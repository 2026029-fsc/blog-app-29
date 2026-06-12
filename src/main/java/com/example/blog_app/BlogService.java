package com.example.blog_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void tourokuBlog(String title, String text) {

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setText(text);

        blogRepository.save(blog);
    }

    public List<Blog> getBlogList() {
        return blogRepository.findAll();
    }

    public List<Blog> showitiranPage() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id);
    }
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
