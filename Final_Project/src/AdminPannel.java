import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminPannel  extends Application {

    Stage adminStage;
    Scene adminScene;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        adminStage = primaryStage;

        Label p_name = new Label("Product Name");
        TextField p_text = new TextField();

        Label p_price = new Label("Product Price");
        TextField price_text = new TextField();

        Button add_btn = new Button("Add");
        Button update_btn = new Button("Update");
        Button dlt_btn = new Button("Delete");

        TableView menu_items = new TableView<>();

        // Separator sep =new Separator(Orientation.VERTICAL);
        // sep.minHeight(600);
        Separator sep2 =new Separator(Orientation.VERTICAL);
        sep2.setMinHeight(600);

        AnchorPane left_pane = new AnchorPane();
        AnchorPane right_pane = new AnchorPane(left_pane,p_name,p_text,p_price,price_text,add_btn,dlt_btn,sep2,update_btn,menu_items);

        AnchorPane.setLeftAnchor(left_pane, 0.0);
        AnchorPane.setRightAnchor(left_pane, 600.0);
        AnchorPane.setBottomAnchor(left_pane, 0.0);
        AnchorPane.setTopAnchor(left_pane, 0.0);
        
        // AnchorPane.setLeftAnchor(sep, 201.0);
        // AnchorPane.setRightAnchor(sep, 600.0);
        // AnchorPane.setBottomAnchor(sep, 0.0);
        // AnchorPane.setTopAnchor(sep, 0.0);

        AnchorPane.setLeftAnchor(sep2, 501.0);
        AnchorPane.setRightAnchor(sep2, 300.0);
        AnchorPane.setBottomAnchor(sep2, 0.0);
        AnchorPane.setTopAnchor(sep2, 0.0);

        AnchorPane.setLeftAnchor(menu_items, 200.0);
        AnchorPane.setRightAnchor(menu_items, 300.0);
        AnchorPane.setBottomAnchor(menu_items, 0.0);
        AnchorPane.setTopAnchor(menu_items, 100.0);

        AnchorPane.setLeftAnchor(p_name, 540.0);
        AnchorPane.setTopAnchor(p_name, 100.0);

        AnchorPane.setLeftAnchor(p_text, 540.0);
        AnchorPane.setRightAnchor(p_text, 80.0);
        // AnchorPane.setBottomAnchor(p_text, 0.0);
        AnchorPane.setTopAnchor(p_text, 120.0);

        AnchorPane.setLeftAnchor(p_price, 540.0);
        AnchorPane.setTopAnchor(p_price, 160.0);

        AnchorPane.setLeftAnchor(price_text, 540.0);
        AnchorPane.setRightAnchor(price_text, 80.0);
        // AnchorPane.setBottomAnchor(menu_items, 0.0);
        AnchorPane.setTopAnchor(price_text, 180.0);

        AnchorPane.setLeftAnchor(add_btn, 540.0);
        AnchorPane.setRightAnchor(add_btn, 80.0);
        AnchorPane.setBottomAnchor(add_btn, 300.0);
        AnchorPane.setTopAnchor(add_btn, 250.0);

        AnchorPane.setLeftAnchor(update_btn, 540.0);
        AnchorPane.setRightAnchor(update_btn, 180.0);
        AnchorPane.setBottomAnchor(update_btn, 230.0);
        AnchorPane.setTopAnchor(update_btn, 320.0);

        AnchorPane.setLeftAnchor(dlt_btn, 640.0);
        AnchorPane.setRightAnchor(dlt_btn, 80.0);
        AnchorPane.setBottomAnchor(dlt_btn, 230.0);
        AnchorPane.setTopAnchor(dlt_btn, 320.0);




        adminScene = new Scene(right_pane,800,600);
        adminStage.setScene(adminScene);
        adminStage.show();
        
    }
    
}
