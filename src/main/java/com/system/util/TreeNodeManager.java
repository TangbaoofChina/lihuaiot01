package com.system.util;

import com.system.po.BootStrapTreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeManager {
    private List<BootStrapTreeNode> list;// 树的所有节点

    public TreeNodeManager(BootStrapTreeNode[] items) {
        list = new ArrayList<BootStrapTreeNode>();
        for (BootStrapTreeNode treeNode : items) {
            list.add(treeNode);
        }
    }

    public TreeNodeManager(List<BootStrapTreeNode> items) {
        list = items;
    }

    /**
     * 根据节点ID获取一个节点
     *
     * @param id
     *            节点ID
     * @return 对应的节点对象
     */
    public BootStrapTreeNode getTreeNodeAT(String id) {
        for (BootStrapTreeNode treeNode : list) {
            if (treeNode.getId().equals(id))
                return treeNode;
        }
        return null;
    }

    /**
     * 获取树的根节点
     *
     * @return 一棵树的根节点
     */
    public BootStrapTreeNode getRoot() {
        for (BootStrapTreeNode treeNode : list) {
            if (treeNode.getpId() == null || treeNode.getpId().equals("")
                    || treeNode.getpId().equals("-1"))
                return treeNode;
        }
        return null;
    }
}
