package com.system.po;

import com.system.po.Device.BaseDeviceMessage;

import java.util.List;

/**
 * 设备清单信息
 * 设备序列号；设备名称；设备URL
 */
public class DeviceCfgInfo extends BaseDeviceMessage {
    String dCfgUrlId;
    String dCfgUrl;

    public String getDCfgUrlId() {
        return dCfgUrlId;
    }

    public void setDCfgUrlId(String dCfgUrlId) {
        this.dCfgUrlId = dCfgUrlId;
    }

    public String getDCfgUrl() {
        return dCfgUrl;
    }

    public void setDCfgUrl(String dCfgUrl) {
        this.dCfgUrl = dCfgUrl;
    }

    public void findUrl(List<ORGTreeNode> orgTreeNodeList) {
        String urlName = "";
        if (dCfgUrlId.indexOf(".") > 0) {
            String[] sNodeId = dCfgUrlId.split("\\.");
            for (int i = 1; i < sNodeId.length; i++) {
                for (int j = 0; j < orgTreeNodeList.size(); j++)
                    if (orgTreeNodeList.get(j).getId().equals(sNodeId[i])) {
                        if (urlName.equals(""))
                            urlName = orgTreeNodeList.get(j).getName();
                        else
                            urlName = urlName + "-" + orgTreeNodeList.get(j).getName();
                        break;
                    }
            }
        }
        this.setDCfgUrl(urlName);
    }
}
