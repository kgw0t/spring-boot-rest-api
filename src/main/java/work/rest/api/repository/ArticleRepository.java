package work.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.rest.api.bean.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
