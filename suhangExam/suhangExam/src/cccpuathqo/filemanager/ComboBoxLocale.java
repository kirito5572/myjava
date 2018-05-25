package cccpuathqo.filemanager;

import java.util.Locale;

class ComboBoxLocale {
    private String text;
    private Locale locale;

    ComboBoxLocale(String text, Locale locale) {
        this.text = text;
        this.locale = locale;
    }

    @Override
    public String toString() {
        return text;
    }

    Locale getLocale() {
        return locale;
    }
}
