package edu.iscas.tcse.fastjsontest;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;

public class TestFastJSON {

    public static class TestState {

        Map<String, Integer> currentTerm;

        public TestState(Map<String, Integer> currentTerm) {
            this.currentTerm = currentTerm;
        }
    }

    private static final Filter autoTypeFilter = JSONReader.autoTypeFilter(
            "com.",
            "org.",
            "java.",
            "edu.");

    public JSONWriter.Feature[] features = new JSONWriter.Feature[] {
            JSONWriter.Feature.WriteClassName,
            JSONWriter.Feature.FieldBased,
    };

    public JSONReader.Feature[] readerFeatures = new JSONReader.Feature[] {
            JSONReader.Feature.FieldBased,
    };

    /*
     * FWH: It seems a bug of FastJSON.
     */
    // @Disabled
    @Test
    void testFastJSON() {
        Map<String, Integer> currentTerm = new java.util.HashMap<>();
        currentTerm.put("N1", 2);
        currentTerm.put("N2", 2);
        currentTerm.put("N3", 1);
        TestState ts = new TestState(currentTerm);
        String stateJSONStr = JSONObject.toJSONString(ts, features);
        TestState deseriObj = JSON.parseObject(stateJSONStr, TestState.class,
                autoTypeFilter,
                readerFeatures);
    }
}
