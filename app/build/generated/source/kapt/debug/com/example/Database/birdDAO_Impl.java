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
public final class birdDAO_Impl implements birdDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Bird_Entity> __insertionAdapterOfBird_Entity;

  private final EntityDeletionOrUpdateAdapter<Bird_Entity> __updateAdapterOfBird_Entity;

  public birdDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBird_Entity = new EntityInsertionAdapter<Bird_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Bird_Entity` (`birdId`,`quantity`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Bird_Entity value) {
        stmt.bindLong(1, value.getBirdId());
        stmt.bindLong(2, value.getBirdQty());
      }
    };
    this.__updateAdapterOfBird_Entity = new EntityDeletionOrUpdateAdapter<Bird_Entity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Bird_Entity` SET `birdId` = ?,`quantity` = ? WHERE `birdId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Bird_Entity value) {
        stmt.bindLong(1, value.getBirdId());
        stmt.bindLong(2, value.getBirdQty());
        stmt.bindLong(3, value.getBirdId());
      }
    };
  }

  @Override
  public void addBird(final Bird_Entity stock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBird_Entity.insert(stock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addMoreBird(final Bird_Entity bird) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfBird_Entity.handle(bird);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Bird_Entity> viewBird() {
    final String _sql = "select * from Bird_Entity where birdId is 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBirdId = CursorUtil.getColumnIndexOrThrow(_cursor, "birdId");
      final int _cursorIndexOfBirdQty = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final List<Bird_Entity> _result = new ArrayList<Bird_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Bird_Entity _item;
        _item = new Bird_Entity();
        final int _tmpBirdId;
        _tmpBirdId = _cursor.getInt(_cursorIndexOfBirdId);
        _item.setBirdId(_tmpBirdId);
        final int _tmpBirdQty;
        _tmpBirdQty = _cursor.getInt(_cursorIndexOfBirdQty);
        _item.setBirdQty(_tmpBirdQty);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
