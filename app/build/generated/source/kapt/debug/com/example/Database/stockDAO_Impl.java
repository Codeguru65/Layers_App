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
public final class stockDAO_Impl implements stockDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Stock_Entity> __insertionAdapterOfStock_Entity;

  private final EntityDeletionOrUpdateAdapter<Stock_Entity> __updateAdapterOfStock_Entity;

  public stockDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStock_Entity = new EntityInsertionAdapter<Stock_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Stock_Entity` (`stockId`,`item`,`quantity`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Stock_Entity value) {
        stmt.bindLong(1, value.getStockId());
        if (value.getStockItem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStockItem());
        }
        stmt.bindLong(3, value.getStockQty());
      }
    };
    this.__updateAdapterOfStock_Entity = new EntityDeletionOrUpdateAdapter<Stock_Entity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Stock_Entity` SET `stockId` = ?,`item` = ?,`quantity` = ? WHERE `stockId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Stock_Entity value) {
        stmt.bindLong(1, value.getStockId());
        if (value.getStockItem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStockItem());
        }
        stmt.bindLong(3, value.getStockQty());
        stmt.bindLong(4, value.getStockId());
      }
    };
  }

  @Override
  public void addEggs(final Stock_Entity stock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStock_Entity.insert(stock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addMoreEggs(final Stock_Entity stock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfStock_Entity.handle(stock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Stock_Entity> viewStock() {
    final String _sql = "select * from Stock_Entity where stockId is 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStockId = CursorUtil.getColumnIndexOrThrow(_cursor, "stockId");
      final int _cursorIndexOfStockItem = CursorUtil.getColumnIndexOrThrow(_cursor, "item");
      final int _cursorIndexOfStockQty = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final List<Stock_Entity> _result = new ArrayList<Stock_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Stock_Entity _item;
        _item = new Stock_Entity();
        final int _tmpStockId;
        _tmpStockId = _cursor.getInt(_cursorIndexOfStockId);
        _item.setStockId(_tmpStockId);
        final String _tmpStockItem;
        _tmpStockItem = _cursor.getString(_cursorIndexOfStockItem);
        _item.setStockItem(_tmpStockItem);
        final int _tmpStockQty;
        _tmpStockQty = _cursor.getInt(_cursorIndexOfStockQty);
        _item.setStockQty(_tmpStockQty);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
