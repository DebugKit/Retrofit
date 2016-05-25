package com.slht.retrofit;

/**
 * Created by LI on 2016/5/24.
 */
public class HttpResult<T> {
    //用来模仿resultCode和resultMessage
    private int resultCode;
    private String resultMessage;

    //用来模仿Data
    private T subjects;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }
}
