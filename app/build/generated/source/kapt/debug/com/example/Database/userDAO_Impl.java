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
public final class userDAO_Impl implements userDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User_Entity> __insertionAdapterOfUser_Entity;

  public userDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser_Entity = new EntityInsertionAdapter<User_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `User_Entity` (`userid`,`fname`,`lname`,`email`,`username`,`password`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User_Entity value) {
        stmt.bindLong(1, value.getUserid());
        if (value.getFname() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFname());
        }
        if (value.getLname() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLname());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEmail());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
      }
    };
  }

  @Override
  public void addUser(final User_Entity item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser_Entity.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public User_Entity viewUser(final String user) {
    final String _sql = "select * from User_Entity where username = ? or email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (user == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, user);
    }
    _argIndex = 2;
    if (user == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, user);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserid = CursorUtil.getColumnIndexOrThrow(_cursor, "userid");
      final int _cursorIndexOfFname = CursorUtil.getColumnIndexOrThrow(_cursor, "fname");
      final int _cursorIndexOfLname = CursorUtil.getColumnIndexOrThrow(_cursor, "lname");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final User_Entity _result;
      if(_cursor.moveToFirst()) {
        _result = new User_Entity();
        final int _tmpUserid;
        _tmpUserid = _cursor.getInt(_cursorIndexOfUserid);
        _result.setUserid(_tmpUserid);
        final String _tmpFname;
        _tmpFname = _cursor.getString(_cursorIndexOfFname);
        _result.setFname(_tmpFname);
        final String _tmpLname;
        _tmpLname = _cursor.getString(_cursorIndexOfLname);
        _result.setLname(_tmpLname);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result.setUsername(_tmpUsername);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User_Entity> checkUsers() {
    final String _sql = "select * from User_Entity  ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserid = CursorUtil.getColumnIndexOrThrow(_cursor, "userid");
      final int _cursorIndexOfFname = CursorUtil.getColumnIndexOrThrow(_cursor, "fname");
      final int _cursorIndexOfLname = CursorUtil.getColumnIndexOrThrow(_cursor, "lname");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final List<User_Entity> _result = new ArrayList<User_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User_Entity _item;
        _item = new User_Entity();
        final int _tmpUserid;
        _tmpUserid = _cursor.getInt(_cursorIndexOfUserid);
        _item.setUserid(_tmpUserid);
        final String _tmpFname;
        _tmpFname = _cursor.getString(_cursorIndexOfFname);
        _item.setFname(_tmpFname);
        final String _tmpLname;
        _tmpLname = _cursor.getString(_cursorIndexOfLname);
        _item.setLname(_tmpLname);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item.setUsername(_tmpUsername);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _item.setPassword(_tmpPassword);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
