package com.github.watchyouss.instDataProcessor.common;

public enum CommonConstants {
    LOCALHOST_URL("http://localhost:");

    private String value;

    CommonConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
