package com.nexters.taigerapp.common.log;

/**
 * Created by leoshin on 15. 4. 6..
 */
public enum Tag {
    DEFAULT("nexters.taiger");

    private final String tag;

    private Tag(String tag) {
        this.tag = tag;
    }

    public String tag() {
        return tag;
    }
}
