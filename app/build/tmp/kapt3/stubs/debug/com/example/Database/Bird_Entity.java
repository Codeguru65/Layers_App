package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/example/Database/Bird_Entity;", "", "()V", "birdId", "", "getBirdId", "()I", "setBirdId", "(I)V", "birdQty", "getBirdQty", "setBirdQty", "app_debug"})
public final class Bird_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int birdId;
    @androidx.room.ColumnInfo(name = "quantity")
    private int birdQty;
    
    public final int getBirdId() {
        return 0;
    }
    
    public final void setBirdId(int p0) {
    }
    
    public final int getBirdQty() {
        return 0;
    }
    
    public final void setBirdQty(int p0) {
    }
    
    public Bird_Entity() {
        super();
    }
}