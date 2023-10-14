package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum TextLanguageMode {
    LANG_C, LANG_HAXE, LANG_JS, LANG_JSON, LANG_LOG, LANG_LUA, LANG_MARKDOWN, LANG_PYTHON, LANG_RUBY, LANG_XML;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case LANG_C -> "LangC";
            case LANG_HAXE -> "LangHaxe";
            case LANG_JS -> "LangJS";
            case LANG_JSON -> "LangJson";
            case LANG_LOG -> "LangLog";
            case LANG_LUA -> "LangLua";
            case LANG_MARKDOWN -> "LangMarkdown";
            case LANG_PYTHON -> "LangPython";
            case LANG_RUBY -> "LangRuby";
            case LANG_XML -> "LangXml";
        };
    }

    @JsonCreator
    public static TextLanguageMode forValue(String value) throws IOException {
        if (value.equals("LangC")) return LANG_C;
        if (value.equals("LangHaxe")) return LANG_HAXE;
        if (value.equals("LangJS")) return LANG_JS;
        if (value.equals("LangJson")) return LANG_JSON;
        if (value.equals("LangLog")) return LANG_LOG;
        if (value.equals("LangLua")) return LANG_LUA;
        if (value.equals("LangMarkdown")) return LANG_MARKDOWN;
        if (value.equals("LangPython")) return LANG_PYTHON;
        if (value.equals("LangRuby")) return LANG_RUBY;
        if (value.equals("LangXml")) return LANG_XML;
        throw new IOException("Cannot deserialize TextLanguageMode");
    }
}
