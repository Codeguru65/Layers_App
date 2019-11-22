package com.example.Database;

import java.lang.System;

@androidx.room.Database(entities = {com.example.Database.DFU_Entity.class, com.example.Database.Egg_Entity.class, com.example.Database.Inventory_Entity.class, com.example.Database.Water_Entity.class, com.example.Database.Mort_Entity.class, com.example.Database.Health_Entity.class, com.example.Database.Part_Entity.class, com.example.Database.Stock_Entity.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/example/Database/AppDb;", "Landroidx/room/RoomDatabase;", "()V", "eggTaskDAO", "Lcom/example/Database/eggDAO;", "feedTaskDAO", "Lcom/example/Database/feedDAO;", "healthTask", "Lcom/example/Database/healthDAO;", "inventoryDAO", "Lcom/example/Database/inventoryDAO;", "mortTask", "Lcom/example/Database/mortDAO;", "partTask", "Lcom/example/Database/partpayDAO;", "stockTask", "Lcom/example/Database/stockDAO;", "waterTask", "Lcom/example/Database/waterDAO;", "app_debug"})
public abstract class AppDb extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.Database.feedDAO feedTaskDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.Database.eggDAO eggTaskDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.Database.inventoryDAO inventoryDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.Database.waterDAO waterTask();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.Database.mortDAO mortTask();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.Database.healthDAO healthTask();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.Database.partpayDAO partTask();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.Database.stockDAO stockTask();
    
    public AppDb() {
        super();
    }
}