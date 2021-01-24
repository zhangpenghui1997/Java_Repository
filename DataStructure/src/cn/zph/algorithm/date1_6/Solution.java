package cn.zph.algorithm.date1_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        if (equations.size() == 0) {
            return null;
        }
        System.out.println(equations);
        System.out.println(queries);
        Map<String, Double> map = new HashMap<>();
        int i, j;
        double[] result = new double[equations.size()];
        for (i = 0; i < equations.size(); ++i) {
            String s = "";
            s += equations.get(i).get(0);
            s += equations.get(i).get(1);
            map.put(s, values[i]);
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        return null;

    }

    public static void main(String[] args) {

        double[] values = {2.0, 3.0};
        List<List<String>> equations = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        System.out.println(list1);
        equations.add(list1);
        System.out.println(equations);

        list1.clear();

        list1.add("b");
        list1.add("c");
        equations.add(list1);
        System.out.println(equations);

        List<List<String>> queries = new ArrayList<>();
        list1.clear();
        list1.add("a");
        list1.add("c");
        queries.add(list1);

        list1.clear();
        list1.add("b");
        list1.add("a");
        queries.add(list1);

        list1.clear();
        list1.add("a");
        list1.add("e");
        queries.add(list1);

        list1.clear();
        list1.add("a");
        list1.add("a");
        queries.add(list1);


        calcEquation(equations, values, queries);
    }
}
