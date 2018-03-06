package com.system.service.impl;

import com.system.mapperiot.DeviceInfoMapper;
import com.system.mapperiot.ORGTreeNodeMapper;
import com.system.po.DeviceInfo;
import com.system.po.DeviceInfoAndNode;
import com.system.po.ORGTreeNode;
import com.system.service.DeviceInfoService;
import com.system.util.EJConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;
    @Autowired
    private ORGTreeNodeMapper orgTreeNodeMapper;
    @Autowired
    private EJConvertor ejConvertor;

    @Override
    public List<DeviceInfo> selectDeviceInfoByORGId(String orgId) throws Exception {
        List<DeviceInfo> list = deviceInfoMapper.selectDeviceByORGId(orgId);
        for (DeviceInfo deviceInfo:list
                ) {

            SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String toDate = simpleFormat.format(new Date());
            long from =  simpleFormat.parse(deviceInfo.getDReceiveTime()).getTime();
            long to = simpleFormat.parse(toDate).getTime();
            int minutes = (int) ((to - from) / (1000 * 60));
            if (minutes > 15)
                deviceInfo.setDState("离线");
            else
                deviceInfo.setDState("在线");
        }
        return list;
    }

    @Override
    public List<DeviceInfo> selectDeviceInfoByIDs(String[] sDeviceIds) throws Exception {
        return deviceInfoMapper.selectDeviceInfoByIDs(sDeviceIds);
    }

    @Override
    public List<DeviceInfo> selectDeviceInfoByRoleId(String roleId) throws Exception {
        return deviceInfoMapper.selectDeviceInfoByRoleId(roleId);
    }

    @Override
    public int updateDeviceOrgId(String sSerialNum,String deviceName, String sOrgId) throws Exception {
        return deviceInfoMapper.updateDeviceOrgId(sSerialNum,deviceName,sOrgId);
    }

    @Override
    public void batchUpdateDeviceOrgId(String[] deviceIds, String sOrgId) throws Exception {
        deviceInfoMapper.batchUpdateDeviceOrgId(deviceIds,sOrgId);
    }

    @Override
    public List<DeviceInfoAndNode> selectDeviceInfoByOrgIdAll(String orgId) throws Exception {
        List<DeviceInfoAndNode> deviceInfoList = deviceInfoMapper.selectDeviceAndNodeByORGId(orgId);
        //取出当前节点的下级节点
        List<ORGTreeNode> orgTreeNodeListChild = orgTreeNodeMapper.selectORGInfoByParentId(orgId);
        if (orgTreeNodeListChild.size() > 0) {
            getDeviceChildList(deviceInfoList, orgTreeNodeListChild);
        }
        return deviceInfoList;
    }

    private void getDeviceChildList(List<DeviceInfoAndNode> deviceInfoList,List<ORGTreeNode> orgTreeNodeList) throws Exception {
        String myOrgId = "";
        for (ORGTreeNode orgTreeNode : orgTreeNodeList
                ) {
            myOrgId = orgTreeNode.getId();
            //添加当前节点下的所有设备
            List<DeviceInfoAndNode> deviceInfoList1 = deviceInfoMapper.selectDeviceAndNodeByORGId(myOrgId);
            if (deviceInfoList1.size() > 0)
                deviceInfoList.addAll(deviceInfoList1);
            //以当前节点为父节点，查询所有子节点
            List<ORGTreeNode> orgTreeNodeList1 = orgTreeNodeMapper.selectORGInfoByParentId(myOrgId);
            if (orgTreeNodeList1.size() > 0) {
                getDeviceChildList(deviceInfoList,orgTreeNodeList1);
            }
        }
    }

    /**
     * 导出库存记录
     *
     * @param storageList 保存有库存记录的List
     * @return excel 文件
     */
    @Override
    public File exportStorage(List<DeviceInfo> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(DeviceInfo.class, storageList);
        //return null;
    }
}
