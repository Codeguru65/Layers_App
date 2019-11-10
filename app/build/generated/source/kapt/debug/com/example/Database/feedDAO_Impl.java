package com.example.Database;

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
public final class feedDAO_Impl implements feedDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DFU_Entity> __insertionAdapterOfDFU_Entity;

  public feedDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDFU_Entity = new EntityInsertionAdapter<DFU_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `DFU_Entity` (`id`,`date`,`feed_type`,`quantity`,`sync_status`,`openning_feed`,`clossing_feed`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DFU_Entity value) {
        stmt.bindLong(1, value.getId());
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        if (value.getFeedType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFeedType());
        }
        stmt.bindDouble(4, value.getQuatity());
        final int _tmp;
        _tmp = value.getSyncStatus() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindDouble(6, value.getOpenningFeed());
        stmt.bindDouble(7, value.getClossingFeed());
      }
    };
  }

  @Override
  public void saveFeedTask(final DFU_Entity task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDFU_Entity.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<DFU_Entity> viewFeed() {
    final String _sql = "select * from DFU_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfFeedType = CursorUtil.getColumnIndexOrThrow(_cursor, "feed_type");
      final int _cursorIndexOfQuatity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfOpenningFeed = CursorUtil.getColumnIndexOrThrow(_cursor, "openning_feed");
      final int _cursorIndexOfClossingFeed = CursorUtil.getColumnIndexOrThrow(_cursor, "clossing_feed");
      final List<DFU_Entity> _result = new ArrayList<DFU_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DFU_Entity _item;
        _item = new DFU_Entity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _item.setDate(_tmpDate);
        final String _tmpFeedType;
        _tmpFeedType = _cursor.getString(_cursorIndexOfFeedType);
        _item.setFeedType(_tmpFeedType);
        final float _tmpQuatity;
        _tmpQuatity = _cursor.getFloat(_cursorIndexOfQuatity);
        _item.setQuatity(_tmpQuatity);
        final boolean _tmpSyncStatus;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfSyncStatus);
        _tmpSyncStatus = _tmp != 0;
        _item.setSyncStatus(_tmpSyncStatus);
        final float _tmpOpenningFeed;
        _tmpOpenningFeed = _cursor.getFloat(_cursorIndexOfOpenningFeed);
        _item.setOpenningFeed(_tmpOpenningFeed);
        final float _tmpClossingFeed;
        _tmpClossingFeed = _cursor.getFloat(_cursorIndexOfClossingFeed);
        _item.setClossingFeed(_tmpClossingFeed);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
