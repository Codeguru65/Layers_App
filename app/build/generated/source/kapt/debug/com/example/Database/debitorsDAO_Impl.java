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
public final class debitorsDAO_Impl implements debitorsDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Debitors_Entity> __insertionAdapterOfDebitors_Entity;

  private final EntityDeletionOrUpdateAdapter<Debitors_Entity> __updateAdapterOfDebitors_Entity;

  public debitorsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDebitors_Entity = new EntityInsertionAdapter<Debitors_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Debitors_Entity` (`debtId`,`names`,`debtDate`,`owingDebt`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Debitors_Entity value) {
        stmt.bindLong(1, value.getDebtId());
        if (value.getNames() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNames());
        }
        if (value.getDebtDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDebtDate());
        }
        stmt.bindDouble(4, value.getOwingDebt());
      }
    };
    this.__updateAdapterOfDebitors_Entity = new EntityDeletionOrUpdateAdapter<Debitors_Entity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Debitors_Entity` SET `debtId` = ?,`names` = ?,`debtDate` = ?,`owingDebt` = ? WHERE `debtId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Debitors_Entity value) {
        stmt.bindLong(1, value.getDebtId());
        if (value.getNames() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNames());
        }
        if (value.getDebtDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDebtDate());
        }
        stmt.bindDouble(4, value.getOwingDebt());
        stmt.bindLong(5, value.getDebtId());
      }
    };
  }

  @Override
  public void addDebt(final Debitors_Entity stock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDebitors_Entity.insert(stock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateDebt(final Debitors_Entity debt) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfDebitors_Entity.handle(debt);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Debitors_Entity> viewDebt(final String name) {
    final String _sql = "select * from Debitors_Entity where names is ?";
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
      final int _cursorIndexOfDebtId = CursorUtil.getColumnIndexOrThrow(_cursor, "debtId");
      final int _cursorIndexOfNames = CursorUtil.getColumnIndexOrThrow(_cursor, "names");
      final int _cursorIndexOfDebtDate = CursorUtil.getColumnIndexOrThrow(_cursor, "debtDate");
      final int _cursorIndexOfOwingDebt = CursorUtil.getColumnIndexOrThrow(_cursor, "owingDebt");
      final List<Debitors_Entity> _result = new ArrayList<Debitors_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Debitors_Entity _item;
        _item = new Debitors_Entity();
        final int _tmpDebtId;
        _tmpDebtId = _cursor.getInt(_cursorIndexOfDebtId);
        _item.setDebtId(_tmpDebtId);
        final String _tmpNames;
        _tmpNames = _cursor.getString(_cursorIndexOfNames);
        _item.setNames(_tmpNames);
        final String _tmpDebtDate;
        _tmpDebtDate = _cursor.getString(_cursorIndexOfDebtDate);
        _item.setDebtDate(_tmpDebtDate);
        final float _tmpOwingDebt;
        _tmpOwingDebt = _cursor.getFloat(_cursorIndexOfOwingDebt);
        _item.setOwingDebt(_tmpOwingDebt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Debitors_Entity> viewDebitors() {
    final String _sql = "select * from Debitors_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfDebtId = CursorUtil.getColumnIndexOrThrow(_cursor, "debtId");
      final int _cursorIndexOfNames = CursorUtil.getColumnIndexOrThrow(_cursor, "names");
      final int _cursorIndexOfDebtDate = CursorUtil.getColumnIndexOrThrow(_cursor, "debtDate");
      final int _cursorIndexOfOwingDebt = CursorUtil.getColumnIndexOrThrow(_cursor, "owingDebt");
      final List<Debitors_Entity> _result = new ArrayList<Debitors_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Debitors_Entity _item;
        _item = new Debitors_Entity();
        final int _tmpDebtId;
        _tmpDebtId = _cursor.getInt(_cursorIndexOfDebtId);
        _item.setDebtId(_tmpDebtId);
        final String _tmpNames;
        _tmpNames = _cursor.getString(_cursorIndexOfNames);
        _item.setNames(_tmpNames);
        final String _tmpDebtDate;
        _tmpDebtDate = _cursor.getString(_cursorIndexOfDebtDate);
        _item.setDebtDate(_tmpDebtDate);
        final float _tmpOwingDebt;
        _tmpOwingDebt = _cursor.getFloat(_cursorIndexOfOwingDebt);
        _item.setOwingDebt(_tmpOwingDebt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
