package xyz.codingmentor.javase3dk.littletasks;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Krisz
 */
public class GenericTree<T> {

    private T data;
    private final List<GenericTree<T>> children;
    private GenericTree<T> parent;

    public GenericTree() {
        children = new LinkedList<>();
    }

    public GenericTree(T data) {
        this.data = data;
        children = new LinkedList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addChild(GenericTree<T> child) {
        child.parent = this;
        children.add(child);
    }

    public void addChildren(List<GenericTree<T>> children) {
        for (GenericTree<T> child : children) {
            child.parent = this;
        }
        this.children.addAll(children);
    }

    public List<GenericTree<T>> getChildren() {
        return children;
    }

    public boolean isRoot() {
        return this.getParent() == null;
    }

    public GenericTree<T> getRoot() {
        GenericTree<T> genericTree = this;
        while (!genericTree.isRoot()) {
            genericTree = getParent();
        }
        return genericTree;
    }

    public GenericTree<T> getParent() {
        return parent;
    }

    public void setParent(GenericTree<T> parent) {
        this.parent = parent;
    }

    public List<T> build() {
        List<T> dataList = new LinkedList<>();
        GenericTree<T> root = getRoot();
        if (root != null) {
            buildPreOrder(root, dataList);
        }
        return dataList;
    }

    public void buildPreOrder(GenericTree<T> node, List<T> dataList) {
        dataList.add(node.data);
        for (GenericTree<T> child : node.children) {
            buildPreOrder(child, dataList);
        }
    }

}
