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
public final class creditorsDOA_Impl implements creditorsDOA {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Creditors_Entity> __insertionAdapterOfCreditors_Entity;

  private final EntityDeletionOrUpdateAdapter<Creditors_Entity> __updateAdapterOfCreditors_Entity;

  public creditorsDOA_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCreditors_Entity = new EntityInsertionAdapter<Creditors_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Creditors_Entity` (`credId`,`credNames`,`credDate`,`owingCred`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Creditors_Entity value) {
        stmt.bindLong(1, value.getCredId());
        if (value.getCredNames() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCredNames());
        }
        if (value.getCredDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCredDate());
        }
        stmt.bindDouble(4, value.getOwingCred());
      }
    };
    this.__updateAdapterOfCreditors_Entity = new EntityDeletionOrUpdateAdapter<Creditors_Entity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Creditors_Entity` SET `credId` = ?,`credNames` = ?,`credDate` = ?,`owingCred` = ? WHERE `credId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Creditors_Entity value) {
        stmt.bindLong(1, value.getCredId());
        if (value.getCredNames() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCredNames());
        }
        if (value.getCredDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCredDate());
        }
        stmt.bindDouble(4, value.getOwingCred());
        stmt.bindLong(5, value.getCredId());
      }
    };
  }

  @Override
  public void addCred(final Creditors_Entity stock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCreditors_Entity.insert(stock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCred(final Creditors_Entity debt) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCreditors_Entity.handle(debt);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Creditors_Entity> viewCred(final String name) {
    final String _sql = "select * from Creditors_entity where credNames = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCredId = CursorUtil.getColumnIndexOrThrow(_cursor, "credId");
      final int _cursorIndexOfCredNames = CursorUtil.getColumnIndexOrThrow(_cursor, "credNames");
      final int _cursorIndexOfCredDate = CursorUtil.getColumnIndexOrThrow(_cursor, "credDate");
      final int _cursorIndexOfOwingCred = CursorUtil.getColumnIndexOrThrow(_cursor, "owingCred");
      final List<Creditors_Entity> _result = new ArrayList<Creditors_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Creditors_Entity _item;
        _item = new Creditors_Entity();
        final int _tmpCredId;
        _tmpCredId = _cursor.getInt(_cursorIndexOfCredId);
        _item.setCredId(_tmpCredId);
        final String _tmpCredNames;
        _tmpCredNames = _cursor.getString(_cursorIndexOfCredNames);
        _item.setCredNames(_tmpCredNames);
        final String _tmpCredDate;
        _tmpCredDate = _cursor.getString(_cursorIndexOfCredDate);
        _item.setCredDate(_tmpCredDate);
        final float _tmpOwingCred;
        _tmpOwingCred = _cursor.getFloat(_cursorIndexOfOwingCred);
        _item.setOwingCred(_tmpOwingCred);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Creditors_Entity> viewCreditors() {
    final String _sql = "select * from Creditors_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCredId = CursorUtil.getColumnIndexOrThrow(_cursor, "credId");
      final int _cursorIndexOfCredNames = CursorUtil.getColumnIndexOrThrow(_cursor, "credNames");
      final int _cursorIndexOfCredDate = CursorUtil.getColumnIndexOrThrow(_cursor, "credDate");
      final int _cursorIndexOfOwingCred = CursorUtil.getColumnIndexOrThrow(_cursor, "owingCred");
      final List<Creditors_Entity> _result = new ArrayList<Creditors_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Creditors_Entity _item;
        _item = new Creditors_Entity();
        final int _tmpCredId;
        _tmpCredId = _cursor.getInt(_cursorIndexOfCredId);
        _item.setCredId(_tmpCredId);
        final String _tmpCredNames;
        _tmpCredNames = _cursor.getString(_cursorIndexOfCredNames);
        _item.setCredNames(_tmpCredNames);
        final String _tmpCredDate;
        _tmpCredDate = _cursor.getString(_cursorIndexOfCredDate);
        _item.setCredDate(_tmpCredDate);
        final float _tmpOwingCred;
        _tmpOwingCred = _cursor.getFloat(_cursorIndexOfOwingCred);
        _item.setOwingCred(_tmpOwingCred);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
