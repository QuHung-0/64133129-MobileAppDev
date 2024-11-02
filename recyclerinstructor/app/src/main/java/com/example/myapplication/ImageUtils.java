package com.example.myapplication;

import android.content.Context;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ImageUtils {
    public static List<Integer> getDrawableImagesByPrefix(Context context, String prefix) {
        List<Integer> images = new ArrayList<>();
        try {
            Field[] fields = R.drawable.class.getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().startsWith(prefix)) {
                    images.add(field.getInt(null));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return images;
    }
}
