package api;

import java.io.File;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import article.ArticleContainer;

public class NewsApiParserTest {

	private static String json = "";
	private static ArticleContainer container;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			Scanner scanner = new Scanner(new File("test/data/top-headlines.json"));
			while (scanner.hasNext()) {
				json += scanner.nextLine();
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Error while reading file: " + e.getMessage());
		}
		container = NewsApiParser.parseJson(json);

		System.out.println(json);
	}

	@Test
	public void testJsonNotEmpty() {
		Assert.assertNotNull(json);
	}

	@Test
	public void testContainerNotEmpty() {
		Assert.assertNotNull(container);
	}

	@Test
	public void testStatusOk() {
		Assert.assertEquals("ok", container.getStatus());
	}

	@Test
	public void testTotalResults() {
		Assert.assertEquals(34, container.getTotalResults());
	}

	@Test
	public void testArticles() {
		Assert.assertEquals(20, container.getArticles().size());
	}

	@Test
	public void testTitle() {
		Assert.assertEquals("Ryanair-vliegtuig onderweg naar Eindhoven maakt noodlanding in Parijs - NU.nl", container.getArticles().get(0).getTitle());
	}

	@Test
	public void testAuthor() {
		// TODO
	}

	@Test
	public void testDescription() {
		// TODO
	}

	@Test
	public void testUrl() {
		// TODO
	}

	@Test
	public void testUrlToImage() {
		// TODO
	}

	@Test
	public void testPublishedAt() {
		// TODO
	}
	

	@Test
	public void testContent() {
		// TODO
	}

	@Test
	public void testSourceName() {
		// TODO
	}
}
