package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b\u00a8\u0006\u001b"}, d2 = {"Lcom/example/Database/Client_Entity;", "", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "clientID", "", "getClientID", "()I", "setClientID", "(I)V", "clientType", "getClientType", "setClientType", "email", "getEmail", "setEmail", "nameClient", "getNameClient", "setNameClient", "phone", "getPhone", "setPhone", "app_debug"})
public final class Client_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int clientID;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String nameClient;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String clientType;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String address;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String phone;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String email;
    
    public final int getClientID() {
        return 0;
    }
    
    public final void setClientID(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNameClient() {
        return null;
    }
    
    public final void setNameClient(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getClientType() {
        return null;
    }
    
    public final void setClientType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAddress() {
        return null;
    }
    
    public final void setAddress(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhone() {
        return null;
    }
    
    public final void setPhone(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public Client_Entity() {
        super();
    }
}