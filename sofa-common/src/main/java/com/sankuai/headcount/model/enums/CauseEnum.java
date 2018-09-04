package com.sankuai.headcount.model.enums;

public enum CauseEnum {

    SQL("sql错误"),
    CACHE("cache错误"),
    FS("文件系统错误");

    private String message;

    CauseEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}