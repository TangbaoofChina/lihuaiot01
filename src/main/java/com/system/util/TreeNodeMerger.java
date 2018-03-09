package com.system.util;

import com.system.po.BootStrapTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点归并类
 *
 * @author bearsmall
 */
public class TreeNodeMerger {
    /**
     * 将节点数组归并为一棵树（填充节点的children域）
     * 时间复杂度为O(n^2)
     *
     * @param items 节点域
     * @return
     */
    public static BootStrapTreeNode merge(BootStrapTreeNode[] items) {
        TreeNodeManager treeNodeManager = new TreeNodeManager(items);
        for (BootStrapTreeNode treeNode : items) {
            if (treeNode.getpId() != null && !treeNode.getpId().equals("")) {
                BootStrapTreeNode t = treeNodeManager.getTreeNodeAT(treeNode.getpId());
                t.getNodes().add(treeNode);
            }
        }
        return treeNodeManager.getRoot();
    }

    /**
     * 将节点数组归并为一棵树（填充节点的children域）
     * 时间复杂度为O(n^2)
     *
     * @param items 节点域
     * @return
     */
    public static BootStrapTreeNode merge(List<BootStrapTreeNode> items) {
        TreeNodeManager treeNodeManager = new TreeNodeManager(items);
        for (BootStrapTreeNode treeNode : items) {
            if (treeNode.getpId() != null && !treeNode.getpId().equals("")) {
                BootStrapTreeNode t = treeNodeManager.getTreeNodeAT(treeNode.getpId());
                if (t.getNodes() == null)
                    t.setNodes(new ArrayList<BootStrapTreeNode>());
                t.getNodes().add(treeNode);
            }
        }
        return treeNodeManager.getRoot();
    }
}
