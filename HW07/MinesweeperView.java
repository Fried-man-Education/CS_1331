import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.geometry.HPos;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class MinesweeperView extends Application {
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
        startB.setOnAction(e -> {
            if (name.getText().length() == 0 || combo.getValue() == null) {
                fail();
            } else {
                Difficulty mode;
                switch (combo.getValue()) {
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
                game(primaryStage, mode, name.getText());
            }
        });
        startB.setLayoutX(160); // 225 is middle
        startB.setLayoutY(300);
        root.getChildren().add(startB);

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    /**
     * [fail description].
     */
    public void fail() {
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

    /**
     * [game description].
     * @param primaryStage   [description].
     * @param gameDifficulty [description].
     * @param name           [description].
     */
    public void game(Stage primaryStage, Difficulty gameDifficulty, String name) {
        MinesweeperGame game = new MinesweeperGame(gameDifficulty);
        GridPane grid = new GridPane();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Button button = new Button();
                button.setAlignment(Pos.CENTER);
                button.setMinWidth(30);
                button.setMinHeight(30);
                grid.add(button, i, j);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        Tile[] revealed = game.check(grid.getRowIndex(button), grid.getColumnIndex(button));
                        if (revealed == null) {
                            return;
                        } else if (revealed.length == 1 && revealed[0].isMine()) {
                            LostLoadHandler temp = new LostLoadHandler();
                            temp.handle(primaryStage, name);
                        } else {
                            for (Tile tile: revealed) {
                                Label tileLabel = new Label(String.format("%d", tile.getBorderingMines()));
                                grid.add(tileLabel, tile.getX(), tile.getY());
                                grid.setHalignment(tileLabel, HPos.CENTER);
                                if (game.isWon()) {
                                    WonLoadHandler temp = new WonLoadHandler();
                                    temp.handle(primaryStage, name);
                                }
                            }
                        }
                    }
                });
            }
        }
        Scene newScene = new Scene(grid, 800, 800);
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
    /**
     * [main description].
     * @param args [description].
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     */
    public class LostLoadHandler {
        void handle(Stage primaryStage, String name) {
            Pane root = new Pane();

            Text titleText = new Text("You Lost, " + name);
            titleText.setFont(Font.font("Arial", 20));
            titleText.setLayoutX(0);
            titleText.setLayoutY(20);
            root.getChildren().add(titleText);

            Button startB = new Button("New Game");
            startB.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    start(primaryStage);
                }
            });
            startB.setLayoutX(0);
            startB.setLayoutY(40);
            root.getChildren().add(startB);

            primaryStage.setScene(new Scene(root, 500, 200));
        }
    }

    /**
     *
     */
    public class WonLoadHandler {
        void handle(Stage primaryStage, String name) {
            Pane root = new Pane();

            Text titleText = new Text("Congratulations, " + name);
            titleText.setFont(Font.font("Arial", 20));
            titleText.setLayoutX(0);
            titleText.setLayoutY(20);
            root.getChildren().add(titleText);

            Button startB = new Button("New Game");
            startB.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    start(primaryStage);
                }
            });
            startB.setLayoutX(0);
            startB.setLayoutY(40);
            root.getChildren().add(startB);

            primaryStage.setScene(new Scene(root));
        }
    }
}
