package com.example.utils;

import com.example.constants.FrameWorkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public final class DataProviderUtils {
    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider(parallel = true)
    public static Object[] getData(Method m) {
        String testname = m.getName();
        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameWorkConstants.getIterationdatasheett());
        }
        List<Map<String, String>> smalllist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(testname) &&
                    (list.get(i).get("execute").equalsIgnoreCase("yes"))) {
                smalllist.add(list.get(i));
            }
        }
        return smalllist.toArray();
    }
}
