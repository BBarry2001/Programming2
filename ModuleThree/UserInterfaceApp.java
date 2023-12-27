package ModuleThree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Random;

public class UserInterfaceApp extends Application {
    private TextArea textArea;
    private Color initialGreenHue;

    @Override
    public void start(Stage primaryStage) {
        // Initialize the main components
        VBox root = new VBox();
        MenuBar menuBar = new MenuBar();
        textArea = new TextArea();

        // Setup Menu
        setupMenu(menuBar);

        // Layout
        root.getChildren().addAll(menuBar, textArea);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("JavaFX Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupMenu(MenuBar menuBar) {
        // Create menus
        Menu menu = new Menu("Options");
        MenuItem dateItem = new MenuItem("Show Date/Time");
        MenuItem saveItem = new MenuItem("Save Text");
        MenuItem colorItem = new MenuItem("Random Green Hue");
        MenuItem exitItem = new MenuItem("Exit");

        // Set actions for menu items
        dateItem.setOnAction(e -> showDateTime());
        saveItem.setOnAction(e -> saveText());
        colorItem.setOnAction(e -> changeBackgroundColor(colorItem));
        exitItem.setOnAction(e -> System.exit(0));

        // Add menu items to menu
        menu.getItems().addAll(dateItem, saveItem, colorItem, exitItem);
        menuBar.getMenus().add(menu);

        // Initialize random green hue
        initialGreenHue = getRandomGreenHue();
        colorItem.setText("Random Green Hue: " + colorToHex(initialGreenHue));
    }

    private void showDateTime() {
        textArea.setText(LocalDateTime.now().toString());
    }

    private void saveText() {
        try (PrintWriter out = new PrintWriter("log.txt")) {
            out.println(textArea.getText());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void changeBackgroundColor(MenuItem colorItem) {
        textArea.setBackground(new Background(new BackgroundFill(initialGreenHue, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private Color getRandomGreenHue() {
        Random random = new Random();
        return Color.hsb(random.nextDouble() * 120, 1, 1);
    }

    private String colorToHex(Color color) {
        return String.format("#%02X%02X%02X", 
            (int) (color.getRed() * 255), 
            (int) (color.getGreen() * 255), 
            (int) (color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

