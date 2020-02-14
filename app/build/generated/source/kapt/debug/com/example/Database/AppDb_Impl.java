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

  private volatile userDAO _userDAO;

  private volatile birdDAO _birdDAO;

  private volatile debitorsDAO _debitorsDAO;

  private volatile paymentDAO _paymentDAO;

  private volatile creditorsDOA _creditorsDOA;

  private volatile clientsDAO _clientsDAO;

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
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Part_Entity` (`partid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `names` TEXT NOT NULL, `partDate` TEXT, `partProduct` TEXT, `type` TEXT, `partQuantity` INTEGER NOT NULL, `totalP` REAL NOT NULL, `paidPart` REAL NOT NULL, `owingP` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Stock_Entity` (`stockId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `item` TEXT NOT NULL, `quantity` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User_Entity` (`userid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fname` TEXT NOT NULL, `lname` TEXT NOT NULL, `email` TEXT NOT NULL, `username` TEXT NOT NULL, `password` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Bird_Entity` (`birdId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `quantity` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Debitors_Entity` (`debtId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `names` TEXT, `debtDate` TEXT, `owingDebt` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Creditors_Entity` (`credId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `credNames` TEXT, `credDate` TEXT, `owingCred` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Payment_Entity` (`payid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nameS` TEXT NOT NULL, `payDate` TEXT, `payProduct` TEXT, `payType` TEXT, `payQuantity` INTEGER NOT NULL, `totalPay` REAL NOT NULL, `paidPay` REAL NOT NULL, `owingPay` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Client_Entity` (`clientID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nameClient` TEXT, `clientType` TEXT, `address` TEXT, `phone` TEXT, `email` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '15cfc471c86bd9bb42cc03e6428b087b')");
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
        _db.execSQL("DROP TABLE IF EXISTS `User_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Bird_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Debitors_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Creditors_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Payment_Entity`");
        _db.execSQL("DROP TABLE IF EXISTS `Client_Entity`");
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
        _columnsPartEntity.put("totalP", new TableInfo.Column("totalP", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("paidPart", new TableInfo.Column("paidPart", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPartEntity.put("owingP", new TableInfo.Column("owingP", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
        final HashMap<String, TableInfo.Column> _columnsUserEntity = new HashMap<String, TableInfo.Column>(6);
        _columnsUserEntity.put("userid", new TableInfo.Column("userid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserEntity.put("fname", new TableInfo.Column("fname", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserEntity.put("lname", new TableInfo.Column("lname", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserEntity.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserEntity.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserEntity.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserEntity = new TableInfo("User_Entity", _columnsUserEntity, _foreignKeysUserEntity, _indicesUserEntity);
        final TableInfo _existingUserEntity = TableInfo.read(_db, "User_Entity");
        if (! _infoUserEntity.equals(_existingUserEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "User_Entity(com.example.Database.User_Entity).\n"
                  + " Expected:\n" + _infoUserEntity + "\n"
                  + " Found:\n" + _existingUserEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsBirdEntity = new HashMap<String, TableInfo.Column>(2);
        _columnsBirdEntity.put("birdId", new TableInfo.Column("birdId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBirdEntity.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBirdEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBirdEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBirdEntity = new TableInfo("Bird_Entity", _columnsBirdEntity, _foreignKeysBirdEntity, _indicesBirdEntity);
        final TableInfo _existingBirdEntity = TableInfo.read(_db, "Bird_Entity");
        if (! _infoBirdEntity.equals(_existingBirdEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Bird_Entity(com.example.Database.Bird_Entity).\n"
                  + " Expected:\n" + _infoBirdEntity + "\n"
                  + " Found:\n" + _existingBirdEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsDebitorsEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsDebitorsEntity.put("debtId", new TableInfo.Column("debtId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDebitorsEntity.put("names", new TableInfo.Column("names", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDebitorsEntity.put("debtDate", new TableInfo.Column("debtDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDebitorsEntity.put("owingDebt", new TableInfo.Column("owingDebt", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDebitorsEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDebitorsEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDebitorsEntity = new TableInfo("Debitors_Entity", _columnsDebitorsEntity, _foreignKeysDebitorsEntity, _indicesDebitorsEntity);
        final TableInfo _existingDebitorsEntity = TableInfo.read(_db, "Debitors_Entity");
        if (! _infoDebitorsEntity.equals(_existingDebitorsEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Debitors_Entity(com.example.Database.Debitors_Entity).\n"
                  + " Expected:\n" + _infoDebitorsEntity + "\n"
                  + " Found:\n" + _existingDebitorsEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsCreditorsEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsCreditorsEntity.put("credId", new TableInfo.Column("credId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditorsEntity.put("credNames", new TableInfo.Column("credNames", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditorsEntity.put("credDate", new TableInfo.Column("credDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditorsEntity.put("owingCred", new TableInfo.Column("owingCred", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCreditorsEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCreditorsEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCreditorsEntity = new TableInfo("Creditors_Entity", _columnsCreditorsEntity, _foreignKeysCreditorsEntity, _indicesCreditorsEntity);
        final TableInfo _existingCreditorsEntity = TableInfo.read(_db, "Creditors_Entity");
        if (! _infoCreditorsEntity.equals(_existingCreditorsEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Creditors_Entity(com.example.Database.Creditors_Entity).\n"
                  + " Expected:\n" + _infoCreditorsEntity + "\n"
                  + " Found:\n" + _existingCreditorsEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsPaymentEntity = new HashMap<String, TableInfo.Column>(9);
        _columnsPaymentEntity.put("payid", new TableInfo.Column("payid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaymentEntity.put("nameS", new TableInfo.Column("nameS", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaymentEntity.put("payDate", new TableInfo.Column("payDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaymentEntity.put("payProduct", new TableInfo.Column("payProduct", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaymentEntity.put("payType", new TableInfo.Column("payType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaymentEntity.put("payQuantity", new TableInfo.Column("payQuantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaymentEntity.put("totalPay", new TableInfo.Column("totalPay", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaymentEntity.put("paidPay", new TableInfo.Column("paidPay", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaymentEntity.put("owingPay", new TableInfo.Column("owingPay", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPaymentEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPaymentEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPaymentEntity = new TableInfo("Payment_Entity", _columnsPaymentEntity, _foreignKeysPaymentEntity, _indicesPaymentEntity);
        final TableInfo _existingPaymentEntity = TableInfo.read(_db, "Payment_Entity");
        if (! _infoPaymentEntity.equals(_existingPaymentEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Payment_Entity(com.example.Database.Payment_Entity).\n"
                  + " Expected:\n" + _infoPaymentEntity + "\n"
                  + " Found:\n" + _existingPaymentEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsClientEntity = new HashMap<String, TableInfo.Column>(6);
        _columnsClientEntity.put("clientID", new TableInfo.Column("clientID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEntity.put("nameClient", new TableInfo.Column("nameClient", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEntity.put("clientType", new TableInfo.Column("clientType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEntity.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEntity.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEntity.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClientEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClientEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientEntity = new TableInfo("Client_Entity", _columnsClientEntity, _foreignKeysClientEntity, _indicesClientEntity);
        final TableInfo _existingClientEntity = TableInfo.read(_db, "Client_Entity");
        if (! _infoClientEntity.equals(_existingClientEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "Client_Entity(com.example.Database.Client_Entity).\n"
                  + " Expected:\n" + _infoClientEntity + "\n"
                  + " Found:\n" + _existingClientEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "15cfc471c86bd9bb42cc03e6428b087b", "a5ff0970e94da63fd71af8f796d4b023");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "DFU_Entity","Egg_Entity","Inventory_Entity","Water_Entity","Mort_Entity","Health_Entity","Part_Entity","Stock_Entity","User_Entity","Bird_Entity","Debitors_Entity","Creditors_Entity","Payment_Entity","Client_Entity");
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
      _db.execSQL("DELETE FROM `User_Entity`");
      _db.execSQL("DELETE FROM `Bird_Entity`");
      _db.execSQL("DELETE FROM `Debitors_Entity`");
      _db.execSQL("DELETE FROM `Creditors_Entity`");
      _db.execSQL("DELETE FROM `Payment_Entity`");
      _db.execSQL("DELETE FROM `Client_Entity`");
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

  @Override
  public userDAO userTask() {
    if (_userDAO != null) {
      return _userDAO;
    } else {
      synchronized(this) {
        if(_userDAO == null) {
          _userDAO = new userDAO_Impl(this);
        }
        return _userDAO;
      }
    }
  }

  @Override
  public birdDAO birdTask() {
    if (_birdDAO != null) {
      return _birdDAO;
    } else {
      synchronized(this) {
        if(_birdDAO == null) {
          _birdDAO = new birdDAO_Impl(this);
        }
        return _birdDAO;
      }
    }
  }

  @Override
  public debitorsDAO debtTask() {
    if (_debitorsDAO != null) {
      return _debitorsDAO;
    } else {
      synchronized(this) {
        if(_debitorsDAO == null) {
          _debitorsDAO = new debitorsDAO_Impl(this);
        }
        return _debitorsDAO;
      }
    }
  }

  @Override
  public paymentDAO payTask() {
    if (_paymentDAO != null) {
      return _paymentDAO;
    } else {
      synchronized(this) {
        if(_paymentDAO == null) {
          _paymentDAO = new paymentDAO_Impl(this);
        }
        return _paymentDAO;
      }
    }
  }

  @Override
  public creditorsDOA credTask() {
    if (_creditorsDOA != null) {
      return _creditorsDOA;
    } else {
      synchronized(this) {
        if(_creditorsDOA == null) {
          _creditorsDOA = new creditorsDOA_Impl(this);
        }
        return _creditorsDOA;
      }
    }
  }

  @Override
  public clientsDAO clientTask() {
    if (_clientsDAO != null) {
      return _clientsDAO;
    } else {
      synchronized(this) {
        if(_clientsDAO == null) {
          _clientsDAO = new clientsDAO_Impl(this);
        }
        return _clientsDAO;
      }
    }
  }
}
