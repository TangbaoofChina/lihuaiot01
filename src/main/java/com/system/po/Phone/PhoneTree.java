package com.system.po.Phone;

import com.system.po.ORGTreeNode;

import java.util.List;

/**
 * 按照周成的需求，做的手机端显示的组织价格，可以考虑后面做成通用版本，目前是为HJ212C213服务
 */
public class PhoneTree {
    private String id;
    private String name;
    private String pId;
    private List<PhoneTree> children = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public List<PhoneTree> getChildren() {
        return children;
    }

    public void setChildren(List<PhoneTree> children) {
        this.children = children;
    }

    public PhoneTree(){}

    public PhoneTree(ORGTreeNode orgTreeNode){
        this.setId(orgTreeNode.getId());
        this.setpId(orgTreeNode.getpId());
        this.setName(orgTreeNode.getName());
    }
}
