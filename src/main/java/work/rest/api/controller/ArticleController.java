package work.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.rest.api.bean.Article;
import work.rest.api.repository.ArticleRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public Article get(@PathVariable int id) {
        Optional<Article> target = articleRepository.findById(id);
        return target.orElse(null);
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public Article post(@RequestBody Article article) {
        LocalDateTime now = LocalDateTime.now();
        article.setUpdatedAt(now);

        Article newArticle = articleRepository.save(article);
        return newArticle;
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT)
    public Article put(@PathVariable int id, @RequestBody Article article) {
        Optional<Article> target = articleRepository.findById(id);
        target.ifPresent(t -> {
            LocalDateTime now = LocalDateTime.now();
            t.setTitle(article.getTitle());
            t.setBody(article.getBody());
            t.setAuthor(article.getAuthor());
            t.setUpdatedAt(now);

            articleRepository.save(t);
        });
        return target.orElse(null);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
    public Article delete(@PathVariable int id) {
        Optional<Article> target = articleRepository.findById(id);
        target.ifPresent(t -> {
            LocalDateTime now = LocalDateTime.now();
            t.setUpdatedAt(now);

            articleRepository.delete(t);
        });
        return target.orElse(null);
    }
}
