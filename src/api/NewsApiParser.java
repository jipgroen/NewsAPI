package api;

import com.google.gson.GsonBuilder;

import article.ArticleContainer;

/*
 * Used tutorials:
 * https://futurestud.io/tutorials/gson-mapping-of-arrays-and-lists-of-objects
 * https://www.baeldung.com/gson-deserialization-guide
 */

/**
 * 
 * @author drewes
 *
 */
public class NewsApiParser {

	public static ArticleContainer parseJson(String json) {
		return (ArticleContainer) new GsonBuilder().create().fromJson(json, ArticleContainer.class);
	}
}
