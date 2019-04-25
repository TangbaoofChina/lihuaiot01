package com.system.util;

import com.system.po.Phone.PhoneTree;

import java.util.ArrayList;
import java.util.List;

public class PhoneTreeNodeMerger {
    /**
     * 将节点数组归并为一棵树（填充节点的children域）
     * 时间复杂度为O(n^2)
     *
     * @param items 节点域
     * @return
     */
    public static PhoneTree merge(PhoneTree[] items) {
        PhoneTreeNodeManager phoneTreeNodeManager = new PhoneTreeNodeManager(items);
        for (PhoneTree treeNode : items) {
            if (treeNode.getpId() != null && !treeNode.getpId().equals("")
                    && !treeNode.getpId().equals("-1")) {
                PhoneTree t = phoneTreeNodeManager.getTreeNodeAT(treeNode.getpId());
                t.getChildren().add(treeNode);
            }
        }
        return phoneTreeNodeManager.getRoot();
    }

    /**
     * 将节点数组归并为一棵树（填充节点的children域）
     * 时间复杂度为O(n^2)
     *
     * @param items 节点域
     * @return
     */
    public static PhoneTree merge(List<PhoneTree> items) {
        PhoneTreeNodeManager phoneTreeNodeManager = new PhoneTreeNodeManager(items);
        for (PhoneTree treeNode : items) {
            if (treeNode.getpId() != null && !treeNode.getpId().equals("")
                    && !treeNode.getpId().equals("-1")) {
                PhoneTree t = phoneTreeNodeManager.getTreeNodeAT(treeNode.getpId());
                if (t.getChildren() == null)
                    t.setChildren(new ArrayList<PhoneTree>());
                t.getChildren().add(treeNode);
            }
        }
        return phoneTreeNodeManager.getRoot();
    }
}
