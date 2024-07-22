package com.gfrjxz.cms.entity;

import javax.validation.constraints.NotEmpty;

public class CreateCodeDTO {


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    private String packageName;

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getCodeNote() {
        return codeNote;
    }

    public void setCodeNote(String codeNote) {
        this.codeNote = codeNote;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    @NotEmpty
    private String sourcePath;
    private String codeNote;
    @NotEmpty
    private String tableName;
    @NotEmpty
    private String codeName;
}
