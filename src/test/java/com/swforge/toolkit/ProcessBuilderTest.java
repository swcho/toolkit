package com.swforge.toolkit;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sungwoo on 14. 8. 7.
 */

public class ProcessBuilderTest {

    @Test
    public void testSimple() throws IOException, InterruptedException {
        //ProcessBuilder builder = new ProcessBuilder();
        Process p = Runtime.getRuntime().exec("ls");
        BufferedReader reader = new BufferedReader (new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = reader.readLine ()) != null) {
            System.out.println ("Stdout: " + line);
        }
        p.waitFor();
    }
}
