package com.apulbere.codejam17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Solution {

    public abstract String solve(String testCase);

    public void solve(String inPath, String outPath) throws IOException {
        try (var reader = new BufferedReader(new FileReader(inPath)); var writer = new PrintWriter(outPath)) {
            reader.readLine();
            String line;
            var caseIndex = 1;
            while ((line = reader.readLine()) != null) {
                writer.printf("Case #%s: %s\n", caseIndex++, solve(line));
            }
        }
    }

}
