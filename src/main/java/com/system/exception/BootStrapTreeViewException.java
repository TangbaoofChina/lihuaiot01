package com.system.exception;

public class BootStrapTreeViewException extends BusinessException {
    public BootStrapTreeViewException(){
        super();
    }

    public BootStrapTreeViewException(Exception e){
        super(e);
    }

    public BootStrapTreeViewException(Exception e, String exceptionDesc){
        super(e, exceptionDesc);
    }

    public BootStrapTreeViewException(String exceptionDesc){
        super(exceptionDesc);
    }
}
