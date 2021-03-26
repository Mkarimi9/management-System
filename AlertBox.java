package oop;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

           public class AlertBox {
               static String s ="";

        public static String display(String title, String message) {
            Stage window = new Stage();

            //Block events to other windows
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(250);

            Label label = new Label();
            label.setText(message);
            Button closeButton = new Button("yes");
            Button no = new Button("no");

            closeButton.setOnAction(e -> {
                s = "yes";
                window.close();
            });
            no.setOnAction(event -> {
                s = "no";
                window.close();

            });

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, closeButton,no);
            layout.setAlignment(Pos.CENTER);

            //Display window and wait for it to be closed before returning
            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();
            return s;
        }
               public static void display(String message) {
                   Stage window = new Stage();

                   //Block events to other windows
                   window.initModality(Modality.APPLICATION_MODAL);
                   window.setTitle("error");
                   window.setMinWidth(250);

                   Label label = new Label();
                   label.setText(message);
                   Button closeButton = new Button("ok");
                   closeButton.setOnAction(e -> window.close());

                   VBox layout = new VBox(10);
                   layout.getChildren().addAll(label, closeButton);
                   layout.setAlignment(Pos.CENTER);

                   //Display window and wait for it to be closed before returning
                   Scene scene = new Scene(layout);
                   window.setScene(scene);
                   window.showAndWait();
               }


           }



