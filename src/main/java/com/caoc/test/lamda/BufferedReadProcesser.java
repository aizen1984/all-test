package com.caoc.test.lamda;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReadProcesser {
    String process(BufferedReader bufferedReader) throws IOException;
}
