package com.system.util;

import com.system.po.Phone.PhoneTree;

import java.util.ArrayList;
import java.util.List;

public class PhoneTreeNodeManager {
    private List<PhoneTree> list;// 树的所有节点

    public PhoneTreeNodeManager(PhoneTree[] items) {
        list = new ArrayList<PhoneTree>();
        for (PhoneTree treeNode : items) {
            list.add(treeNode);
        }
    }

    public PhoneTreeNodeManager(List<PhoneTree> items) {
        list = items;
    }

    /**
     * 根据节点ID获取一个节点
     *
     * @param id
     *            节点ID
     * @return 对应的节点对象
     */
    public PhoneTree getTreeNodeAT(String id) {
        for (PhoneTree treeNode : list) {
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
    public PhoneTree getRoot() {
        for (PhoneTree treeNode : list) {
            if (treeNode.getpId() == null || treeNode.getpId().equals("")
                    || treeNode.getpId().equals("-1"))
                return treeNode;
        }
        return null;
    }
}
