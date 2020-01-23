package com.example.Database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u000bH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'\u00a8\u0006\r"}, d2 = {"Lcom/example/Database/creditorsDOA;", "", "addCred", "", "stock", "Lcom/example/Database/Creditors_Entity;", "updateCred", "debt", "viewCred", "", "name", "", "viewCreditors", "app_debug"})
public abstract interface creditorsDOA {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Creditors_entity where credNames = :name ")
    public abstract java.util.List<com.example.Database.Creditors_Entity> viewCred(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Creditors_Entity")
    public abstract java.util.List<com.example.Database.Creditors_Entity> viewCreditors();
    
    @androidx.room.Update()
    public abstract void updateCred(@org.jetbrains.annotations.NotNull()
    com.example.Database.Creditors_Entity debt);
    
    @androidx.room.Insert()
    public abstract void addCred(@org.jetbrains.annotations.NotNull()
    com.example.Database.Creditors_Entity stock);
}