import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class Brochure extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        Rectangle rectangle = new Rectangle();

        rectangle.setX((primaryStage.getWidth() - 300) / 2);
        rectangle.setY(0);
        rectangle.setWidth(300.0f);
        rectangle.setHeight(50.0f);
        rectangle.setFill(Color.BLUE);
        BorderPane border = new BorderPane();
        border.setTop(rectangle);
        BorderPane.setAlignment(rectangle, Pos.CENTER);
        Scene scene = new Scene(border, 400, 400);

        Circle c = new Circle();
        c.setCenterX(30);
        c.setCenterY(30);
        c.setRadius(45);
        c.setFill(Color.GREEN);
        border.setRight(c);
        BorderPane.setAlignment(c, Pos.CENTER);

        Polygon p = new Polygon();
        p.getPoints().addAll(50.0, 400.0, 75.0, 300.0, 100.0, 400.0);
        border.setLeft(p);
        BorderPane.setAlignment(p, Pos.CENTER);


        String message = "WELCOME TO OOP-TOPIA!";
        Text t = new Text(rectangle.getX(), rectangle.getY() + 15, message);
        t.setFill(Color.WHITE);
        border.getChildren().add(t);
        String star = "You can be a star!";
        Text starText = new Text(star);
        starText.setFont(Font.font("Arial", 20));
        border.setBottom(starText);
        BorderPane.setAlignment(starText, Pos.CENTER);

        ImageView image = new ImageView();
        image.setImage(new Image("\\frank.jpg"));
        image.setFitHeight(300);
        image.setFitWidth(300);
        border.setCenter(image);

        primaryStage.setTitle("TravelBrochure");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * [main description].
     * @param args [description].
     */
    public static void main(String[] args) {
        launch(args);
    }
}
