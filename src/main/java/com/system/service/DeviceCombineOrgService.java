package com.system.service;

import com.system.po.DataTablePageing;

public interface DeviceCombineOrgService {
    DataTablePageing selectDeviceByORGIdPaging(Integer pageNumber, Integer pageSize, String orgId) throws Exception;

}
