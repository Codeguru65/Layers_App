package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/example/Database/Health_Entity;", "", "()V", "hcause", "", "getHcause", "()Ljava/lang/String;", "setHcause", "(Ljava/lang/String;)V", "hdate", "getHdate", "setHdate", "healthS", "getHealthS", "setHealthS", "healthid", "", "getHealthid", "()I", "setHealthid", "(I)V", "app_debug"})
public final class Health_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int healthid;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo()
    private java.lang.String hdate;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo()
    private java.lang.String healthS;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo()
    private java.lang.String hcause;
    
    public final int getHealthid() {
        return 0;
    }
    
    public final void setHealthid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHdate() {
        return null;
    }
    
    public final void setHdate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHealthS() {
        return null;
    }
    
    public final void setHealthS(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHcause() {
        return null;
    }
    
    public final void setHcause(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Health_Entity() {
        super();
    }
}