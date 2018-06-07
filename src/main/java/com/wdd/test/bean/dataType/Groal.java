package com.wdd.test.bean.dataType;

import java.io.Serializable;
import java.util.List;

public class Groal implements Serializable {
    private String view;
    private boolean success;
    private List<?> data;
    private String falg;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String getFalg() {
        return falg;
    }

    public void setFalg(String falg) {
        this.falg = falg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
