package com.apulbere.codejam17;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collector.of;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.IntStream.range;

public class TidyNumbers extends Solution {

    @Override
    public String solve(String testCase) {
        var arr = testCase.chars().toArray();

        return Arrays.stream(solve(arr))
                .mapToObj(i -> (char) i)
                .collect(collectingAndThen(charCollector(), this::removeLeadingZero));
    }

    public int[] solve(int[] arr) {
        return isTidy(arr) ? arr : solve(decreaseNbr(arr));
    }

    private Collector<Character, StringBuilder, String> charCollector() {
        return collectingAndThen(of(StringBuilder::new, StringBuilder::append, StringBuilder::append), StringBuilder::toString);
    }

    private String removeLeadingZero(String str) {
        return str.replaceFirst("^0+(?!$)","");
    }

    private boolean isTidy(int[] arr) {
        return stream(arr).mapToObj(i -> arr[i] > arr[i + 1]).noneMatch(Boolean.TRUE::equals);
    }

    private int checkPos(int[] arr) {
        return stream(arr).filter(i -> arr[i] > arr[i + 1]).findAny().orElse(arr.length);
    }

    private IntStream stream(int[] arr) {
        return range(0, arr.length - 1);
    }

    private int[] decreaseNbr(int[] arr) {
        var i = checkPos(arr);
        arr[i] = arr[i] - 1;
        for(var j = i + 1; j < arr.length; j++) {
            arr[j] = 57;
        }
        return arr;
    }
}
