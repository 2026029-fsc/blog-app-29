package com.example.blog_app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/")
    public String blog() {
        return "redirect:/blog";
    }

    @GetMapping("/blog")
    public String showBlogPage() {

        return "blog";
    }

    @GetMapping("/prof")
    public String showprofPage() {

        return "blog/prof";
    }

    @GetMapping("/toukou")
    public String showtoukouPage() {

        return "blog/toukou";
    }

    @GetMapping("/itiran")
    public String showitiranPage(Model model) {
        model.addAttribute("blogs", blogService.showitiranPage());
        return "blog/itiran";
    }

    @GetMapping("/blogs")
    public String showList(Model model) {
        List<Blog> blogList = blogService.getBlogList();
        model.addAttribute("blogList", blogList);
        return "blog";
    }

    @PostMapping("/blog/register")
    public String register(
            // @RequestParam("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("text") String text) {

        blogService.tourokuBlog(title, text);

        return "redirect:/itiran";
    }

    @GetMapping("/blogs/{id}")
    public String showDetail(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @PostMapping("/blogs/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        blogService.deleteBlog(id);
        return "redirect:/blogs";
    }
}

