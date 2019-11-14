package sample.controller;

import javafx.beans.binding.StringBinding;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagementCobtroller {
    @FXML
    Label label;
    @FXML
    Label label2;
    StringBinding binding = new StringBinding() {
        {
            bind();
        }

        @Override
        protected String computeValue() {
            return null;
        }
    };

    public void initialize() {
        Locale locale = new Locale("fa", "IR");
        Locale.setDefault(locale);
        if(Locale.getDefault().equals(locale)){
//            label.setText();
        }
        label.setOnMouseClicked(event -> {
            label2.setText("amico");
        });
    }
}
