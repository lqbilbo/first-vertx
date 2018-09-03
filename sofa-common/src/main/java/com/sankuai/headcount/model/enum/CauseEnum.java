package com.sankuai.headcount.model.enum;

public enum CauseEnum {

    private String message;

    SQL("sql错误"),
    CACHE("cache错误"),
    FS("文件系统错误");

    CauseEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}