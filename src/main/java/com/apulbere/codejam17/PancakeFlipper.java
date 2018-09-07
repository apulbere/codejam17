package com.apulbere.codejam17;

import static java.util.stream.IntStream.range;

public class PancakeFlipper extends Solution {

    @Override
    public String solve(String caseTest) {
        var caseTestData = caseTest.split(" ");
        var flipperSize = Integer.valueOf(caseTestData[1]);

        var count = 0;
        var data = caseTestData[0].toCharArray();
        for(var i = 0; i <= data.length - flipperSize; i++) {
            if('-' == data[i]) {
                count++;
                for(int j = i, max = i + flipperSize; j < max; j++) {
                    data[j] = data[j] == '-' ? '+' : '-';
                }
            }
        }

        return range(0, data.length).mapToObj(i -> data[i]).allMatch(c -> '-' != c) ? "" + count : "IMPOSSIBLE";
    }

}
