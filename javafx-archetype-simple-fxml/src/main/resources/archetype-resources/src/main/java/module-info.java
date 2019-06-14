#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
module ${package} {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;

    opens ${package} to javafx.fxml;
    opens ${package}.control to javafx.fxml;
    exports ${package};
    exports ${package}.util;
    exports ${package}.control;
}