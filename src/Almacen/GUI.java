package Almacen;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Application implements Runnable {

    public static String[] args;
    public static Bodega compania;

    public GUI(String[] args, Bodega compania) {
        GUI.args = args;
        GUI.compania = compania;
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

        for (int i = 0; i < gridPanes.length; i++) {
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
        precioProducto.setText("0.0");
        gridPanes[0].add(precioProducto, 1, 2, 1, 1);
        Label labelEstante = new Label("Estante: ");
        gridPanes[0].add(labelEstante, 0, 5, 1, 1);
        GridPane.setHalignment(labelEstante, HPos.CENTER);
        Label labelCaja = new Label("Caja: ");
        gridPanes[0].add(labelCaja, 1, 5, 1, 1);
        GridPane.setHalignment(labelCaja, HPos.CENTER);

        List<Integer> valuesSpinner = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            valuesSpinner.add(i);
        }

        Spinner<Integer> seleccionEstantes = new Spinner<>();
        List<Integer> valuesSpinner1 = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            valuesSpinner1.add(i);
        }
        SpinnerValueFactory<Integer> sv = new SpinnerValueFactory<Integer>() {
            @Override
            public void decrement(int steps) {
                Integer current = this.getValue();
                int dx = valuesSpinner.indexOf(current);
                int newidx = (valuesSpinner.size() + dx - steps) % valuesSpinner.size();
                Integer newInt = valuesSpinner.get(newidx);
                this.setValue(newInt);
                valuesSpinner1.clear();
                for (int i = 0; i < 3; i++) {
                    if (!GUI.compania.getEstantes()[seleccionEstantes.getValue() - 1].getCajas()[i].isLleno()) {
                        valuesSpinner1.add(i + 1);
                    }
                }
            }

            @Override
            public void increment(int steps) {
                Integer current = this.getValue();
                int dx = valuesSpinner.indexOf(current);
                int newidx = (dx + steps) % valuesSpinner.size();
                Integer newInt = valuesSpinner.get(newidx);
                this.setValue(newInt);
                valuesSpinner1.clear();
                for (int i = 0; i < 3; i++) {
                    if (!GUI.compania.getEstantes()[seleccionEstantes.getValue() - 1].getCajas()[i].isLleno()) {
                        valuesSpinner1.add(i + 1);
                    }
                }
            }
        };
        sv.setValue(1);
        seleccionEstantes.setValueFactory(sv);

        gridPanes[0].add(seleccionEstantes, 0, 6, 1, 1);
        GridPane.setHalignment(seleccionEstantes, HPos.CENTER);

        for (int i = 1; i <= 3; i++) {
            valuesSpinner1.add(i);
        }
        Spinner<Integer> seleccionCaja = new Spinner<>();
        SpinnerValueFactory<Integer> sv1 = new SpinnerValueFactory<Integer>() {
            @Override
            public void decrement(int steps) {
                Integer current = this.getValue();
                int dx = valuesSpinner1.indexOf(current);
                int newidx = (valuesSpinner1.size() + dx - steps) % valuesSpinner1.size();
                Integer newInt = valuesSpinner1.get(newidx);
                this.setValue(newInt);
            }

            @Override
            public void increment(int steps) {
                Integer current = this.getValue();
                int dx = valuesSpinner1.indexOf(current);
                int newidx = (dx + steps) % valuesSpinner1.size();
                Integer newInt = valuesSpinner1.get(newidx);
                this.setValue(newInt);
            }
        };
        sv1.setValue(1);
        seleccionCaja.setValueFactory(sv1);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Spinner<Integer> estantes = new Spinner();
        gridPanes[1].add(new Label("Producto:"), 0, 3);
        Spinner<String> productos = new Spinner();
        gridPanes[1].add(productos, 1, 3);
        List <String> valueSpinne3 = new ArrayList<>();
            for (int i = 1; i <= 7; i++) {
            valueSpinne3.add("-");
        }
            SpinnerValueFactory<String> s3 = new SpinnerValueFactory<String>() {
            @Override
            public void decrement(int steps) {
                String current = this.getValue();
                try{
                int dx = valueSpinne3.indexOf(current);
                int newidx = (valueSpinne3.size() + dx - steps) % valueSpinne3.size();
                String a = valueSpinne3.get(newidx);
                this.setValue(a);
                }catch(Exception e){
                    
                }
                
            }

            @Override
            public void increment(int steps) {
                String current = this.getValue();
                try{
                int dx = valueSpinne3.indexOf(current);
                int newidx = (dx + steps) % valueSpinne3.size();
                String newString = valueSpinne3.get(newidx);
                this.setValue(newString);
                }catch(Exception e){
                    
                }
            }
        };
        productos.setValueFactory(s3);
        
        gridPanes[1].add(new Label("Caja:"), 0, 2);
        Spinner cajas = new Spinner();
        gridPanes[1].add(cajas, 1, 2);
        List <Integer> valueSpinne1 = new ArrayList<>();
        List <Integer> valueSpinne2 = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            valueSpinne2.add(i);
        }
        SpinnerValueFactory<Integer> s2 = new SpinnerValueFactory<Integer>() {
            @Override
            public void decrement(int steps) {
                Integer current = this.getValue();
                try{
                int dx = valueSpinne2.indexOf(current);
                int newidx = (valueSpinne2.size() + dx - steps) % valueSpinne2.size();
                Integer newInt = valueSpinne2.get(newidx);
                this.setValue(newInt);
                valueSpinne3.clear();
                for (int i = 0; i < 7; i++) {
                if (GUI.compania.getEstantes()[estantes.getValue() - 1].getCajas()[(int)cajas.getValue()-1].getProductosGuardados()[i]!=null) {
                        valueSpinne3.add(GUI.compania.getEstantes()[estantes.getValue() - 1].getCajas()[(int)cajas.getValue()-1].getProductosGuardados()[i].getDescripcion());
                 
                }
            }
                s3.setValue(valueSpinne3.get(0));
                }catch(Exception e){
                    
                }
            }

            @Override
            public void increment(int steps) {
                Integer current = this.getValue();
                int dx = valueSpinne2.indexOf(current);
                try{
                int newidx = (dx + steps) % valueSpinne2.size();
                Integer newInt = valueSpinne2.get(newidx);
                this.setValue(newInt);
                valueSpinne3.clear();
                for (int i = 0; i < 7; i++) {
                if (GUI.compania.getEstantes()[estantes.getValue() - 1].getCajas()[(int)cajas.getValue()-1].getProductosGuardados()[i]!=null) {
                        valueSpinne3.add(GUI.compania.getEstantes()[estantes.getValue() - 1].getCajas()[(int)cajas.getValue()-1].getProductosGuardados()[i].getDescripcion());
                 
                }
            }
                s3.setValue(valueSpinne3.get(0));
                }catch(Exception e){
                    
                }
                
            }
        };
        cajas.setValueFactory(s2);
        
        
        gridPanes[1].add(new Label("Estante:"), 0, 1);
        
        gridPanes[1].add(estantes, 1, 1);
        
        
        for (int i = 1; i <= 20; i++) {
            valueSpinne1.add(i);
        }
        SpinnerValueFactory<Integer> s1 = new SpinnerValueFactory<Integer>() {
            @Override
            public void decrement(int steps) {
                Integer current = this.getValue();
                int dx = valueSpinne1.indexOf(current);
                try{
                int newidx = (valueSpinne1.size() + dx - steps) % valueSpinne1.size();
                Integer newInt = valueSpinne1.get(newidx);
                this.setValue(newInt);
                }catch(Exception e){
                    
                }
                valueSpinne2.clear();
                try{
                for (int i = 0; i < 3; i++) {
                    if (GUI.compania.getEstantes()[estantes.getValue() - 1].getCajas()[i].tieneProducto()) {
                        valueSpinne2.add(i + 1);
                    }
                }
                s2.setValue(valueSpinne2.get(0));
                }catch(Exception e){
                    
                }
            }

            @Override
            public void increment(int steps) {
                Integer current = this.getValue();
                int dx = valueSpinne1.indexOf(current);
                try{
                int newidx = (dx + steps) % valueSpinne1.size();
                Integer newInt = valueSpinne1.get(newidx);
                this.setValue(newInt);
                }catch(Exception e){
                    
                }
                valueSpinne2.clear();
                try{
                for (int i = 0; i < 3; i++) {
                    if (GUI.compania.getEstantes()[estantes.getValue() - 1].getCajas()[i].tieneProducto()) {
                        valueSpinne2.add(i + 1);
                    }
                }
                s2.setValue(valueSpinne2.get(0));
                }catch(Exception e){
                    
                }
            }
        };
        estantes.setValueFactory(s1);
        
        
        
        
        
      
        Button buttonPedido = new Button("Solicitar");
        gridPanes[1].add(buttonPedido, 0, 5);

        
      
        Label nombreCliente = new Label("Ingrese cliente:");
        TextField espacioNombre = new TextField();
        gridPanes[1].add(nombreCliente, 0, 4);
        gridPanes[1].add(espacioNombre, 1, 4);
        
        gridPanes[0].add(seleccionCaja, 1, 6, 1, 1);
        GridPane.setHalignment(seleccionCaja, HPos.CENTER);
        Button buttonAlmacenar = new Button("Almacenar");
        gridPanes[0].add(buttonAlmacenar, 0, 9, 2, 1);
        GridPane.setHalignment(buttonAlmacenar, HPos.CENTER);
        
        
        ////////BOTON ALMACENAR////////
        buttonAlmacenar.setOnAction(((event) -> {

            Producto producto = new Producto(nombreProducto.getText(), Double.parseDouble(precioProducto.getText()));
            compania.setProducto(producto, seleccionCaja.getValue(), seleccionEstantes.getValue());
            
            
            
            GUI.compania.getSistema().getRobots()[GUI.compania.getSistema().robotLibre()-1].setEstanteAsignado(GUI.compania.getEstantes()[seleccionEstantes.getValue()-1]);
            Thread thread = new Thread(GUI.compania.getRobotsOrganizadores()[GUI.compania.getSistema().robotLibre() - 1]);
            thread.start();
            valuesSpinner.clear();
            for (int i = 0; i < 20; i++) {
                if (!GUI.compania.getEstantes()[i].isLleno()) {
                    valuesSpinner.add(i + 1);
                }
            }
            sv.setValue(valuesSpinner.get(0));
            valuesSpinner1.clear();
            for (int i = 0; i < 3; i++) {
                if (!GUI.compania.getEstantes()[seleccionEstantes.getValue() - 1].getCajas()[i].isLleno()) {
                    valuesSpinner1.add(i + 1);
                }
            }
            valueSpinne1.clear();
            try{
            for (int i = 0; i < 20; i++) {
                if (GUI.compania.getEstantes()[i].tieneProducto()) {
                    valueSpinne1.add(i + 1);
                }
            }
            }catch(Exception e){
                
            }
            
            valueSpinne2.clear();
            try{
            for (int i = 0; i < 3; i++) {
                    if (GUI.compania.getEstantes()[estantes.getValue() - 1].getCajas()[i].tieneProducto()) {
                        valueSpinne2.add(i + 1);
                    }
                }
            }catch(Exception e){
                
            }
            valueSpinne3.clear();
            try{
            for (int i = 0; i < 7; i++) {
                if (GUI.compania.getEstantes()[estantes.getValue() - 1].getCajas()[(int)cajas.getValue()-1].getProductosGuardados()[i]!=null) {
                        valueSpinne3.add(GUI.compania.getEstantes()[estantes.getValue() - 1].getCajas()[(int)cajas.getValue()-1].getProductosGuardados()[i].getDescripcion());
                 
                }
            }
            }catch(Exception e){
                
            }
            sv.setValue(valuesSpinner.get(0));
            sv1.setValue(valuesSpinner1.get(0));
            try{
            s1.setValue(valueSpinne1.get(0));
            s2.setValue(valueSpinne2.get(0));
            s3.setValue(valueSpinne3.get(0));
            }catch(Exception e){
                
            }
            //Actualizar Spinner Estantes

        }));

        seleccionEstantes.valueProperty().addListener((ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) -> {

            //Actualizar Spinner Cajas
        });
        Label lProducto = new Label("Producto del Pedido: ");
        Label lTotal = new Label("Total Precio:");
        Label Cliente = new Label("Cliente:");
        TextField lNombreProducto = new TextField();
        TextField lNombreCliente = new TextField();
        lNombreCliente.setDisable(true);
        lNombreProducto.setDisable(true);
        TextField lTotalNumero = new TextField();
        lTotalNumero.setDisable(true);
        TextField lTotalFacturaNumero = new TextField();
        lTotalFacturaNumero.setDisable(true);
        gridPanes[2].add(lProducto, 0, 1);
        gridPanes[2].add(lTotal, 0, 2);
        gridPanes[2].add(lNombreProducto, 1, 1);
        gridPanes[2].add(lTotalNumero, 1, 2);
        gridPanes[2].add(Cliente, 0, 3);
         gridPanes[2].add(lNombreCliente, 1, 3);
        ///BOTON FACTURA////////////////////////////////////////////////////
        buttonPedido.setOnAction(((event) -> {
        lNombreProducto.setText(productos.getValue());
        lTotalNumero.setText(precioProducto.getText());
        lNombreCliente.setText(espacioNombre.getText());
            
            
        }));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        for (int i = 0; i < 3; i++) {
            tabs[i].setContent(gridPanes[i]);
        }
        Scene scene = new Scene(tabPane, 400, 350);

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

    @Override
    public void init() {

    }

    public GUI() {

    }

}

/*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });*/
