#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import javafx.beans.property.*;
import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Settings {
    public static final String PROPERTIES_FILENAME = "App.properties";

    private static final String STYLE = "STYLE";

    private static final String LANGUAGE = "LANGUAGE";

    private static final String LAST_FILE = "LAST_FILE";

    private static final String X = "X";

    private static final String Y = "Y";

    private static final String HEIGHT = "HEIGHT";

    private static final String WIDTH = "WIDTH";

    private static final String MAXIMIZED = "MAXIMIZED";

    private static final String HIDE_TOOLBAR = "HIDE_TOOLBAR";


    private static final double DEFAULT_X = 0.0;

    private static final double DEFAULT_Y = 0.0;

    private static final double DEFAULT_HEIGHT = 500.0;

    private static final double DEFAULT_WIDTH = 600.0;

    public static final Pair[] STYLES = { new Pair<>("Default", "default"), new Pair<>("Dark", "dark") };

    public static final Locale[] LANGUAGES = { Locale.GERMAN, Locale.ENGLISH, new Locale("es"), Locale.FRENCH,
            Locale.ITALIAN };


    private ObjectProperty<Pair<String, String>> style;

    private ObjectProperty<Locale> locale;

    private StringProperty lastFile;

    private DoubleProperty x;

    private DoubleProperty y;

    private DoubleProperty height;

    private DoubleProperty width;

    private BooleanProperty maximized;

    private BooleanProperty hideToolBar;


    public Settings() {
        this.style = new SimpleObjectProperty<>(STYLES[0]);
        this.locale = new SimpleObjectProperty<>(getDefaultLocale());
        this.lastFile = new SimpleStringProperty("");
        this.x = new SimpleDoubleProperty(DEFAULT_X);
        this.y = new SimpleDoubleProperty(DEFAULT_Y);
        this.height = new SimpleDoubleProperty(DEFAULT_HEIGHT);
        this.width = new SimpleDoubleProperty(DEFAULT_WIDTH);
        this.maximized = new SimpleBooleanProperty(false);
        this.hideToolBar = new SimpleBooleanProperty(false);
    }

    public Pair<String, String> getStyle() {
        return style.get();
    }

    public void setStyle(Pair<String, String> style) {
        this.style.set(style);
    }

    public ObjectProperty<Pair<String, String>> styleProperty() {
        return style;
    }

    public Locale getLocale() {
        return locale.get();
    }

    public void setLocale(Locale locale) {
        this.locale.set(locale);
    }

    public ObjectProperty<Locale> localeProperty() {
        return locale;
    }

    public String getLastFile() {
        return lastFile.get();
    }

    public StringProperty lastFileProperty() {
        return lastFile;
    }

    public void setLastFile(String lastFile) {
        this.lastFile.set(lastFile);
    }

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public double getHeight() {
        return height.get();
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public double getWidth() {
        return width.get();
    }

    public DoubleProperty widthProperty() {
        return width;
    }

    public void setWidth(double width) {
        this.width.set(width);
    }

    public boolean isMaximized() {
        return maximized.get();
    }

    public BooleanProperty maximizedProperty() {
        return maximized;
    }

    public void setMaximized(boolean maximized) {
        this.maximized.set(maximized);
    }

    public boolean isHideToolBar() {
        return hideToolBar.get();
    }

    public BooleanProperty hideToolBarProperty() {
        return hideToolBar;
    }

    public void setHideToolBar(boolean hideToolBar) {
        this.hideToolBar.set(hideToolBar);
    }


    public void store() throws IOException {
        Properties props = new Properties();
        props.setProperty(LANGUAGE, getLocale().getLanguage());
        props.setProperty(STYLE, getStyle().getKey());
        props.setProperty(LAST_FILE, getLastFile());
        props.setProperty(X, "" + getX());
        props.setProperty(Y, "" + getY());
        props.setProperty(HEIGHT, "" + getHeight());
        props.setProperty(WIDTH, "" + getWidth());
        props.setProperty(MAXIMIZED, "" + isMaximized());
        props.setProperty(HIDE_TOOLBAR, "" + isHideToolBar());

        FileOutputStream fos = new FileOutputStream(PROPERTIES_FILENAME);
        props.store(fos, "");
        fos.close();
    }

    public void load() throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(PROPERTIES_FILENAME);
        props.load(fis);
        fis.close();

        String style = props.getProperty(STYLE, (String)STYLES[0].getKey());
        List<Pair> styleList = Arrays.stream(STYLES).filter(e -> e.getKey().equals(style)).collect(Collectors.toList());
        if (!styleList.isEmpty()) {
            setStyle(styleList.get(0));
        }

        Locale defaultLocale = getDefaultLocale();
        String language = props.getProperty(LANGUAGE, defaultLocale.getLanguage());
        List<Locale> list = Arrays.stream(LANGUAGES).filter(e -> e.getLanguage().equals(language)).collect(Collectors.toList());
        if (!list.isEmpty()) {
            setLocale(list.get(0));
        }

        setLastFile(props.getProperty(LAST_FILE, ""));
        setX(loadDouble(props.getProperty(X, "" + DEFAULT_X), DEFAULT_X));
        setY(loadDouble(props.getProperty(Y, "" + DEFAULT_Y), DEFAULT_Y));
        setHeight(loadDouble(props.getProperty(HEIGHT, "" + DEFAULT_HEIGHT), DEFAULT_HEIGHT));
        setWidth(loadDouble(props.getProperty(WIDTH, "" + DEFAULT_WIDTH), DEFAULT_WIDTH));
        setMaximized(Boolean.parseBoolean(props.getProperty(MAXIMIZED, "" + false)));
        setHideToolBar(Boolean.parseBoolean(props.getProperty(HIDE_TOOLBAR, "" + false)));
    }

    private double loadDouble(String parse, double defaultValue) {
        try {
            return Double.parseDouble(parse);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private int loadInt(String parse, int defaultValue) {
        try {
            return Integer.parseInt(parse);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }


    private Locale getDefaultLocale() {
        Locale loc = Locale.getDefault();
        if (Arrays.stream(LANGUAGES).anyMatch(e -> e.equals(loc))) {
            return loc;
        }
        return Locale.ENGLISH;
    }
}
