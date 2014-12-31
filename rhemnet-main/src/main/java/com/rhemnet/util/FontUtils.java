package com.rhemnet.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class FontUtils {

    public static final String HELVETICA_NORMAL = "helvetica-normal";

    private static final String FONT_PATH_PATTERN = "fonts/%s.ttf";

    private static Map<String, Typeface> sCache = new HashMap<String, Typeface>();

    public static void applyFont(Context context, TextView textView, String fontName, boolean isBold) {
        Typeface typeface = get(context, fontName);

        if (isBold) {
            textView.setTypeface(typeface, Typeface.BOLD);
        } else {
            textView.setTypeface(typeface);
        }
    }

    private static Typeface get(Context context, String name) {

        if (!sCache.containsKey(name)) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), String.format(FONT_PATH_PATTERN, name));
            sCache.put(name, typeface);
        }

        return sCache.get(name);
    }
}
