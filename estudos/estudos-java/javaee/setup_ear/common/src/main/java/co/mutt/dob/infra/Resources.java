package co.mutt.dob.infra;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public final class Resources {
    private Resources() {
    }

    private static final ResourceBundle MENSAGENS = ResourceBundle.getBundle("messages", Locale.getDefault());
    private static final ResourceBundle PROPRIEDADES = ResourceBundle.getBundle("application", Locale.getDefault());
    private static final ResourceBundle BEANS = ResourceBundle.getBundle("beans", Locale.getDefault());

    public static final String   getMessage(String key) {
        return MENSAGENS.getString(key);
    }

    public static final String getMessage(String key, Object... params) {
        return MessageFormat.format(MENSAGENS.getString(key), params);
    }

    public static final String getProperty(String key) {
        return PROPRIEDADES.getString(key);
    }

    public static final String getProperty(String key, Object... params) {
        return MessageFormat.format(PROPRIEDADES.getString(key), params);
    }

    public static final String getBean(String key) {
        return MessageFormat.format(BEANS.getString(key), getProperty("versao.atual"));
    }
}
