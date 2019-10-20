package com.example.dailythings;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/example/dailythings/FeedEntity;", "", "()V", "date", "", "getDate", "()I", "setDate", "(I)V", "feed_type20kg", "getFeed_type20kg", "setFeed_type20kg", "feed_type50kg", "getFeed_type50kg", "setFeed_type50kg", "feed_type5kg", "getFeed_type5kg", "setFeed_type5kg", "app_debug"})
public final class FeedEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int date;
    @androidx.room.ColumnInfo()
    private int feed_type5kg;
    @androidx.room.ColumnInfo()
    private int feed_type20kg;
    @androidx.room.ColumnInfo()
    private int feed_type50kg;
    
    public final int getDate() {
        return 0;
    }
    
    public final void setDate(int p0) {
    }
    
    public final int getFeed_type5kg() {
        return 0;
    }
    
    public final void setFeed_type5kg(int p0) {
    }
    
    public final int getFeed_type20kg() {
        return 0;
    }
    
    public final void setFeed_type20kg(int p0) {
    }
    
    public final int getFeed_type50kg() {
        return 0;
    }
    
    public final void setFeed_type50kg(int p0) {
    }
    
    public FeedEntity() {
        super();
    }
}