package com.example.Database;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006$"}, d2 = {"Lcom/example/Database/DFU_Entity;", "", "()V", "clossingFeed", "", "getClossingFeed", "()F", "setClossingFeed", "(F)V", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "feedType", "getFeedType", "setFeedType", "id", "", "getId", "()I", "setId", "(I)V", "openningFeed", "getOpenningFeed", "setOpenningFeed", "quatity", "getQuatity", "setQuatity", "syncStatus", "", "getSyncStatus", "()Z", "setSyncStatus", "(Z)V", "app_debug"})
public final class DFU_Entity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "date")
    private java.lang.String date;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "feed_type")
    private java.lang.String feedType;
    @androidx.room.ColumnInfo(name = "quantity")
    private float quatity;
    @androidx.room.ColumnInfo(name = "sync_status")
    private boolean syncStatus;
    @androidx.room.ColumnInfo(name = "openning_feed")
    private float openningFeed;
    @androidx.room.ColumnInfo(name = "clossing_feed")
    private float clossingFeed;
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFeedType() {
        return null;
    }
    
    public final void setFeedType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final float getQuatity() {
        return 0.0F;
    }
    
    public final void setQuatity(float p0) {
    }
    
    public final boolean getSyncStatus() {
        return false;
    }
    
    public final void setSyncStatus(boolean p0) {
    }
    
    public final float getOpenningFeed() {
        return 0.0F;
    }
    
    public final void setOpenningFeed(float p0) {
    }
    
    public final float getClossingFeed() {
        return 0.0F;
    }
    
    public final void setClossingFeed(float p0) {
    }
    
    public DFU_Entity() {
        super();
    }
}