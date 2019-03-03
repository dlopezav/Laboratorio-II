package Almacen;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

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
        for(Label label:labelTitle){
            label.setFont(new Font(20));
            
        }

        GridPane[] gridPanes = new GridPane[3];

        for (int i = 0; i < 3; i++) {
            gridPanes[i] = new GridPane();
            gridPanes[i].setAlignment(Pos.CENTER);
            gridPanes[i].setPadding(new Insets(10, 10, 10, 10));
            gridPanes[i].setHgap(5);
            gridPanes[i].setVgap(5);
            gridPanes[i].add(labelTitle[i], 0, 0);
        }

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
