package article;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Article {

	private Source source;
	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private String publishedAt;
	private String content;
	private Date publishedDate;
	
	//2019-04-28T09:33:00Z
	private SimpleDateFormat parseFromFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");  

	/**
	 * @return the source
	 */
	public Source getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(Source source) {
		this.source = source;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the urlToImage
	 */
	public String getUrlToImage() {
		return urlToImage;
	}

	/**
	 * @param urlToImage
	 *            the urlToImage to set
	 */
	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	/**
	 * @return the publishedAt
	 */
	public String getPublishedAt() {
		return publishedAt;
	}
	
	public String getPublishedAt(String pattern) {
		if (pattern.isEmpty()) {
			pattern = "dd-MM-yyyy";
		}
		if (this.publishedDate == null) {
			try {
				this.publishedDate = parseFromFormat.parse(publishedAt);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				return simpleDateFormat.format(publishedDate);
			} catch (ParseException e) {
				System.out.println("Unable to parse " + publishedAt + " using " + parseFromFormat);
			}
		}
		return this.publishedAt;
	}

	/**
	 * @param publishedAt
	 *            the publishedAt to set
	 */
	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return this.getPublishedAt("dd-MM-yyyy hh:mm") + " - " + title + ".";
	}

	
	public class Source {
		private String id;
		private String name;

		public Source(String id, String name) {
			this.setId(id);
			this.setName(name);
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
	}
}
