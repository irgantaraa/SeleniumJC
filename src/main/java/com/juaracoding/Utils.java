package com.juaracoding;

public class Utils {
    public void delay(long detik) {
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

