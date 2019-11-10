package com.example.Database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class inventoryDAO_Impl implements inventoryDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Inventory_Entity> __insertionAdapterOfInventory_Entity;

  private final EntityDeletionOrUpdateAdapter<Inventory_Entity> __updateAdapterOfInventory_Entity;

  public inventoryDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInventory_Entity = new EntityInsertionAdapter<Inventory_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Inventory_Entity` (`id`,`item`,`quantity`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Inventory_Entity value) {
        stmt.bindLong(1, value.getId());
        if (value.getItem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItem());
        }
        stmt.bindDouble(3, value.getQty());
      }
    };
    this.__updateAdapterOfInventory_Entity = new EntityDeletionOrUpdateAdapter<Inventory_Entity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Inventory_Entity` SET `id` = ?,`item` = ?,`quantity` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Inventory_Entity value) {
        stmt.bindLong(1, value.getId());
        if (value.getItem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItem());
        }
        stmt.bindDouble(3, value.getQty());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public void addtem(final Inventory_Entity item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInventory_Entity.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addMoreFeed(final Inventory_Entity feed) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfInventory_Entity.handle(feed);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Inventory_Entity> viewFeed() {
    final String _sql = "select * from Inventory_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItem = CursorUtil.getColumnIndexOrThrow(_cursor, "item");
      final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final List<Inventory_Entity> _result = new ArrayList<Inventory_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Inventory_Entity _item;
        _item = new Inventory_Entity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpItem;
        _tmpItem = _cursor.getString(_cursorIndexOfItem);
        _item.setItem(_tmpItem);
        final float _tmpQty;
        _tmpQty = _cursor.getFloat(_cursorIndexOfQty);
        _item.setQty(_tmpQty);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
