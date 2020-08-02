package my.IbmPackage.repository;

import my.IbmPackage.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
