package com.example.Database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/Database/userDAO;", "", "addUser", "", "item", "Lcom/example/Database/User_Entity;", "checkUsers", "", "viewUser", "user", "", "app_debug"})
public abstract interface userDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from User_Entity where username = :user or email = :user")
    public abstract com.example.Database.User_Entity viewUser(@org.jetbrains.annotations.NotNull()
    java.lang.String user);
    
    @androidx.room.Insert()
    public abstract void addUser(@org.jetbrains.annotations.NotNull()
    com.example.Database.User_Entity item);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from User_Entity  ")
    public abstract java.util.List<com.example.Database.User_Entity> checkUsers();
}