package com.design.pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件夹处理类(目录)
 *
 * @author chenpeng
 */
public class Directory extends AbstractFileSystemNode {

    private List<AbstractFileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (AbstractFileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long sizeofFiles = 0;
        for (AbstractFileSystemNode fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    /**
     * 添加节点
     *
     * @param fileOrDir 子节点信息
     */
    public void addSubNode(AbstractFileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    /**
     * 删除节点
     *
     * @param fileOrDir 子节点信息
     */
    public void removeSubNode(AbstractFileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}
