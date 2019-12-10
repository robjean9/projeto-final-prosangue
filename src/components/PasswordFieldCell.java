package components;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import vo.Usuario;

/**
 *
 * @author robson
 */
public class PasswordFieldCell extends TableCell<Usuario, String> {

    private PasswordField passwordField;

    public PasswordFieldCell() {
        passwordField = new PasswordField();
        passwordField.setEditable(true);
        this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        this.setGraphic(null);
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!isEmpty()) {
            passwordField.setText(item);
            setGraphic(passwordField);
        } else {
            setGraphic(null);
        }
    }

}
