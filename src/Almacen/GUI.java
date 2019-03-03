package Almacen;

import com.sun.javafx.collections.ElementObservableListDecorator;
import javafx.application.Application;
import javafx.geometry.HPos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Application implements Runnable {

    private String[] args;

    public GUI(String[] args) {
        this.args = args;
    }

    @Override
    public void start(Stage primaryStage) {

        TabPane tabPane = new TabPane();
        Tab[] tabs = new Tab[3];
        tabs[0] = new Tab("Almacenar producto");
        tabs[1] = new Tab("Solicitar Pedido");
        tabs[2] = new Tab("Generar Factura");

        for (Tab tab : tabs) {
            tab.setClosable(false);
            tabPane.getTabs().add(tab);
        }

        Label[] labelTitle = new Label[3];
        labelTitle[0] = new Label("Almacenar Producto.");
        labelTitle[1] = new Label("Solicitar Pedido.");
        labelTitle[2] = new Label("Generar Factura.");
        for (Label label : labelTitle) {
            label.setFont(new Font(20));

        }

        GridPane[] gridPanes = new GridPane[3];

        for (int i = 0; i < 3; i++) {
            gridPanes[i] = new GridPane();
            gridPanes[i].setAlignment(Pos.TOP_CENTER);
            gridPanes[i].setPadding(new Insets(50, 50, 50, 50));
            gridPanes[i].setHgap(10);
            gridPanes[i].setVgap(10);
            gridPanes[i].add(labelTitle[i], 0, 0, 2, 1);
            GridPane.setHalignment(labelTitle[i], HPos.CENTER);
        }

        gridPanes[0].add(new Label("Nombre Producto"), 0, 1, 1, 1);
        TextField nombreProducto = new TextField("");
        gridPanes[0].add(nombreProducto, 1, 1, 1, 1);
        gridPanes[0].add(new Label("Precio"), 0, 2, 1, 1);
        TextField precioProducto = new TextField("");
        gridPanes[0].add(precioProducto, 1, 2, 1, 1);
        Label labelEstante = new Label("Estante: ");
        gridPanes[0].add(labelEstante, 0, 5, 1, 1);
        GridPane.setHalignment(labelEstante, HPos.CENTER);
        Label labelCaja = new Label("Caja: ");
        gridPanes[0].add(labelCaja, 1, 5, 1, 1);
        GridPane.setHalignment(labelCaja, HPos.CENTER);
        Spinner seleccionEstantes = new Spinner();

        gridPanes[0].add(seleccionEstantes, 0, 6, 1, 1);
        GridPane.setHalignment(seleccionEstantes, HPos.CENTER);
        SpinnerValueFactory<Integer> sv = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 7, 1);
        SpinnerValueFactory<String> sv1 = new SpinnerValueFactory<String>() {
            @Override
            public void decrement(int steps) {
                System.out.println("Bajando");
            }

            @Override
            public void increment(int steps) {
                System.out.println("Subiendo");
            }
        };
        seleccionEstantes.setValueFactory(sv1);
        seleccionEstantes.setOnMouseClicked((event) -> {
            System.out.println("Prueba Spinner");
        });
        Spinner seleccionCaja = new Spinner();
        gridPanes[0].add(seleccionCaja, 1, 6, 1, 1);

        GridPane.setHalignment(seleccionCaja, HPos.CENTER);
        Button buttonAlmacenar = new Button("Almacenar");
        gridPanes[0].add(buttonAlmacenar, 0, 9, 2, 1);
        GridPane.setHalignment(buttonAlmacenar, HPos.CENTER);
        buttonAlmacenar.setOnAction(((event) -> {
            //codigo Almacenar
            System.out.println("Almacenar");
        }));

        for (int i = 0; i < 3; i++) {
            tabs[i].setContent(gridPanes[i]);
        }
        Scene scene = new Scene(tabPane, 350, 350);

        primaryStage.setTitle("Panel de Control");
        primaryStage.setScene(scene);
        primaryStage.setX(865);
        primaryStage.setY(20);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    @Override
    public void run() {
        Application.launch(args);
        System.exit(0);
    }

    public GUI() {

    }

}

/*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });*/
