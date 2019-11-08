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

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DFU_Entity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT, `feedType` TEXT, `quatity` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Egg_Entity` (`eggid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT, `size` TEXT, `quality` TEXT, `picked` INTEGER NOT NULL, `broken` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '39447982506e06f0da0f61a03f7b1de1')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `DFU_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Egg_Entity`");
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
        final HashMap<String, TableInfo.Column> _columnsDFUEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsDFUEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDFUEntity.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDFUEntity.put("feedType", new TableInfo.Column("feedType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDFUEntity.put("quatity", new TableInfo.Column("quatity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "39447982506e06f0da0f61a03f7b1de1", "a7605d9920340c1af1b17636f794e8d1");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "DFU_Entity","Egg_Entity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `DFU_Entity`");
      _db.execSQL("DELETE FROM `Egg_Entity`");
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
}
