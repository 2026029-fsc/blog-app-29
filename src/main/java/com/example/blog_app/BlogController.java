package com.example.blog_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BlogController {

    @GetMapping("/")
    public String blog() {
        return "redirect:/blogas";
    }

    @GetMapping("/blogs")
    public String showBlogPage() {

        return "blogs";
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
    public String showitiranPage() {

        return "blog/itiran";
    }

    @Autowired
    private BlogService blogService;

    public void BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog/register")
    public String register(
            // @RequestParam("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("text") String text) {

        blogService.tourokuBlog(title, text);

        return "redirect:/blogs";
        // @GetMapping("/blogs")
        // public String creat(@ModelAttribute BlogForm form) {
        // blogService.register(form);
        // return "redirect:/blogs";
        // }

        // @GetMapping("/blogs/{id}")
        // public String detail(@PathVariable Long id, Model model) {
        // Optional<blog> blogOpt = blogService.findById(id);
        // if (blogOpt.isempty()) {
        // return "redirect:/blogs";
        // }
        // model.addAttribute(blogOpt.get());
        // return "blogs/detail";
        // }

    }
}