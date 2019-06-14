#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.control;

import static ${package}.util.ResourceBundleConstants.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import ${package}.App;

import java.net.URL;
import java.util.ResourceBundle;

public class AbstractAppController implements Initializable {
    @FXML
    private Menu fileMenu;
    @FXML
    private MenuItem newMenuItem;
    @FXML
    private MenuItem openMenuItem;
    @FXML
    private MenuItem saveMenuItem;
    @FXML
    private MenuItem saveasMenuItem;
    @FXML
    private MenuItem printMenuItem;
    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private Menu editMenu;
    @FXML
    private MenuItem undoMenuItem;
    @FXML
    private MenuItem redoMenuItem;
    @FXML
    private MenuItem cutMenuItem;
    @FXML
    private MenuItem copyMenuItem;
    @FXML
    private MenuItem pasteMenuItem;
    @FXML
    private MenuItem deleteMenuItem;
    @FXML
    private MenuItem settingsMenuItem;

    @FXML
    private Menu helpMenu;
    @FXML
    private MenuItem helpMenuItem;
    @FXML
    private MenuItem keymapMenuItem;
    @FXML
    private MenuItem aboutMenuItem;


    @FXML
    private Button newButton;
    @FXML
    private Button openButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button saveasButton;

    @FXML
    private Button printButton;

    @FXML
    private Button cutButton;
    @FXML
    private Button copyButton;
    @FXML
    private Button pasteButton;
    @FXML
    private Button deleteButton;

    @FXML
    private Button undoButton;
    @FXML
    private Button redoButton;


    ResourceBundle bundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bundle = resources;

        App.getSettings().localeProperty().addListener((ob, oldValue, newValue) -> {
            fileMenu.setText(bundle.getString(MENU_FILEMENU));
            newMenuItem.setText(bundle.getString(MENU_FILEMENU_NEW));
            openMenuItem.setText(bundle.getString(MENU_FILEMENU_OPEN));
            saveMenuItem.setText(bundle.getString(MENU_FILEMENU_SAVE));
            saveasMenuItem.setText(bundle.getString(MENU_FILEMENU_SAVEAS));
            printMenuItem.setText(bundle.getString(MENU_FILEMENU_PRINT));
            exitMenuItem.setText(bundle.getString(MENU_FILEMENU_EXIT));

            editMenu.setText(bundle.getString(MENU_EDITMENU));
            undoMenuItem.setText(bundle.getString(MENU_EDITMENU_UNDO));
            redoMenuItem.setText(bundle.getString(MENU_EDITMENU_REDO));
            cutMenuItem.setText(bundle.getString(MENU_EDITMENU_CUT));
            copyMenuItem.setText(bundle.getString(MENU_EDITMENU_COPY));
            pasteMenuItem.setText(bundle.getString(MENU_EDITMENU_PASTE));
            deleteMenuItem.setText(bundle.getString(MENU_EDITMENU_DELETE));
            settingsMenuItem.setText(bundle.getString(MENU_EDITMENU_SETTINGS));

            helpMenu.setText(bundle.getString(MENU_HELPMENU));
            helpMenuItem.setText(bundle.getString(MENU_HELPMENU_HELP));
            keymapMenuItem.setText(bundle.getString(MENU_HELPMENU_KEYMAP));
            aboutMenuItem.setText(bundle.getString(MENU_HELPMENU_ABOUT));


            newButton.getTooltip().setText(bundle.getString(MENU_FILEMENU_NEW));
            openButton.getTooltip().setText(bundle.getString(MENU_FILEMENU_OPEN));
            saveButton.getTooltip().setText(bundle.getString(MENU_FILEMENU_SAVE));
            saveasButton.getTooltip().setText(bundle.getString(MENU_FILEMENU_SAVEAS));

            printButton.getTooltip().setText(bundle.getString(MENU_FILEMENU_PRINT));

            cutButton.getTooltip().setText(bundle.getString(MENU_EDITMENU_CUT));
            copyButton.getTooltip().setText(bundle.getString(MENU_EDITMENU_COPY));
            pasteButton.getTooltip().setText(bundle.getString(MENU_EDITMENU_PASTE));
            deleteButton.getTooltip().setText(bundle.getString(MENU_EDITMENU_DELETE));

            undoButton.getTooltip().setText(bundle.getString(MENU_EDITMENU_UNDO));
            redoButton.getTooltip().setText(bundle.getString(MENU_EDITMENU_REDO));
        });
    }
}
