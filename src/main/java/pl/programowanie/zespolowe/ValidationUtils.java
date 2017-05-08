/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.programowanie.zespolowe;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ValidationUtils {

    private static final String EMPTY_TEXT_FIELD = "Pole jest wymagane";
    private static final String EMPTY = "";

    public static boolean validateEmptyTextField(TextField field, Label validationLabel) {
        if (field.getText().trim().equals("")) {
            validationLabel.setText(EMPTY_TEXT_FIELD);
            return false;
        } else {
            validationLabel.setText(EMPTY);
            return true;
        }
    }
}
