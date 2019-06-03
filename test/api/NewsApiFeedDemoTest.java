package api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewsApiFeedDemoTest {

	private NewsApiFeedDemo feed;

	@Before
	public void setUp() throws Exception {
		feed = new NewsApiFeedDemo();
	}

	@Test
	public void testRequest() {
		Assert.assertNotNull(feed.request());
	}

}
