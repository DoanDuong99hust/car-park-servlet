package com.carpark.model;

public class JsonResult {
    private  boolean successl;
    private Object data;

    public JsonResult(boolean successl, Object data) {
        this.successl = successl;
        this.data = data;
    }

    public JsonResult() {
    }

    public boolean isSuccessl() {
        return successl;
    }

    public void setSuccessl(boolean successl) {
        this.successl = successl;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult jsonSuccess(Object data) {
        return new JsonResult(true, data);
    }

    public JsonResult jsonFalse(Object data) {
        return new JsonResult(false,data);
    }
}
