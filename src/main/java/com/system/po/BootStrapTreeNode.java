package com.system.po;

import java.util.ArrayList;
import java.util.List;

public class BootStrapTreeNode {

    /**
     * id
     */
    private String id;
    /*
父节点ID
 */
    private String pId;
    //父节点至根节点id
    private String lPid;
    /**
     * 节点名称
     */
    private String text;
    /**
     * 子节点
     */
    private List<BootStrapTreeNode> nodes = null;

    private String icon = "glyphicon glyphicon-home";
 /*    private String selectedIcon="glyphicon glyphicon-stop";
    private String  color="#000000";
    private String  backColor="#FFFFFF";
    private String href="#node-1";
    private boolean selectable=true;
    private String tags ="available";*/

    private BootStrapTreeNodeState state = new BootStrapTreeNodeState();

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getlPid() {
        return lPid;
    }

    public void setlPid(String lPid) {
        this.lPid = lPid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<BootStrapTreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<BootStrapTreeNode> nodes) {
        this.nodes = nodes;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BootStrapTreeNodeState getState() {
        return state;
    }

    public void setState(BootStrapTreeNodeState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BootStrapTreeNode{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", lPid='" + lPid + '\'' +
                '}';
    }

    /*   public String getSelectedIcon() {
            return selectedIcon;
        }

        public void setSelectedIcon(String selectedIcon) {
            this.selectedIcon = selectedIcon;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBackColor() {
            return backColor;
        }

        public void setBackColor(String backColor) {
            this.backColor = backColor;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public boolean isSelectable() {
            return selectable;
        }

        public void setSelectable(boolean selectable) {
            this.selectable = selectable;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }*/

}
