package com.design.pattern.structure.composite;

/**
 * 抽象文件系统节点
 *
 * @author chenpeng
 */
public abstract class AbstractFileSystemNode {
    /**
     * 路径
     */
    protected final String path;

    public AbstractFileSystemNode(String path) {
        this.path = path;
    }

    /**
     * 统计文件个数
     *
     * @return 文件个数
     */
    public abstract int countNumOfFiles();

    /**
     * 统计文件大小
     *
     * @return 文件大小
     */
    public abstract long countSizeOfFiles();

    /**
     * 获取路径
     * @return 路径
     */
    public String getPath() {
        return path;
    }
}
