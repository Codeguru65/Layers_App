package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/example/Database/Stock_Entity;", "", "()V", "stockId", "", "getStockId", "()I", "setStockId", "(I)V", "stockItem", "", "getStockItem", "()Ljava/lang/String;", "setStockItem", "(Ljava/lang/String;)V", "stockQty", "getStockQty", "setStockQty", "app_debug"})
public final class Stock_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int stockId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "item")
    private java.lang.String stockItem;
    @androidx.room.ColumnInfo(name = "quantity")
    private int stockQty;
    
    public final int getStockId() {
        return 0;
    }
    
    public final void setStockId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStockItem() {
        return null;
    }
    
    public final void setStockItem(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getStockQty() {
        return 0;
    }
    
    public final void setStockQty(int p0) {
    }
    
    public Stock_Entity() {
        super();
    }
}