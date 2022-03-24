package com.design.pattern.behavior.snapshot;

/**
 * 快照
 *
 * @author chenpeng
 */
public class Snapshot {

    private final String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
