package com.urlShort.urlShort.Controller;

import com.urlShort.urlShort.Entity.Url;
import com.urlShort.urlShort.Services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam("originalUrl") String originalUrl, Model model) {
        String shortUrl = urlService.shortenUrl(originalUrl);
        model.addAttribute("shortUrl", shortUrl);
        return "result";
    }

    @GetMapping("/{shortUrl}")
    public String redirect(@PathVariable String shortUrl) {
        String originalUrl = urlService.getOriginalUrl(shortUrl);
        return "redirect:" + originalUrl;
    }

    @GetMapping("/history")
    public String getAllUrls(Model model) {
        List<Url> urls = urlService.getAllUrls();
        model.addAttribute("urls", urls);
        return "history";
    }
}
