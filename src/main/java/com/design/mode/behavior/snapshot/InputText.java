package com.design.mode.behavior.snapshot;

/**
 * 输入文本
 *
 * @author chenpeng
 */
public class InputText {

    private final StringBuilder text = new StringBuilder();

    /**
     * 获取文本
     * @return 文本信息
     */
    public String getText() {
        return text.toString();
    }

    /**
     * 追加文本
     * @param input 文本
     */
    public void append(String input) {
        text.append(input);
    }

    /**
     * 创建快照
     * @return 快照
     */
    public Snapshot createSnapshot() {
        return new Snapshot(text.toString());
    }

    /**
     * 恢复
     * @param snapshot 快照
     */
    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }
}
