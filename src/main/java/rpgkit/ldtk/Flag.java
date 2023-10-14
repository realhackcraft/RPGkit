package rpgkit.ldtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Flag {
    DISCARD_PRE_CSV_INT_GRID, EXPORT_PRE_CSV_INT_GRID_FORMAT, IGNORE_BACKUP_SUGGEST, MULTI_WORLDS, PREPEND_INDEX_TO_LEVEL_FILE_NAMES, USE_MULTILINES_TYPE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case DISCARD_PRE_CSV_INT_GRID: return "DiscardPreCsvIntGrid";
            case EXPORT_PRE_CSV_INT_GRID_FORMAT: return "ExportPreCsvIntGridFormat";
            case IGNORE_BACKUP_SUGGEST: return "IgnoreBackupSuggest";
            case MULTI_WORLDS: return "MultiWorlds";
            case PREPEND_INDEX_TO_LEVEL_FILE_NAMES: return "PrependIndexToLevelFileNames";
            case USE_MULTILINES_TYPE: return "UseMultilinesType";
        }
        return null;
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
