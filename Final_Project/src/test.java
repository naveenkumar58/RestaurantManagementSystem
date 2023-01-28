import java.io.BufferedReader;
import java.io.FileReader;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class test extends Application {
    String productsFile = "products.txt";
    Filing product;
    Products ProductObj;

    private TableView<Products> table = new TableView<Products>();
    private final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com"));
    private final ObservableList<Products> oListStavaka = FXCollections.observableArrayList(
            new Products("Jacob", "Smith"),
            new Products("Isabella", "Johnson"),
            new Products("Ethan", "Williams"),
            new Products("Emma", "Jones"),
            new Products("Michael", "Brown"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // ProductObj = new Products();
        product = new Filing();
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn productNameCol = new TableColumn("Product Name");
        productNameCol.setMinWidth(100);
        productNameCol.setCellValueFactory(
                new PropertyValueFactory<Products, String>("productName"));

        TableColumn productPriceCol = new TableColumn("Product Price");
        productPriceCol.setMinWidth(100);
        productPriceCol.setCellValueFactory(
                new PropertyValueFactory<Products, String>("productPrice"));

        TableColumn qty = new TableColumn("Action");
        qty.setMinWidth(100);
        qty.setCellValueFactory(
                new PropertyValueFactory<>("DUMMY"));

        // TableColumn emailCol = new TableColumn("Email");
        // emailCol.setMinWidth(200);
        // emailCol.setCellValueFactory(
        // new PropertyValueFactory<Person, String>("email"));

        // try {
        // BufferedReader reader;
        // reader = new BufferedReader(new FileReader(productsFile));
        // String line;
        // while ((line = reader.readLine()) != null) {
        // String[] parts = line.split(" ");
        // System.out.println("Love "+parts[0]);
        // oListStavaka.add(new Products(parts[0], parts[1]));
        // }

        // reader.close();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        Callback<TableColumn<Products, String>, TableCell<Products, String>> cellFactory = //
                new Callback<TableColumn<Products, String>, TableCell<Products, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Products, String> param) {
                        final TableCell<Products, String> cell = new TableCell<Products, String>() {

                            final Button btn = new Button("+");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        Products products = getTableView().getItems().get(getIndex());
                                        System.out.println(products.getProductName()
                                                + "   " + products.getProductPrice());
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
            
        qty.setCellFactory(cellFactory);       
        table.setItems(oListStavaka);
        table.getColumns().addAll(productNameCol, productPriceCol,qty);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Person {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;

        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }
    }
}