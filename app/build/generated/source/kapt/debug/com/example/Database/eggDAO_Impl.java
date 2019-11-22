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
public final class eggDAO_Impl implements eggDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Egg_Entity> __insertionAdapterOfEgg_Entity;

  private final EntityDeletionOrUpdateAdapter<Egg_Entity> __updateAdapterOfEgg_Entity;

  public eggDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEgg_Entity = new EntityInsertionAdapter<Egg_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Egg_Entity` (`eggid`,`date`,`size`,`quality`,`picked`,`broken`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Egg_Entity value) {
        stmt.bindLong(1, value.getEggid());
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        if (value.getSize() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSize());
        }
        if (value.getQuality() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getQuality());
        }
        stmt.bindLong(5, value.getPicked());
        stmt.bindLong(6, value.getBroken());
      }
    };
    this.__updateAdapterOfEgg_Entity = new EntityDeletionOrUpdateAdapter<Egg_Entity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Egg_Entity` SET `eggid` = ?,`date` = ?,`size` = ?,`quality` = ?,`picked` = ?,`broken` = ? WHERE `eggid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Egg_Entity value) {
        stmt.bindLong(1, value.getEggid());
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        if (value.getSize() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSize());
        }
        if (value.getQuality() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getQuality());
        }
        stmt.bindLong(5, value.getPicked());
        stmt.bindLong(6, value.getBroken());
        stmt.bindLong(7, value.getEggid());
      }
    };
  }

  @Override
  public void saveEggTask(final Egg_Entity task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEgg_Entity.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateEgg(final Egg_Entity egg) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEgg_Entity.handle(egg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Egg_Entity> viewEgg() {
    final String _sql = "select * from Egg_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEggid = CursorUtil.getColumnIndexOrThrow(_cursor, "eggid");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "quality");
      final int _cursorIndexOfPicked = CursorUtil.getColumnIndexOrThrow(_cursor, "picked");
      final int _cursorIndexOfBroken = CursorUtil.getColumnIndexOrThrow(_cursor, "broken");
      final List<Egg_Entity> _result = new ArrayList<Egg_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Egg_Entity _item;
        _item = new Egg_Entity();
        final int _tmpEggid;
        _tmpEggid = _cursor.getInt(_cursorIndexOfEggid);
        _item.setEggid(_tmpEggid);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _item.setDate(_tmpDate);
        final String _tmpSize;
        _tmpSize = _cursor.getString(_cursorIndexOfSize);
        _item.setSize(_tmpSize);
        final String _tmpQuality;
        _tmpQuality = _cursor.getString(_cursorIndexOfQuality);
        _item.setQuality(_tmpQuality);
        final int _tmpPicked;
        _tmpPicked = _cursor.getInt(_cursorIndexOfPicked);
        _item.setPicked(_tmpPicked);
        final int _tmpBroken;
        _tmpBroken = _cursor.getInt(_cursorIndexOfBroken);
        _item.setBroken(_tmpBroken);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Egg_Entity> viewEggHistory(final String dte) {
    final String _sql = "select * from Egg_Entity where date is ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dte == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dte);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEggid = CursorUtil.getColumnIndexOrThrow(_cursor, "eggid");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "quality");
      final int _cursorIndexOfPicked = CursorUtil.getColumnIndexOrThrow(_cursor, "picked");
      final int _cursorIndexOfBroken = CursorUtil.getColumnIndexOrThrow(_cursor, "broken");
      final List<Egg_Entity> _result = new ArrayList<Egg_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Egg_Entity _item;
        _item = new Egg_Entity();
        final int _tmpEggid;
        _tmpEggid = _cursor.getInt(_cursorIndexOfEggid);
        _item.setEggid(_tmpEggid);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _item.setDate(_tmpDate);
        final String _tmpSize;
        _tmpSize = _cursor.getString(_cursorIndexOfSize);
        _item.setSize(_tmpSize);
        final String _tmpQuality;
        _tmpQuality = _cursor.getString(_cursorIndexOfQuality);
        _item.setQuality(_tmpQuality);
        final int _tmpPicked;
        _tmpPicked = _cursor.getInt(_cursorIndexOfPicked);
        _item.setPicked(_tmpPicked);
        final int _tmpBroken;
        _tmpBroken = _cursor.getInt(_cursorIndexOfBroken);
        _item.setBroken(_tmpBroken);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
