package com.example.Database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\n\u001a\u00020\u000bH\'\u00a8\u0006\f"}, d2 = {"Lcom/example/Database/clientsDAO;", "", "addClient", "", "client", "Lcom/example/Database/Client_Entity;", "updateClient", "veiwClient", "", "viewSp", "type", "", "app_debug"})
public abstract interface clientsDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Client_Entity")
    public abstract java.util.List<com.example.Database.Client_Entity> veiwClient();
    
    @androidx.room.Insert()
    public abstract void addClient(@org.jetbrains.annotations.NotNull()
    com.example.Database.Client_Entity client);
    
    @androidx.room.Update()
    public abstract void updateClient(@org.jetbrains.annotations.NotNull()
    com.example.Database.Client_Entity client);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Client_Entity where clientType is :type")
    public abstract java.util.List<com.example.Database.Client_Entity> viewSp(@org.jetbrains.annotations.NotNull()
    java.lang.String type);
}