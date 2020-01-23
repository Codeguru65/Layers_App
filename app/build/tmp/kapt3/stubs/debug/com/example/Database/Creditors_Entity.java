package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/example/Database/Creditors_Entity;", "", "()V", "credDate", "", "getCredDate", "()Ljava/lang/String;", "setCredDate", "(Ljava/lang/String;)V", "credId", "", "getCredId", "()I", "setCredId", "(I)V", "credNames", "getCredNames", "setCredNames", "owingCred", "", "getOwingCred", "()F", "setOwingCred", "(F)V", "app_debug"})
public final class Creditors_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int credId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String credNames;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String credDate;
    @androidx.room.ColumnInfo()
    private float owingCred;
    
    public final int getCredId() {
        return 0;
    }
    
    public final void setCredId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCredNames() {
        return null;
    }
    
    public final void setCredNames(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCredDate() {
        return null;
    }
    
    public final void setCredDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final float getOwingCred() {
        return 0.0F;
    }
    
    public final void setOwingCred(float p0) {
    }
    
    public Creditors_Entity() {
        super();
    }
}