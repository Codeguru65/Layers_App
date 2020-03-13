package com.example.Database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0011\u001a\u00020\tH\'\u00a8\u0006\u0012"}, d2 = {"Lcom/example/Database/clientsDAO;", "", "addClient", "", "client", "Lcom/example/Database/Client_Entity;", "fil", "", "phrase", "", "updateClient", "veiwClient", "viewB", "viewBal", "viewClient", "viewD", "viewSp", "type", "app_debug"})
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
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Client_Entity where nameClient like :phrase")
    public abstract java.util.List<com.example.Database.Client_Entity> fil(@org.jetbrains.annotations.Nullable()
    java.lang.String phrase);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Client_Entity where owing > 0.0 ")
    public abstract java.util.List<com.example.Database.Client_Entity> viewBal();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Client_Entity where owed > 0.0 ")
    public abstract java.util.List<com.example.Database.Client_Entity> viewB();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Client_Entity where nameClient is :phrase")
    public abstract java.util.List<com.example.Database.Client_Entity> viewD(@org.jetbrains.annotations.NotNull()
    java.lang.String phrase);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from Client_Entity")
    public abstract java.util.List<com.example.Database.Client_Entity> viewClient();
}