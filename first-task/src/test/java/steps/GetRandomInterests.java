package steps;

import utilities.RandUtils;

import java.util.List;

public class GetRandomInterests {

    private static final int RANGE = 21;
    private static final int EXCLUDED_INDEX = 18;
    private static final int NUM_OF_SELECTED_INDEXES = 3;

    public static List<Integer> getRandomInterests() {
        return RandUtils.getRands(RANGE, EXCLUDED_INDEX, NUM_OF_SELECTED_INDEXES);
    }

}
