
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import javafx.scene.text.TextAlignment;
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

        final Scene scene1 = new Scene(root1, 500, 550);
        final Scene scene2 = new Scene(root2, 500, 550);
        final Scene scene3 = new Scene(root3, 500, 550);
       
        
        Label GameTitle = new Label("3072");
        GameTitle.setFont(new Font("Arial", 40));
        GameTitle.setLayoutX(200);
        GameTitle.setLayoutY(20);
        
        Label SubTitle = new Label("THE GAME");
        SubTitle.setFont(new Font("Arial", 30));
        SubTitle.setLayoutX(170);
        SubTitle.setLayoutY(80);

        
        Button NewGame = new Button();
        NewGame.setLayoutX(200);
        NewGame.setLayoutY(180);
        NewGame.setText("NEW GAME");
        NewGame.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	
                primaryStage.setScene(scene2);
            }
        });
        
        Button Help = new Button();
        Help.setLayoutX(210);
        Help.setLayoutY(220);
        Help.setText("HELP");
        Help.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene3);
            }
        });
        
        root1.getChildren().addAll(NewGame,Help,GameTitle,SubTitle);
		
        
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
                grid.requestFocus();
            }
        });
        scene2.addEventHandler(KeyEvent.KEY_PRESSED, Engine.keyEventHandler);
        root2.getChildren().addAll(Back2,Start,grid);
        
        if (Engine.keyEventHandler != null) {
        	EmptyGrid(grid,Engine.map);
        	fillGrid(grid, Engine.map);
        }
        
        Button Back3 = new Button();
        Back3.setLayoutX(100);
        Back3.setLayoutY(420);
        Back3.setText("Back");
        Back3.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                primaryStage.setScene(scene1);
            }
        });
        
        Label HelpTitle = new Label ("Help Instructions \n\n");
        HelpTitle.setFont(new Font("Arial", 30));
        HelpTitle.setLayoutX(100);
        HelpTitle.setLayoutY(20);
        
        Label HelpText = new Label (
        		" \n1. The game field is made of 4x4 tiles. Each tile has values 3,6,12 ..."
        		+ " \n2. Each game begins with placing tile with value '3' at random place"
        		+ " \n3. Using the arrow keys as controls you move the tiles. When two tiles with the same number touch, they merge into one!"
        		+ " \n4. Join the numbers and get to the 1536, 3072, 6144, ... tile!");
        
        HelpText.setMaxWidth(300);
        HelpText.setWrapText(true);
        HelpText.setLayoutX(100);
        HelpText.setLayoutY(150);
        
        root3.getChildren().addAll(HelpText,Back3,HelpTitle);
        
        primaryStage.setScene(scene1);
        primaryStage.show();
	}

	// empty the grid;
	private static void EmptyGrid(GridPane pane,short[][] map) {
		short current = 0;
		for (int row = 0; row < map.length;row++)
		{
			for (int col = 0; col < map[row].length; col++) {
				current = map[row][col];
				if (current != 0) {
					pane.add(new Label(String.valueOf(0)), row, col);
				}
			}
		}
	}

	// fill grid and initial fill
	
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

