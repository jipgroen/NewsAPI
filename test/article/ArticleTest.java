package article;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArticleTest {

	private static Article article;
	private static final String SOURCE_NAME = "Nu.nl";
	private static final String AUTHOR = "L. Drewes";
	private static final String TITLE = "De titel";
	private static final String DESCRIPTION = "De beschrijving van het artikel.";
	private static final String URL = "www.nu.nl";
	private static final String URL_TO_IMAGE = "www.nu.nl/image.jpg";
	private static final String PUBLISHED_AT = "2019-04-28T08:04:42Z";
	private static final String CONTENT = "De content van het artikel.";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		article = new Article();
		article.setAuthor(AUTHOR);
		article.setTitle(TITLE);
		article.setDescription(DESCRIPTION);
		article.setUrl(URL);
		article.setUrlToImage(URL_TO_IMAGE);
		article.setPublishedAt(PUBLISHED_AT);
		article.setContent(CONTENT);
		article.setSource(article.new Source(null, SOURCE_NAME));
	}

	@Test
	public void testDateTimeFormat() {
		Assert.assertEquals(PUBLISHED_AT, article.getPublishedAt("dd-MM-yyyy HH:mm:ss"));
	}
	
	@Test
	public void testDateFormat() {
		Assert.assertEquals("28-04-2019", article.getPublishedAt("dd-MM-yyyy"));
	}
	
	@Test
	public void testSourceName() {
		Assert.assertEquals(SOURCE_NAME, article.getSource().getName());
	}

}
