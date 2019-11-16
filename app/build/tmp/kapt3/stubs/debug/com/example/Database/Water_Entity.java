package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/example/Database/Water_Entity;", "", "()V", "level", "", "getLevel", "()Ljava/lang/String;", "setLevel", "(Ljava/lang/String;)V", "waterid", "", "getWaterid", "()I", "setWaterid", "(I)V", "wdate", "getWdate", "setWdate", "app_debug"})
public final class Water_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int waterid;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String wdate;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String level;
    
    public final int getWaterid() {
        return 0;
    }
    
    public final void setWaterid(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWdate() {
        return null;
    }
    
    public final void setWdate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLevel() {
        return null;
    }
    
    public final void setLevel(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public Water_Entity() {
        super();
    }
}