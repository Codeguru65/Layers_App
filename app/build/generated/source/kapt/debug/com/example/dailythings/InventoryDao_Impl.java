package com.example.dailythings;

import android.database.Cursor;
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
public final class InventoryDao_Impl implements InventoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InventoryEntity> __insertionAdapterOfInventoryEntity;

  public InventoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInventoryEntity = new EntityInsertionAdapter<InventoryEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `InventoryEntity` (`id`,`feed_type`,`quantity`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InventoryEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getFeed_type() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFeed_type());
        }
        stmt.bindLong(3, value.getQuantity());
      }
    };
  }

  @Override
  public void addItem(final InventoryEntity item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInventoryEntity.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<InventoryEntity> viewInventoty() {
    final String _sql = "select * from inventoryentity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFeedType = CursorUtil.getColumnIndexOrThrow(_cursor, "feed_type");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final List<InventoryEntity> _result = new ArrayList<InventoryEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InventoryEntity _item;
        _item = new InventoryEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpFeed_type;
        _tmpFeed_type = _cursor.getString(_cursorIndexOfFeedType);
        _item.setFeed_type(_tmpFeed_type);
        final int _tmpQuantity;
        _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        _item.setQuantity(_tmpQuantity);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
