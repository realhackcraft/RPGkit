package LDtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Possible values: `Hidden`, `ValueOnly`, `NameAndValue`, `EntityTile`, `LevelTile`,
 * `Points`, `PointStar`, `PointPath`, `PointPathLoop`, `RadiusPx`, `RadiusGrid`,
 * `ArrayCountWithLabel`, `ArrayCountNoLabel`, `RefLinkBetweenPivots`,
 * `RefLinkBetweenCenters`
 */
public enum EditorDisplayMode {
    ARRAY_COUNT_NO_LABEL, ARRAY_COUNT_WITH_LABEL, ENTITY_TILE, HIDDEN, LEVEL_TILE, NAME_AND_VALUE, POINTS, POINT_PATH, POINT_PATH_LOOP, POINT_STAR, RADIUS_GRID, RADIUS_PX, REF_LINK_BETWEEN_CENTERS, REF_LINK_BETWEEN_PIVOTS, VALUE_ONLY;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ARRAY_COUNT_NO_LABEL: return "ArrayCountNoLabel";
            case ARRAY_COUNT_WITH_LABEL: return "ArrayCountWithLabel";
            case ENTITY_TILE: return "EntityTile";
            case HIDDEN: return "Hidden";
            case LEVEL_TILE: return "LevelTile";
            case NAME_AND_VALUE: return "NameAndValue";
            case POINTS: return "Points";
            case POINT_PATH: return "PointPath";
            case POINT_PATH_LOOP: return "PointPathLoop";
            case POINT_STAR: return "PointStar";
            case RADIUS_GRID: return "RadiusGrid";
            case RADIUS_PX: return "RadiusPx";
            case REF_LINK_BETWEEN_CENTERS: return "RefLinkBetweenCenters";
            case REF_LINK_BETWEEN_PIVOTS: return "RefLinkBetweenPivots";
            case VALUE_ONLY: return "ValueOnly";
        }
        return null;
    }

    @JsonCreator
    public static EditorDisplayMode forValue(String value) throws IOException {
        if (value.equals("ArrayCountNoLabel")) return ARRAY_COUNT_NO_LABEL;
        if (value.equals("ArrayCountWithLabel")) return ARRAY_COUNT_WITH_LABEL;
        if (value.equals("EntityTile")) return ENTITY_TILE;
        if (value.equals("Hidden")) return HIDDEN;
        if (value.equals("LevelTile")) return LEVEL_TILE;
        if (value.equals("NameAndValue")) return NAME_AND_VALUE;
        if (value.equals("Points")) return POINTS;
        if (value.equals("PointPath")) return POINT_PATH;
        if (value.equals("PointPathLoop")) return POINT_PATH_LOOP;
        if (value.equals("PointStar")) return POINT_STAR;
        if (value.equals("RadiusGrid")) return RADIUS_GRID;
        if (value.equals("RadiusPx")) return RADIUS_PX;
        if (value.equals("RefLinkBetweenCenters")) return REF_LINK_BETWEEN_CENTERS;
        if (value.equals("RefLinkBetweenPivots")) return REF_LINK_BETWEEN_PIVOTS;
        if (value.equals("ValueOnly")) return VALUE_ONLY;
        throw new IOException("Cannot deserialize EditorDisplayMode");
    }
}
