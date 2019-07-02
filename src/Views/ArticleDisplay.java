package Models;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class ArticleDisplay extends GridPane {
    private String author, title, description, imgurl;

    public ArticleDisplay(Article article) throws FileNotFoundException {
        this.setPadding(new Insets(15, 12, 15, 12));
        this.setStyle("-fx-background-color: #336699;");
        this.autosize();

        this.setData(article);
        this.createGrid();
    }

    private void setData(Article article) {
        this.author = "author " + article.getAuthor();
        this.title = "title " + article.getTitle();
        this.description = "description " + article.getDescription();
        this.imgurl = article.getUrlToImage();
    }

    private void createGrid() {
        //bovenste helft
        GridPane upper = new GridPane();
        upper.getColumnConstraints().add(new ColumnConstraints(400));
        this.add(upper, 0, 0);

        //linker kant
        GridPane titleAuthor = new GridPane();
        upper.add(titleAuthor, 0, 0);
        titleAuthor.getColumnConstraints().add(new ColumnConstraints(200));
        Text titleText = new Text(this.title);
        titleText.setWrappingWidth(300);
        titleAuthor.add(new Text(this.author), 0, 0);
        titleAuthor.add(titleText, 0, 1);


        //rechter kant
        GridPane image = new GridPane();
        upper.add(image, 1, 0);
        image.getColumnConstraints().add(new ColumnConstraints(500));
        String urls;
        if (this.imgurl.equals("null")) {
            urls = "https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg";
        } else {
            urls = this.imgurl;
        }
        Image imgItem = new Image(urls);
        ImageView iv1 = new ImageView();
        iv1.setFitHeight(100);
        iv1.setFitWidth(200);
        iv1.setImage(imgItem);

        image.add(iv1, 0, 0);

        //onderste helft
        GridPane lower = new GridPane();
        lower.getColumnConstraints().add(new ColumnConstraints(610));
        this.add(lower, 0, 1);

        Text descriptionText = new Text(this.description);
        descriptionText.setWrappingWidth(610);
        lower.add(descriptionText, 0, 0);


    }

}
