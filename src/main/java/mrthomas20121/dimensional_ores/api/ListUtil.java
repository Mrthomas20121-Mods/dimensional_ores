package mrthomas20121.dimensional_ores.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtil {

    public static <T> List<T> newArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
