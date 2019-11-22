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
public final class healthDAO_Impl implements healthDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Health_Entity> __insertionAdapterOfHealth_Entity;

  public healthDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHealth_Entity = new EntityInsertionAdapter<Health_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Health_Entity` (`healthid`,`hdate`,`healthS`,`hcause`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Health_Entity value) {
        stmt.bindLong(1, value.getHealthid());
        if (value.getHdate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getHdate());
        }
        if (value.getHealthS() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getHealthS());
        }
        if (value.getHcause() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getHcause());
        }
      }
    };
  }

  @Override
  public void saveHealthTask(final Health_Entity task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfHealth_Entity.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Health_Entity> viewHealth() {
    final String _sql = "select * from Health_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfHealthid = CursorUtil.getColumnIndexOrThrow(_cursor, "healthid");
      final int _cursorIndexOfHdate = CursorUtil.getColumnIndexOrThrow(_cursor, "hdate");
      final int _cursorIndexOfHealthS = CursorUtil.getColumnIndexOrThrow(_cursor, "healthS");
      final int _cursorIndexOfHcause = CursorUtil.getColumnIndexOrThrow(_cursor, "hcause");
      final List<Health_Entity> _result = new ArrayList<Health_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Health_Entity _item;
        _item = new Health_Entity();
        final int _tmpHealthid;
        _tmpHealthid = _cursor.getInt(_cursorIndexOfHealthid);
        _item.setHealthid(_tmpHealthid);
        final String _tmpHdate;
        _tmpHdate = _cursor.getString(_cursorIndexOfHdate);
        _item.setHdate(_tmpHdate);
        final String _tmpHealthS;
        _tmpHealthS = _cursor.getString(_cursorIndexOfHealthS);
        _item.setHealthS(_tmpHealthS);
        final String _tmpHcause;
        _tmpHcause = _cursor.getString(_cursorIndexOfHcause);
        _item.setHcause(_tmpHcause);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
