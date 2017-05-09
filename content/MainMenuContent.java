package com.moonlay.android.training.content;

import com.moonlay.android.training.model.MainMenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tris Setiawan on 5/8/2017.
 */

public class MainMenuContent {

    public static final List<MainMenuItem> ITEMS = new ArrayList<MainMenuItem>();
    public static final Map<String, MainMenuItem> ITEM_MAP = new HashMap<String, MainMenuItem>();
    public static final int COUNT = 25;
    private static final String[] MENUS = {"MENU-01", "MENU-01"};

    static {
        int index = 0;
        for (String menu : MENUS) {
            MainMenuItem item = new MainMenuItem(String.valueOf(index++), menu, menu);
            MainMenuContent.addItem(item);
        }
    }

    private static void addItem(MainMenuItem item) {
        MainMenuContent.ITEMS.add(item);
        MainMenuContent.ITEM_MAP.put(item.id, item);
    }
}
