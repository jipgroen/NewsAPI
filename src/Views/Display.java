package Views;

import Controllers.Data;
import Models.Article;
import Models.ArticleDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Display extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Data data = new Data();
        ArrayList<Article> articles = data.getArticles();
        ArrayList<ArticleDisplay> articleBlock = new ArrayList<ArticleDisplay>();

        for (int i = 0; i < articles.size(); i++) {
            articleBlock.add(new ArticleDisplay(articles.get(i)));
        }

        GridPane gridPane = new GridPane();
        for (int i = 0; i < articleBlock.size(); i++) {

            gridPane.add(articleBlock.get(i), 0, i);
        }

        gridPane.getColumnConstraints().add(new ColumnConstraints(630));
        gridPane.setGridLinesVisible(true);


        Scene scene = new Scene(gridPane, 630, 800);

        //Setting title to the Stage
        primaryStage.setTitle("News APi");

        //Adding scene to the stage
        primaryStage.setScene(scene);

        //Displaying the contents of the stage
        primaryStage.show();


    }
}

