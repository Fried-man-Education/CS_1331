import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class Minesweeper extends Application {
  @Override
  public void start(Stage primaryStage) {
      // initial setup
      primaryStage.setTitle("Minesweeper");
      primaryStage.setWidth(500); // pretty sure not needed
      primaryStage.setHeight(500); // pretty sure not needed

      // title screen
      Pane root = new Pane();

      Text titleText = new Text("Welcome to Minesweeper!");
      titleText.setFont(Font.font("Arial", 20));
      titleText.setLayoutX(125);
      titleText.setLayoutY(40);
      root.getChildren().add(titleText);

      ComboBox<String> combo = new ComboBox<String>();
      combo.setPromptText("Select Difficulty...");
      ObservableList<String> list = combo.getItems();
      list.add("Easy");
      list.add("Medium");
      list.add("Hard");
      combo.setLayoutX(170); // 225 is middle
      combo.setLayoutY(125);
      root.getChildren().add(combo);

      TextField name = new TextField();
      name.setPromptText("Name...");
      name.setLayoutX(160); // 225 is middle
      name.setLayoutY(225);
      root.getChildren().add(name);

      Button startB = new Button("Start");
      startB.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
          if (name.getText().length() == 0 || combo.getValue() == null) {
            fail();
          }else {
            game(primaryStage, combo.getValue(), name.getText());
          }
        }
      });
      startB.setLayoutX(160); // 225 is middle
      startB.setLayoutY(300);
      root.getChildren().add(startB);

      primaryStage.setScene(new Scene(root, 500, 500));
      primaryStage.show();
  }

  public void fail () {
    Stage errorStage = new Stage();
    errorStage.setTitle("Warning");
    Pane root = new Pane();

    Text titleText = new Text("Invalid inputs, Please select a difficulty and your name.");
    titleText.setFont(Font.font("Arial", 20));
    titleText.setLayoutX(0);
    titleText.setLayoutY(20);
    root.getChildren().add(titleText);

    Button killB = new Button("OK");
    killB.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        errorStage.hide();
      }
    });
    killB.setLayoutX(250);
    killB.setLayoutY(70);
    root.getChildren().add(killB);

    errorStage.setScene(new Scene(root, 500, 200));
    errorStage.show();
  }

  public void game (Stage primaryStage, String diff, String name) {
    Pane root = new Pane();
    Difficulty mode;
    switch (diff) {
      case "Easy":
        mode = Difficulty.EASY;
        break;
      case "Medium":
        mode = Difficulty.MEDIUM;
        break;
      default:
        mode = Difficulty.HARD;
        break;
    }
    final MinesweeperGame game = new MinesweeperGame(mode);
    Button[][] board = new Button[15][15];
    for (int x = 0; x < 15; x++) {
      for (int y = 0; y < 15; y++) {
        board[x][y] = new Button("X");
        board[x][y].setPrefSize(500/15f, 500/15f);
        board[x][y].setLayoutX(500/15f*x);
        board[x][y].setLayoutY(500/15f*y);
        final int tempx = x;
        final int tempy = y;
        board[x][y].setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent e) {
            System.out.println(game.check(tempy, tempx));
          }
        });
        root.getChildren().add(board[x][y]);
      }
    }
    primaryStage.setWidth(517);
    primaryStage.setHeight(540);
    primaryStage.setScene(new Scene(root));
  }
  /**
   * [main description].
   * @param args [description].
   */
  public static void main(String[] args) {
      launch(args);
  }
}
