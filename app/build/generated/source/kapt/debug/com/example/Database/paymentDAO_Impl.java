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
public final class paymentDAO_Impl implements paymentDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Payment_Entity> __insertionAdapterOfPayment_Entity;

  public paymentDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPayment_Entity = new EntityInsertionAdapter<Payment_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Payment_Entity` (`payid`,`nameS`,`payDate`,`payProduct`,`payType`,`payQuantity`,`totalPay`,`paidPay`,`owingPay`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Payment_Entity value) {
        stmt.bindLong(1, value.getPayid());
        if (value.getNameS() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNameS());
        }
        if (value.getPayDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPayDate());
        }
        if (value.getPayProduct() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPayProduct());
        }
        if (value.getPayType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPayType());
        }
        stmt.bindLong(6, value.getPayQuantity());
        stmt.bindDouble(7, value.getTotalPay());
        stmt.bindDouble(8, value.getPaidPay());
        stmt.bindDouble(9, value.getOwingPay());
      }
    };
  }

  @Override
  public void savePayTask(final Payment_Entity task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPayment_Entity.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Payment_Entity> viewPay() {
    final String _sql = "select * from Payment_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPayid = CursorUtil.getColumnIndexOrThrow(_cursor, "payid");
      final int _cursorIndexOfNameS = CursorUtil.getColumnIndexOrThrow(_cursor, "nameS");
      final int _cursorIndexOfPayDate = CursorUtil.getColumnIndexOrThrow(_cursor, "payDate");
      final int _cursorIndexOfPayProduct = CursorUtil.getColumnIndexOrThrow(_cursor, "payProduct");
      final int _cursorIndexOfPayType = CursorUtil.getColumnIndexOrThrow(_cursor, "payType");
      final int _cursorIndexOfPayQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "payQuantity");
      final int _cursorIndexOfTotalPay = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPay");
      final int _cursorIndexOfPaidPay = CursorUtil.getColumnIndexOrThrow(_cursor, "paidPay");
      final int _cursorIndexOfOwingPay = CursorUtil.getColumnIndexOrThrow(_cursor, "owingPay");
      final List<Payment_Entity> _result = new ArrayList<Payment_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payment_Entity _item;
        _item = new Payment_Entity();
        final int _tmpPayid;
        _tmpPayid = _cursor.getInt(_cursorIndexOfPayid);
        _item.setPayid(_tmpPayid);
        final String _tmpNameS;
        _tmpNameS = _cursor.getString(_cursorIndexOfNameS);
        _item.setNameS(_tmpNameS);
        final String _tmpPayDate;
        _tmpPayDate = _cursor.getString(_cursorIndexOfPayDate);
        _item.setPayDate(_tmpPayDate);
        final String _tmpPayProduct;
        _tmpPayProduct = _cursor.getString(_cursorIndexOfPayProduct);
        _item.setPayProduct(_tmpPayProduct);
        final String _tmpPayType;
        _tmpPayType = _cursor.getString(_cursorIndexOfPayType);
        _item.setPayType(_tmpPayType);
        final int _tmpPayQuantity;
        _tmpPayQuantity = _cursor.getInt(_cursorIndexOfPayQuantity);
        _item.setPayQuantity(_tmpPayQuantity);
        final float _tmpTotalPay;
        _tmpTotalPay = _cursor.getFloat(_cursorIndexOfTotalPay);
        _item.setTotalPay(_tmpTotalPay);
        final float _tmpPaidPay;
        _tmpPaidPay = _cursor.getFloat(_cursorIndexOfPaidPay);
        _item.setPaidPay(_tmpPaidPay);
        final float _tmpOwingPay;
        _tmpOwingPay = _cursor.getFloat(_cursorIndexOfOwingPay);
        _item.setOwingPay(_tmpOwingPay);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
