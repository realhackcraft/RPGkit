package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Flag {
    DISCARD_PRE_CSV_INT_GRID, EXPORT_PRE_CSV_INT_GRID_FORMAT, IGNORE_BACKUP_SUGGEST, MULTI_WORLDS, PREPEND_INDEX_TO_LEVEL_FILE_NAMES, USE_MULTILINES_TYPE;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case DISCARD_PRE_CSV_INT_GRID -> "DiscardPreCsvIntGrid";
            case EXPORT_PRE_CSV_INT_GRID_FORMAT -> "ExportPreCsvIntGridFormat";
            case IGNORE_BACKUP_SUGGEST -> "IgnoreBackupSuggest";
            case MULTI_WORLDS -> "MultiWorlds";
            case PREPEND_INDEX_TO_LEVEL_FILE_NAMES -> "PrependIndexToLevelFileNames";
            case USE_MULTILINES_TYPE -> "UseMultilinesType";
        };
    }

    @JsonCreator
    public static Flag forValue(String value) throws IOException {
        if (value.equals("DiscardPreCsvIntGrid")) return DISCARD_PRE_CSV_INT_GRID;
        if (value.equals("ExportPreCsvIntGridFormat")) return EXPORT_PRE_CSV_INT_GRID_FORMAT;
        if (value.equals("IgnoreBackupSuggest")) return IGNORE_BACKUP_SUGGEST;
        if (value.equals("MultiWorlds")) return MULTI_WORLDS;
        if (value.equals("PrependIndexToLevelFileNames")) return PREPEND_INDEX_TO_LEVEL_FILE_NAMES;
        if (value.equals("UseMultilinesType")) return USE_MULTILINES_TYPE;
        throw new IOException("Cannot deserialize Flag");
    }
}
