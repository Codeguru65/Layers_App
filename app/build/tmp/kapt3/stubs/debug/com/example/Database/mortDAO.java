package com.example.Database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'\u00a8\u0006\b"}, d2 = {"Lcom/example/Database/mortDAO;", "", "saveMortTask", "", "task", "Lcom/example/Database/Mort_Entity;", "viewMort", "", "app_debug"})
public abstract interface mortDAO {
    
    @androidx.room.Insert()
    public abstract void saveMortTask(@org.jetbrains.annotations.NotNull()
    com.example.Database.Mort_Entity task);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Mort_Entity")
    public abstract java.util.List<com.example.Database.Mort_Entity> viewMort();
}