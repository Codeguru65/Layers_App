package com.example.Database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDb_Impl extends AppDb {
  private volatile feedDAO _feedDAO;

  private volatile eggDAO _eggDAO;

  private volatile inventoryDAO _inventoryDAO;

  private volatile waterDAO _waterDAO;

  private volatile mortDAO _mortDAO;

  private volatile healthDAO _healthDAO;

  private volatile partpayDAO _partpayDAO;

  private volatile stockDAO _stockDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DFU_Entity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT NOT NULL, `feed_type` TEXT NOT NULL, `quantity` REAL NOT NULL, `sync_status` INTEGER NOT NULL, `openning_feed` REAL NOT NULL, `clossing_feed` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Egg_Entity` (`eggid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT, `size` TEXT, `quality` TEXT, `picked` INTEGER NOT NULL, `broken` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Inventory_Entity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `item` TEXT NOT NULL, `quantity` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Water_Entity` (`waterid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `wdate` TEXT, `level` TEXT, `reason` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Mort_Entity` (`mortid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mdate` TEXT, `mortNum` INTEGER NOT NULL, `mcause` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Health_Entity` (`healthid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `hdate` TEXT NOT NULL, `healthS` TEXT NOT NULL, `hcause` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Part_Entity` (`partid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `names` TEXT NOT NULL, `partDate` TEXT, `partProduct` TEXT, `type` TEXT, `partQuantity` INTEGER NOT NULL, `totalP` INTEGER NOT NULL, `paidPart` INTEGER NOT NULL, `owingP` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Stock_Entity` (`stockId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `item` TEXT NOT NULL, `quantity` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8ee997ea2506a1037fa48f50051efcc4')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `DFU_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Egg_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Inventory_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Water_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Mort_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Health_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Part_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Stock_Entity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsDFUEntity = new HashMap<String, TableInfo.Column>(7);
        _columnsDFUEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDFUEntity.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDFUEntity.put("feed_type", new TableInfo.Column("feed_type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDFUEntity.put("quantity", new TableInfo.Column("quantity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDFUEntity.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDFUEntity.put("openning_feed", new TableInfo.Column("openning_feed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDFUEntity.put("clossing_feed", new TableInfo.Column("clossing_feed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDFUEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDFUEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDFUEntity = new TableInfo("DFU_Entity", _columnsDFUEntity, _foreignKeysDFUEntity, _indicesDFUEntity);
        final TableInfo _existingDFUEntity = TableInfo.read(_db, "DFU_Entity");
        if (! _infoDFUEntity.equals(_existingDFUEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "DFU_Entity(com.example.Database.DFU_Entity).\n"
                  + " Expected:\n" + _infoDFUEntity + "\n"
                  + " Found:\n" + _existingDFUEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsEggEntity = new HashMap<String, TableInfo.Column>(6);
        _columnsEggEntity.put("eggid", new TableInfo.Column("eggid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEggEntity.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEggEntity.put("size", new TableInfo.Column("size", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEggEntity.put("quality", new TableInfo.Column("quality", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEggEntity.put("picked", new TableInfo.Column("picked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEggEntity.put("broken", new TableInfo.Column("broken", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEggEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEggEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEggEntity = new TableInfo("Egg_Entity", _columnsEggEntity, _foreignKeysEggEntity, _indicesEggEntity);
        final TableInfo _existingEggEntity = TableInfo.read(_db, "Egg_Entity");
        if (! _infoEggEntity.equals(_existingEggEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Egg_Entity(com.example.Database.Egg_Entity).\n"
                  + " Expected:\n" + _infoEggEntity + "\n"
                  + " Found:\n" + _existingEggEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsInventoryEntity = new HashMap<String, TableInfo.Column>(3);
        _columnsInventoryEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryEntity.put("item", new TableInfo.Column("item", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryEntity.put("quantity", new TableInfo.Column("quantity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInventoryEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInventoryEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInventoryEntity = new TableInfo("Inventory_Entity", _columnsInventoryEntity, _foreignKeysInventoryEntity, _indicesInventoryEntity);
        final TableInfo _existingInventoryEntity = TableInfo.read(_db, "Inventory_Entity");
        if (! _infoInventoryEntity.equals(_existingInventoryEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Inventory_Entity(com.example.Database.Inventory_Entity).\n"
                  + " Expected:\n" + _infoInventoryEntity + "\n"
                  + " Found:\n" + _existingInventoryEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsWaterEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsWaterEntity.put("waterid", new TableInfo.Column("waterid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterEntity.put("wdate", new TableInfo.Column("wdate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterEntity.put("level", new TableInfo.Column("level", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterEntity.put("reason", new TableInfo.Column("reason", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWaterEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWaterEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWaterEntity = new TableInfo("Water_Entity", _columnsWaterEntity, _foreignKeysWaterEntity, _indicesWaterEntity);
        final TableInfo _existingWaterEntity = TableInfo.read(_db, "Water_Entity");
        if (! _infoWaterEntity.equals(_existingWaterEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Water_Entity(com.example.Database.Water_Entity).\n"
                  + " Expected:\n" + _infoWaterEntity + "\n"
                  + " Found:\n" + _existingWaterEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsMortEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsMortEntity.put("mortid", new TableInfo.Column("mortid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMortEntity.put("mdate", new TableInfo.Column("mdate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMortEntity.put("mortNum", new TableInfo.Column("mortNum", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMortEntity.put("mcause", new TableInfo.Column("mcause", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMortEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMortEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMortEntity = new TableInfo("Mort_Entity", _columnsMortEntity, _foreignKeysMortEntity, _indicesMortEntity);
        final TableInfo _existingMortEntity = TableInfo.read(_db, "Mort_Entity");
        if (! _infoMortEntity.equals(_existingMortEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Mort_Entity(com.example.Database.Mort_Entity).\n"
                  + " Expected:\n" + _infoMortEntity + "\n"
                  + " Found:\n" + _existingMortEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsHealthEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsHealthEntity.put("healthid", new TableInfo.Column("healthid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthEntity.put("hdate", new TableInfo.Column("hdate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthEntity.put("healthS", new TableInfo.Column("healthS", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthEntity.put("hcause", new TableInfo.Column("hcause", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHealthEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHealthEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHealthEntity = new TableInfo("Health_Entity", _columnsHealthEntity, _foreignKeysHealthEntity, _indicesHealthEntity);
        final TableInfo _existingHealthEntity = TableInfo.read(_db, "Health_Entity");
        if (! _infoHealthEntity.equals(_existingHealthEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Health_Entity(com.example.Database.Health_Entity).\n"
                  + " Expected:\n" + _infoHealthEntity + "\n"
                  + " Found:\n" + _existingHealthEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsPartEntity = new HashMap<String, TableInfo.Column>(9);
        _columnsPartEntity.put("partid", new TableInfo.Column("partid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("names", new TableInfo.Column("names", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("partDate", new TableInfo.Column("partDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("partProduct", new TableInfo.Column("partProduct", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("partQuantity", new TableInfo.Column("partQuantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("totalP", new TableInfo.Column("totalP", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("paidPart", new TableInfo.Column("paidPart", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("owingP", new TableInfo.Column("owingP", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPartEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPartEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPartEntity = new TableInfo("Part_Entity", _columnsPartEntity, _foreignKeysPartEntity, _indicesPartEntity);
        final TableInfo _existingPartEntity = TableInfo.read(_db, "Part_Entity");
        if (! _infoPartEntity.equals(_existingPartEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Part_Entity(com.example.Database.Part_Entity).\n"
                  + " Expected:\n" + _infoPartEntity + "\n"
                  + " Found:\n" + _existingPartEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsStockEntity = new HashMap<String, TableInfo.Column>(3);
        _columnsStockEntity.put("stockId", new TableInfo.Column("stockId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStockEntity.put("item", new TableInfo.Column("item", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStockEntity.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStockEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStockEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStockEntity = new TableInfo("Stock_Entity", _columnsStockEntity, _foreignKeysStockEntity, _indicesStockEntity);
        final TableInfo _existingStockEntity = TableInfo.read(_db, "Stock_Entity");
        if (! _infoStockEntity.equals(_existingStockEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Stock_Entity(com.example.Database.Stock_Entity).\n"
                  + " Expected:\n" + _infoStockEntity + "\n"
                  + " Found:\n" + _existingStockEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8ee997ea2506a1037fa48f50051efcc4", "e6786b171cc685995a9614c30803dc6f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "DFU_Entity","Egg_Entity","Inventory_Entity","Water_Entity","Mort_Entity","Health_Entity","Part_Entity","Stock_Entity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `DFU_Entity`");
      _db.execSQL("DELETE FROM `Egg_Entity`");
      _db.execSQL("DELETE FROM `Inventory_Entity`");
      _db.execSQL("DELETE FROM `Water_Entity`");
      _db.execSQL("DELETE FROM `Mort_Entity`");
      _db.execSQL("DELETE FROM `Health_Entity`");
      _db.execSQL("DELETE FROM `Part_Entity`");
      _db.execSQL("DELETE FROM `Stock_Entity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public feedDAO feedTaskDAO() {
    if (_feedDAO != null) {
      return _feedDAO;
    } else {
      synchronized(this) {
        if(_feedDAO == null) {
          _feedDAO = new feedDAO_Impl(this);
        }
        return _feedDAO;
      }
    }
  }

  @Override
  public eggDAO eggTaskDAO() {
    if (_eggDAO != null) {
      return _eggDAO;
    } else {
      synchronized(this) {
        if(_eggDAO == null) {
          _eggDAO = new eggDAO_Impl(this);
        }
        return _eggDAO;
      }
    }
  }

  @Override
  public inventoryDAO inventoryDAO() {
    if (_inventoryDAO != null) {
      return _inventoryDAO;
    } else {
      synchronized(this) {
        if(_inventoryDAO == null) {
          _inventoryDAO = new inventoryDAO_Impl(this);
        }
        return _inventoryDAO;
      }
    }
  }

  @Override
  public waterDAO waterTask() {
    if (_waterDAO != null) {
      return _waterDAO;
    } else {
      synchronized(this) {
        if(_waterDAO == null) {
          _waterDAO = new waterDAO_Impl(this);
        }
        return _waterDAO;
      }
    }
  }

  @Override
  public mortDAO mortTask() {
    if (_mortDAO != null) {
      return _mortDAO;
    } else {
      synchronized(this) {
        if(_mortDAO == null) {
          _mortDAO = new mortDAO_Impl(this);
        }
        return _mortDAO;
      }
    }
  }

  @Override
  public healthDAO healthTask() {
    if (_healthDAO != null) {
      return _healthDAO;
    } else {
      synchronized(this) {
        if(_healthDAO == null) {
          _healthDAO = new healthDAO_Impl(this);
        }
        return _healthDAO;
      }
    }
  }

  @Override
  public partpayDAO partTask() {
    if (_partpayDAO != null) {
      return _partpayDAO;
    } else {
      synchronized(this) {
        if(_partpayDAO == null) {
          _partpayDAO = new partpayDAO_Impl(this);
        }
        return _partpayDAO;
      }
    }
  }

  @Override
  public stockDAO stockTask() {
    if (_stockDAO != null) {
      return _stockDAO;
    } else {
      synchronized(this) {
        if(_stockDAO == null) {
          _stockDAO = new stockDAO_Impl(this);
        }
        return _stockDAO;
      }
    }
  }
}
