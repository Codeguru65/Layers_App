package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/example/Database/Mort_Entity;", "", "()V", "mcause", "", "getMcause", "()Ljava/lang/String;", "setMcause", "(Ljava/lang/String;)V", "mdate", "getMdate", "setMdate", "mortNum", "", "getMortNum", "()I", "setMortNum", "(I)V", "mortid", "getMortid", "setMortid", "app_debug"})
public final class Mort_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int mortid;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String mdate;
    @androidx.room.ColumnInfo()
    private int mortNum;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String mcause;
    
    public final int getMortid() {
        return 0;
    }
    
    public final void setMortid(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMdate() {
        return null;
    }
    
    public final void setMdate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getMortNum() {
        return 0;
    }
    
    public final void setMortNum(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMcause() {
        return null;
    }
    
    public final void setMcause(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public Mort_Entity() {
        super();
    }
}