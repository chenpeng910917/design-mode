package com.design.pattern.structure.composite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件系统节点
 *
 * @author chenpeng
 */
public class FileSystemNode {
    /**
     * 路径
     */
    private final String path;
    /**
     * 是否为文件
     */
    private final boolean isFile;
    /**
     * 子节点
     */
    private final List<FileSystemNode> subNodes = new ArrayList<>();

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    /**
     * 统计文件个数
     *
     * @return 文件个数
     */
    public int countNumOfFiles() {
        if (isFile) {
            return 1;
        }
        int numOfFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    /**
     * 统计文件大小
     *
     * @return 文件大小
     */
    public long countSizeOfFiles() {
        if (isFile) {
            File file = new File(path);
            if (!file.exists()) {
                return 0;
            }
            return file.length();
        }
        long sizeofFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    /**
     * 获取文件路径
     *
     * @return 文件路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 添加节点
     *
     * @param fileOrDir 子节点信息
     */
    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    /**
     * 删除节点
     *
     * @param fileOrDir 子节点信息
     */
    public void removeSubNode(FileSystemNode fileOrDir) {
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
