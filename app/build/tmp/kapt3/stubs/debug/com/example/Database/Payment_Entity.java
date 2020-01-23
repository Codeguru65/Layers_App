package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e\u00a8\u0006\'"}, d2 = {"Lcom/example/Database/Payment_Entity;", "", "()V", "nameS", "", "getNameS", "()Ljava/lang/String;", "setNameS", "(Ljava/lang/String;)V", "owingPay", "", "getOwingPay", "()F", "setOwingPay", "(F)V", "paidPay", "getPaidPay", "setPaidPay", "payDate", "getPayDate", "setPayDate", "payProduct", "getPayProduct", "setPayProduct", "payQuantity", "", "getPayQuantity", "()I", "setPayQuantity", "(I)V", "payType", "getPayType", "setPayType", "payid", "getPayid", "setPayid", "totalPay", "getTotalPay", "setTotalPay", "app_debug"})
public final class Payment_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int payid;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo()
    private java.lang.String nameS;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String payDate;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String payProduct;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String payType;
    @androidx.room.ColumnInfo()
    private int payQuantity;
    @androidx.room.ColumnInfo()
    private float totalPay;
    @androidx.room.ColumnInfo()
    private float paidPay;
    @androidx.room.ColumnInfo()
    private float owingPay;
    
    public final int getPayid() {
        return 0;
    }
    
    public final void setPayid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNameS() {
        return null;
    }
    
    public final void setNameS(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayDate() {
        return null;
    }
    
    public final void setPayDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayProduct() {
        return null;
    }
    
    public final void setPayProduct(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayType() {
        return null;
    }
    
    public final void setPayType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getPayQuantity() {
        return 0;
    }
    
    public final void setPayQuantity(int p0) {
    }
    
    public final float getTotalPay() {
        return 0.0F;
    }
    
    public final void setTotalPay(float p0) {
    }
    
    public final float getPaidPay() {
        return 0.0F;
    }
    
    public final void setPaidPay(float p0) {
    }
    
    public final float getOwingPay() {
        return 0.0F;
    }
    
    public final void setOwingPay(float p0) {
    }
    
    public Payment_Entity() {
        super();
    }
}