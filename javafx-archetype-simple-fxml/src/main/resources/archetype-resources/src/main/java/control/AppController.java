#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.control;

import static ${package}.util.ResourceBundleConstants.*;

import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ${package}.App;
import ${package}.util.Settings;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class AppController extends AbstractAppController implements Initializable {

    private File file;

    private boolean saved = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
    }

    public File getFile() {
        return file;
    }

    public void handleNewFile() {
        // TODO: implement me
    }

    public void handleOpenFile() {

    }

    public void handleSaveFile() {
        if (file == null) {
            handleSaveas();
        } else {
            // TODO: save data
            save(file);
        }
    }

    public void handleSaveas() {
        FileChooser fc = new FileChooser();
        ObservableList<FileChooser.ExtensionFilter> filters = fc.getExtensionFilters();
        filters.clear();
        filters.add(new FileChooser.ExtensionFilter(bundle.getString(APP_NAME), App.APP_EXTENSION));
        File selectedFile = fc.showSaveDialog(App.getPrimaryStage());
        if (selectedFile != null) {
            save(selectedFile);
        }
    }

    public void handlePrint() {
        // TODO: implement me
    }

    public void handleExit() {
        if (!saved) {
            handleSaveFile();
        }
        Platform.exit();
    }


    public void handleUndo() {
        // TODO: implement me
    }

    public void handleRedo() {
        // TODO: implement me
    }

    public void handleCut() {
        // TODO: implement me
    }

    public void handleCopy() {
        // TODO: implement me
    }

    public void handlePaste() {
        // TODO: implement me
    }

    public void handleDelete() {
        // TODO: implement me
    }

    public void handleSettings() {
        // TODO: implement me
        Settings settings = App.getSettings();

    }

    public void handleHelp() {
        // TODO: implement me
    }

    public void handleKeymap() {
        // TODO: implement me
    }

    public void handleAbout() {
        // TODO: implement me
    }



    private boolean showSaveData() {
        if (!saved) {
//            String contentText = MessageFormat.format(bundle.getString(MSG_SAVE_CHANGES), file == null? "new" + App.APP_EXTENSION : file.getName());
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, contentText, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
//            alert.initOwner(App.getPrimaryStage());
//            alert.setTitle(bundle.getString(MSG_TITLE_SAVE_CHANGES));
//
//            alert.showAndWait();
//
//            if (alert.getResult() == ButtonType.OK) {
//                handleSaveFile();
//            } else if (alert.getResult() == ButtonType.CANCEL) {
//                return false;
//            } // nothing to save if user pressed no button, continue with action
        }
        return true;
    }


    private void save(File file) {
        // TODO: implement me
        // TODO: write data to file
        saved = true;
    }
}
