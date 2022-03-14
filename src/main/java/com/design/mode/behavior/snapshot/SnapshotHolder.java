package com.design.mode.behavior.snapshot;

import java.util.Stack;

/**
 * 快照架
 *
 * @author chenpeng
 */
public class SnapshotHolder {
    /**
     * 快照(堆)
     */
    private final Stack<Snapshot> snapshots = new Stack<>();

    /**
     * 删除此堆栈顶部的对象
     *
     * @return 并将该对象作为此函数的值返回
     */
    public Snapshot popSnapshot() {
        return snapshots.pop();
    }

    /**
     * 将项目推送到此堆栈的顶部
     *
     * @param snapshot 快照
     */
    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }
}
