#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import javafx.event.EventDispatchChain;
import javafx.scene.layout.Pane;

public class ResourceBundleConstants {
    private static final String SEP = ".";

    private static final String NAME = "NAME";
    private static final String NEW = "NEW";
    private static final String OPEN = "OPEN";
    private static final String SAVE = "SAVE";
    private static final String SAVEAS = "SAVEAS";
    private static final String PRINT = "PRINT";
    private static final String EXIT = "EXIT";
    private static final String UNDO = "UNDO";
    private static final String REDO = "REDO";
    private static final String CUT = "CUT";
    private static final String COPY = "COPY";
    private static final String PASTE = "PASTE";
    private static final String DELETE = "DELETE";
    private static final String HELP = "HELP";
    private static final String KEYMAP = "KEYMAP";
    private static final String ABOUT = "ABOUT";

    private static final String OK = "OK";
    private static final String CANCEL = "CANCEL";
    private static final String APPLY = "APPLY";
    private static final String REVERT = "REVERT";
    private static final String NEXT = "NEXT";
    private static final String PREVIOUS = "PREVIOUS";
    private static final String FIND = "FIND";
    private static final String SEARCH = "SEARCH";
    private static final String REPLACE = "REPLACE";
    private static final String CLOSE = "CLOSE";
    private static final String BACK = "BACK";
    private static final String IMPORT = "IMPORT";
    private static final String EXPORT = "EXPORT";
    private static final String SETTINGS = "SETTINGS";

    private static final String APP = "APP";
    public static final String APP_NAME = APP + SEP + NAME;

    private static final String MENU = "MENU";
    public static final String MENU_FILEMENU = MENU + SEP + "FILEMENU";
    public static final String MENU_FILEMENU_NEW = MENU_FILEMENU + SEP + NEW;
    public static final String MENU_FILEMENU_OPEN = MENU_FILEMENU + SEP + OPEN;
    public static final String MENU_FILEMENU_SAVE = MENU_FILEMENU + SEP + SAVE;
    public static final String MENU_FILEMENU_SAVEAS = MENU_FILEMENU + SEP + SAVEAS;
    public static final String MENU_FILEMENU_PRINT = MENU_FILEMENU + SEP + PRINT;
    public static final String MENU_FILEMENU_EXIT = MENU_FILEMENU + SEP + EXIT;
    public static final String MENU_FILEMENU_IMPORT = MENU_FILEMENU + SEP + IMPORT;
    public static final String MENU_FILEMENU_EXPORT = MENU_FILEMENU + SEP + EXPORT;

    public static final String MENU_EDITMENU = MENU + SEP + "EDIT";
    public static final String MENU_EDITMENU_UNDO = MENU_EDITMENU + SEP + UNDO;
    public static final String MENU_EDITMENU_REDO = MENU_EDITMENU + SEP + REDO;
    public static final String MENU_EDITMENU_CUT = MENU_EDITMENU + SEP + CUT;
    public static final String MENU_EDITMENU_COPY = MENU_EDITMENU + SEP + COPY;
    public static final String MENU_EDITMENU_PASTE = MENU_EDITMENU + SEP + PASTE;
    public static final String MENU_EDITMENU_DELETE = MENU_EDITMENU + SEP + DELETE;
    public static final String MENU_EDITMENU_SETTINGS = MENU_EDITMENU + SEP + SETTINGS;

    public static final String MENU_HELPMENU = MENU + SEP + "HELP";
    public static final String MENU_HELPMENU_HELP = MENU_HELPMENU + SEP + "HELP";
    public static final String MENU_HELPMENU_KEYMAP = MENU_HELPMENU + SEP + KEYMAP;
    public static final String MENU_HELPMENU_ABOUT = MENU_HELPMENU + SEP + ABOUT;
}
