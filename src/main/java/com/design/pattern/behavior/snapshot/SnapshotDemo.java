package com.design.pattern.behavior.snapshot;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

/**
 * 备忘录模式  (利用栈的先进后出原理 进行每次压栈备份 从最顶部移除实现撤销恢复)
 * <p>
 * 希望你编写一个小程序，可以接收命令行的输入。用户输入文本时，程序将其追加存储在内存文本中；
 * 用户输入“:list”，程序在命令行中输出内存文本的内容；用户输入“:undo”，程序会撤销上一次输入的文本，也就是从内存文本中将上次输入的文本删除掉。
 *
 * @author chenpeng
 */
public class SnapshotDemo {

    public static void main(String[] args) {
        // 输入文本
        InputText inputText = new InputText();
        // 快照架
        SnapshotHolder snapshotsHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("list")) {
                System.out.println(inputText.getText());
            } else if (input.equals("undo")) {
                Snapshot snapshot = snapshotsHolder.popSnapshot();
                inputText.restoreSnapshot(snapshot);
            } else {
                snapshotsHolder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }

    public static void snapshot() {
        List<String> list = Lists.newArrayList();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("list")) {
                System.out.println(list);
                continue;
            }
            if (line.equals("undo")) {
                list.remove(list.size() - 1);
                continue;
            }
            list.add(line);
        }
    }
}
