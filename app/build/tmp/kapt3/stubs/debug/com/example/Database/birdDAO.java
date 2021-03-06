package com.example.Database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/example/Database/birdDAO;", "", "addBird", "", "stock", "Lcom/example/Database/Bird_Entity;", "addMoreBird", "bird", "viewBird", "", "app_debug"})
public abstract interface birdDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Bird_Entity where birdId is 1")
    public abstract java.util.List<com.example.Database.Bird_Entity> viewBird();
    
    @androidx.room.Update()
    public abstract void addMoreBird(@org.jetbrains.annotations.NotNull()
    com.example.Database.Bird_Entity bird);
    
    @androidx.room.Insert()
    public abstract void addBird(@org.jetbrains.annotations.NotNull()
    com.example.Database.Bird_Entity stock);
}