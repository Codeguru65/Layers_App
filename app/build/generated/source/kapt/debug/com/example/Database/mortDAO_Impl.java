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
public final class mortDAO_Impl implements mortDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Mort_Entity> __insertionAdapterOfMort_Entity;

  public mortDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMort_Entity = new EntityInsertionAdapter<Mort_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Mort_Entity` (`mortid`,`mdate`,`mortNum`,`mcause`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Mort_Entity value) {
        stmt.bindLong(1, value.getMortid());
        if (value.getMdate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMdate());
        }
        stmt.bindLong(3, value.getMortNum());
        if (value.getMcause() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMcause());
        }
      }
    };
  }

  @Override
  public void saveMortTask(final Mort_Entity task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMort_Entity.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Mort_Entity> viewMort() {
    final String _sql = "select * from Mort_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMortid = CursorUtil.getColumnIndexOrThrow(_cursor, "mortid");
      final int _cursorIndexOfMdate = CursorUtil.getColumnIndexOrThrow(_cursor, "mdate");
      final int _cursorIndexOfMortNum = CursorUtil.getColumnIndexOrThrow(_cursor, "mortNum");
      final int _cursorIndexOfMcause = CursorUtil.getColumnIndexOrThrow(_cursor, "mcause");
      final List<Mort_Entity> _result = new ArrayList<Mort_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Mort_Entity _item;
        _item = new Mort_Entity();
        final int _tmpMortid;
        _tmpMortid = _cursor.getInt(_cursorIndexOfMortid);
        _item.setMortid(_tmpMortid);
        final String _tmpMdate;
        _tmpMdate = _cursor.getString(_cursorIndexOfMdate);
        _item.setMdate(_tmpMdate);
        final int _tmpMortNum;
        _tmpMortNum = _cursor.getInt(_cursorIndexOfMortNum);
        _item.setMortNum(_tmpMortNum);
        final String _tmpMcause;
        _tmpMcause = _cursor.getString(_cursorIndexOfMcause);
        _item.setMcause(_tmpMcause);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
