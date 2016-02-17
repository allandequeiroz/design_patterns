package common;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public enum Spliters {
    WORDS_SPLITTER("[\\P{L}]+"),
    LINE_SPLITTER("\n"),
    WORD_SPLITTER(" ");

    private String splitter;

    Spliters(String splitter) {
        this.splitter = splitter;
    }

    public String getValue(){
        return splitter;
    }
}
