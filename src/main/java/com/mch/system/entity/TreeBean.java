package com.mch.system.entity;

import java.util.ArrayList;
import java.util.List;

public class TreeBean {
    private String id;  //节点的 id，它对于加载远程数据很重要。
    private String text;   //要显示的节点文本。
    private String state;  //节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
    private Boolean checked;//指示节点是否被选中。
    private String attributes;//给一个节点添加的自定义属性。
    private List<TreeBean> children = new ArrayList<TreeBean>();

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public List<TreeBean> getChildren() {
        return children;
    }

    public void setChildren(List<TreeBean> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeBean{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", checked=" + checked +
                ", attributes='" + attributes + '\'' +
                ", children=" + children +
                '}';
    }
}
