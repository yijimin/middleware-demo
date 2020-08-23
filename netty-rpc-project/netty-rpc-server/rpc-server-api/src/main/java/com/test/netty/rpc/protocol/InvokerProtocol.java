package com.test.netty.rpc.protocol;

import java.io.Serializable;

/**
 * @Author: yijimin
 * @Description: 自定义传输协议
 * @Date: Created in 12:13 2020/8/22
 * @Modified By
 **/
public class InvokerProtocol implements Serializable {

    private String className;//类名

    private String methodName;//函数名称

    private Class<?>[] params;//形参列表

    private Object[] values;//实参列表

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

    public Class<?>[] getParams() {
        return params;
    }

    public void setParams(Class<?>[] params) {
        this.params = params;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }
}
