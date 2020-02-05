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
public final class partpayDAO_Impl implements partpayDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Part_Entity> __insertionAdapterOfPart_Entity;

  public partpayDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPart_Entity = new EntityInsertionAdapter<Part_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Part_Entity` (`partid`,`names`,`partDate`,`partProduct`,`type`,`partQuantity`,`totalP`,`paidPart`,`owingP`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Part_Entity value) {
        stmt.bindLong(1, value.getPartid());
        if (value.getNames() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNames());
        }
        if (value.getPartDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPartDate());
        }
        if (value.getPartProduct() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPartProduct());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        stmt.bindLong(6, value.getPartQuantity());
        stmt.bindDouble(7, value.getTotalP());
        stmt.bindDouble(8, value.getPaidPart());
        stmt.bindDouble(9, value.getOwingP());
      }
    };
  }

  @Override
  public void savePartTask(final Part_Entity task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPart_Entity.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Part_Entity> viewPart() {
    final String _sql = "select * from Part_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPartid = CursorUtil.getColumnIndexOrThrow(_cursor, "partid");
      final int _cursorIndexOfNames = CursorUtil.getColumnIndexOrThrow(_cursor, "names");
      final int _cursorIndexOfPartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "partDate");
      final int _cursorIndexOfPartProduct = CursorUtil.getColumnIndexOrThrow(_cursor, "partProduct");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfPartQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "partQuantity");
      final int _cursorIndexOfTotalP = CursorUtil.getColumnIndexOrThrow(_cursor, "totalP");
      final int _cursorIndexOfPaidPart = CursorUtil.getColumnIndexOrThrow(_cursor, "paidPart");
      final int _cursorIndexOfOwingP = CursorUtil.getColumnIndexOrThrow(_cursor, "owingP");
      final List<Part_Entity> _result = new ArrayList<Part_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Part_Entity _item;
        _item = new Part_Entity();
        final int _tmpPartid;
        _tmpPartid = _cursor.getInt(_cursorIndexOfPartid);
        _item.setPartid(_tmpPartid);
        final String _tmpNames;
        _tmpNames = _cursor.getString(_cursorIndexOfNames);
        _item.setNames(_tmpNames);
        final String _tmpPartDate;
        _tmpPartDate = _cursor.getString(_cursorIndexOfPartDate);
        _item.setPartDate(_tmpPartDate);
        final String _tmpPartProduct;
        _tmpPartProduct = _cursor.getString(_cursorIndexOfPartProduct);
        _item.setPartProduct(_tmpPartProduct);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item.setType(_tmpType);
        final int _tmpPartQuantity;
        _tmpPartQuantity = _cursor.getInt(_cursorIndexOfPartQuantity);
        _item.setPartQuantity(_tmpPartQuantity);
        final float _tmpTotalP;
        _tmpTotalP = _cursor.getFloat(_cursorIndexOfTotalP);
        _item.setTotalP(_tmpTotalP);
        final float _tmpPaidPart;
        _tmpPaidPart = _cursor.getFloat(_cursorIndexOfPaidPart);
        _item.setPaidPart(_tmpPaidPart);
        final float _tmpOwingP;
        _tmpOwingP = _cursor.getFloat(_cursorIndexOfOwingP);
        _item.setOwingP(_tmpOwingP);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Part_Entity> viewPartD(final String date) {
    final String _sql = "select * from Part_Entity where partDate = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPartid = CursorUtil.getColumnIndexOrThrow(_cursor, "partid");
      final int _cursorIndexOfNames = CursorUtil.getColumnIndexOrThrow(_cursor, "names");
      final int _cursorIndexOfPartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "partDate");
      final int _cursorIndexOfPartProduct = CursorUtil.getColumnIndexOrThrow(_cursor, "partProduct");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfPartQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "partQuantity");
      final int _cursorIndexOfTotalP = CursorUtil.getColumnIndexOrThrow(_cursor, "totalP");
      final int _cursorIndexOfPaidPart = CursorUtil.getColumnIndexOrThrow(_cursor, "paidPart");
      final int _cursorIndexOfOwingP = CursorUtil.getColumnIndexOrThrow(_cursor, "owingP");
      final List<Part_Entity> _result = new ArrayList<Part_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Part_Entity _item;
        _item = new Part_Entity();
        final int _tmpPartid;
        _tmpPartid = _cursor.getInt(_cursorIndexOfPartid);
        _item.setPartid(_tmpPartid);
        final String _tmpNames;
        _tmpNames = _cursor.getString(_cursorIndexOfNames);
        _item.setNames(_tmpNames);
        final String _tmpPartDate;
        _tmpPartDate = _cursor.getString(_cursorIndexOfPartDate);
        _item.setPartDate(_tmpPartDate);
        final String _tmpPartProduct;
        _tmpPartProduct = _cursor.getString(_cursorIndexOfPartProduct);
        _item.setPartProduct(_tmpPartProduct);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item.setType(_tmpType);
        final int _tmpPartQuantity;
        _tmpPartQuantity = _cursor.getInt(_cursorIndexOfPartQuantity);
        _item.setPartQuantity(_tmpPartQuantity);
        final float _tmpTotalP;
        _tmpTotalP = _cursor.getFloat(_cursorIndexOfTotalP);
        _item.setTotalP(_tmpTotalP);
        final float _tmpPaidPart;
        _tmpPaidPart = _cursor.getFloat(_cursorIndexOfPaidPart);
        _item.setPaidPart(_tmpPaidPart);
        final float _tmpOwingP;
        _tmpOwingP = _cursor.getFloat(_cursorIndexOfOwingP);
        _item.setOwingP(_tmpOwingP);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
