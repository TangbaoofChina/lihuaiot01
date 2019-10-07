package com.system.util.msg;

public class ResponseUtil {
    public static Response setResponsFaild() {
        Response responseBean = new Response();
        responseBean.setData(null);
        responseBean.setCode(1);
        responseBean.setMsg("异常错误");
        return responseBean;
    }

    public static Response setResponsFaild(String errStr) {
        Response responseBean = new Response();
        responseBean.setData(null);
        responseBean.setCode(1);
        responseBean.setMsg(errStr);
        return responseBean;
    }

    public static Response setResponseOk(Object data) {
        Response responseBean = new Response();
        responseBean.setData(data);
        responseBean.setCode(0);
        responseBean.setMsg("OK");
        return responseBean;
    }
}
