package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b\u00a8\u0006\'"}, d2 = {"Lcom/example/Database/Part_Entity;", "", "()V", "names", "", "getNames", "()Ljava/lang/String;", "setNames", "(Ljava/lang/String;)V", "owingP", "", "getOwingP", "()F", "setOwingP", "(F)V", "paidPart", "getPaidPart", "setPaidPart", "partDate", "getPartDate", "setPartDate", "partProduct", "getPartProduct", "setPartProduct", "partQuantity", "", "getPartQuantity", "()I", "setPartQuantity", "(I)V", "partid", "getPartid", "setPartid", "totalP", "getTotalP", "setTotalP", "type", "getType", "setType", "app_debug"})
public final class Part_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int partid;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo()
    private java.lang.String names;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String partDate;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String partProduct;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String type;
    @androidx.room.ColumnInfo()
    private int partQuantity;
    @androidx.room.ColumnInfo()
    private float totalP;
    @androidx.room.ColumnInfo()
    private float paidPart;
    @androidx.room.ColumnInfo()
    private float owingP;
    
    public final int getPartid() {
        return 0;
    }
    
    public final void setPartid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNames() {
        return null;
    }
    
    public final void setNames(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPartDate() {
        return null;
    }
    
    public final void setPartDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPartProduct() {
        return null;
    }
    
    public final void setPartProduct(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getPartQuantity() {
        return 0;
    }
    
    public final void setPartQuantity(int p0) {
    }
    
    public final float getTotalP() {
        return 0.0F;
    }
    
    public final void setTotalP(float p0) {
    }
    
    public final float getPaidPart() {
        return 0.0F;
    }
    
    public final void setPaidPart(float p0) {
    }
    
    public final float getOwingP() {
        return 0.0F;
    }
    
    public final void setOwingP(float p0) {
    }
    
    public Part_Entity() {
        super();
    }
}