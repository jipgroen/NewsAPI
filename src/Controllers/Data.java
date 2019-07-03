package Controllers;

import Models.Article;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Data {
    private API api = new API("https://newsapi.org/v2/top-headlines?country=nl&apiKey=870a0dc00f20454fbebc2ae828f98aa5");

    public ArrayList<Article> getArticles() throws IOException {

        JSONObject json = api.getResponse();
        JSONArray articles = json.getJSONArray("articles");

        ArrayList<Article> articlesObject = new ArrayList<Article>();

        for (int i = 0; i < articles.length(); i++) {
            JSONObject articleJson = articles.getJSONObject(i);

            Article article = new Article();
            article.setAuthor(articleJson.get("author").toString());
            article.setTitle(articleJson.get("title").toString());
            article.setDescription(articleJson.get("description").toString());
            article.setUrl(articleJson.get("url").toString());
            article.setUrlToImage(articleJson.get("urlToImage").toString());
            article.setPublishedAt(articleJson.get("publishedAt").toString());
            article.setContent(articleJson.get("content").toString());


            articlesObject.add(article);
        }

        return articlesObject;
    }

}
