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
public final class waterDAO_Impl implements waterDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Water_Entity> __insertionAdapterOfWater_Entity;

  public waterDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWater_Entity = new EntityInsertionAdapter<Water_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Water_Entity` (`waterid`,`wdate`,`level`,`reason`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Water_Entity value) {
        stmt.bindLong(1, value.getWaterid());
        if (value.getWdate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWdate());
        }
        if (value.getLevel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLevel());
        }
        if (value.getReason() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReason());
        }
      }
    };
  }

  @Override
  public void saveWaterTask(final Water_Entity task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWater_Entity.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Water_Entity> viewWater() {
    final String _sql = "select * from Water_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWaterid = CursorUtil.getColumnIndexOrThrow(_cursor, "waterid");
      final int _cursorIndexOfWdate = CursorUtil.getColumnIndexOrThrow(_cursor, "wdate");
      final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final List<Water_Entity> _result = new ArrayList<Water_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Water_Entity _item;
        _item = new Water_Entity();
        final int _tmpWaterid;
        _tmpWaterid = _cursor.getInt(_cursorIndexOfWaterid);
        _item.setWaterid(_tmpWaterid);
        final String _tmpWdate;
        _tmpWdate = _cursor.getString(_cursorIndexOfWdate);
        _item.setWdate(_tmpWdate);
        final String _tmpLevel;
        _tmpLevel = _cursor.getString(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
        final String _tmpReason;
        _tmpReason = _cursor.getString(_cursorIndexOfReason);
        _item.setReason(_tmpReason);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
