package com.test.rpc;

import java.io.Serializable;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 20:11 2020/8/5
 * @Modified By
 **/
public class RpcRequest implements Serializable {

    private String className;

    private String methodName;

    private Object[] parameters;

    private String version;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
