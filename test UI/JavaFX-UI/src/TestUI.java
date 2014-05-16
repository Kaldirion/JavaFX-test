
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TestUI extends Application {
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("3072");
		
		final GridPane grid = new GridPane();
		
        Group root1 = new Group();
        Group root2 = new Group();
        Group root3 = new Group();

        final Scene scene1 = new Scene(root1, 300, 250);
        final Scene scene2 = new Scene(root2, 300, 250);
        final Scene scene3 = new Scene(root3, 300, 250);
        
        Label GameTitle = new Label("3072");
        GameTitle.setFont(new Font("Arial", 30));
        GameTitle.setLayoutX(100);
        GameTitle.setLayoutY(20);
        
        Button NewGame = new Button();
        NewGame.setLayoutX(100);
        NewGame.setLayoutY(80);
        NewGame.setText("NEW GAME");
        NewGame.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	
                primaryStage.setScene(scene2);
            }
        });
        
        Button Help = new Button();
        Help.setLayoutX(110);
        Help.setLayoutY(120);
        Help.setText("HELP");
        Help.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene3);
            }
        });
        
        root1.getChildren().addAll(NewGame,Help,GameTitle);
		
        
        Button Back2 = new Button();
        Back2.setLayoutX(100);
        Back2.setLayoutY(20);
        Back2.setText("Back");
        Back2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                primaryStage.setScene(scene1);
            }
        });
        
        
        grid.setLayoutX(50);
        grid.setLayoutY(50);
        grid.setStyle("-fx-border: 2px solid; -fx-border-color: red; -fx-background-color: cornsilk; -fx-alignment: center;");
        
        
        Button Start = new Button();
        Start.setLayoutX(200);
        Start.setLayoutY(20);
        Start.setText("Start");
        Start.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	Engine.GetRandomPosition();
                fillGrid(grid, Engine.map);
            }
        });
        
        root2.getChildren().addAll(Back2,Start,grid);
        
        Button Back3 = new Button();
        Back3.setLayoutX(100);
        Back3.setLayoutY(20);
        Back3.setText("Back");
        Back3.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                primaryStage.setScene(scene1);
            }
        });
        root3.getChildren().addAll(new Label("Help Instructions"),Back3);
        
        primaryStage.setScene(scene1);
        primaryStage.show();
	}


	private static void fillGrid(GridPane pane, short[][] map) {
		short current = 0;
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				current = map[row][col];
				if (current != 0) {
					pane.add(new Label(String.valueOf(current)), row, col);
				}
			}
		}
	}
}

