/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.ShoppingCartController;
import model.ShoppingCart;
import view.ShoppingCartUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author brunomnsilva
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        ShoppingCart model = new ShoppingCart("Bruno");
        ShoppingCartUI view = new ShoppingCartUI(model);
        ShoppingCartController controller = new ShoppingCartController(view, model);

        //podemos na mesma janela compor varias "visualizacoes"
        //se necessario
        BorderPane window = new BorderPane();
        window.setCenter(view);

        Scene scene = new Scene(window, 350, 300);

        primaryStage.setTitle("Shopping Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
