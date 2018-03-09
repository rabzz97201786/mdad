package com.example.rabiasultan.cwk1.dummy;

import com.example.rabiasultan.cwk1.model.Holiday;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent1 {

    /**
     * An array of sample (dummy) items.
     */
    //public static final List<Holiday> ITEMS = new ArrayList<Holiday>();
    public static final List<Holiday> ITEMS = new ArrayList<Holiday>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    // not using a hashmap
    // public static final Map<String, Holiday> ITEM_MAP = new HashMap<String, Holiday>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createHoliday(i));
        }
    }

    private static void addItem(Holiday item) {
        ITEMS.add(item);
        //ITEM_MAP.put(item.id, item);
    }

    private static Holiday createHoliday(int position) {
        return new Holiday(position,"Holiday " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
    public static class Holiday implements Serializable {
        public final String id;
        public final String content;
        public final String details;

        public Holiday(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
     */
}
