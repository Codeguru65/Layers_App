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
public final class clientsDAO_Impl implements clientsDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Client_Entity> __insertionAdapterOfClient_Entity;

  private final EntityDeletionOrUpdateAdapter<Client_Entity> __updateAdapterOfClient_Entity;

  public clientsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClient_Entity = new EntityInsertionAdapter<Client_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Client_Entity` (`clientID`,`nameClient`,`clientType`,`address`,`phone`,`email`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Client_Entity value) {
        stmt.bindLong(1, value.getClientID());
        if (value.getNameClient() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNameClient());
        }
        if (value.getClientType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getClientType());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmail());
        }
      }
    };
    this.__updateAdapterOfClient_Entity = new EntityDeletionOrUpdateAdapter<Client_Entity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Client_Entity` SET `clientID` = ?,`nameClient` = ?,`clientType` = ?,`address` = ?,`phone` = ?,`email` = ? WHERE `clientID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Client_Entity value) {
        stmt.bindLong(1, value.getClientID());
        if (value.getNameClient() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNameClient());
        }
        if (value.getClientType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getClientType());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmail());
        }
        stmt.bindLong(7, value.getClientID());
      }
    };
  }

  @Override
  public void addClient(final Client_Entity client) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfClient_Entity.insert(client);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateClient(final Client_Entity client) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfClient_Entity.handle(client);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Client_Entity> veiwClient() {
    final String _sql = "select * from Client_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "clientID");
      final int _cursorIndexOfNameClient = CursorUtil.getColumnIndexOrThrow(_cursor, "nameClient");
      final int _cursorIndexOfClientType = CursorUtil.getColumnIndexOrThrow(_cursor, "clientType");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final List<Client_Entity> _result = new ArrayList<Client_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Client_Entity _item;
        _item = new Client_Entity();
        final int _tmpClientID;
        _tmpClientID = _cursor.getInt(_cursorIndexOfClientID);
        _item.setClientID(_tmpClientID);
        final String _tmpNameClient;
        _tmpNameClient = _cursor.getString(_cursorIndexOfNameClient);
        _item.setNameClient(_tmpNameClient);
        final String _tmpClientType;
        _tmpClientType = _cursor.getString(_cursorIndexOfClientType);
        _item.setClientType(_tmpClientType);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _item.setAddress(_tmpAddress);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _item.setPhone(_tmpPhone);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Client_Entity> viewSp(final String type) {
    final String _sql = "select * from Client_Entity where clientType is ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "clientID");
      final int _cursorIndexOfNameClient = CursorUtil.getColumnIndexOrThrow(_cursor, "nameClient");
      final int _cursorIndexOfClientType = CursorUtil.getColumnIndexOrThrow(_cursor, "clientType");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final List<Client_Entity> _result = new ArrayList<Client_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Client_Entity _item;
        _item = new Client_Entity();
        final int _tmpClientID;
        _tmpClientID = _cursor.getInt(_cursorIndexOfClientID);
        _item.setClientID(_tmpClientID);
        final String _tmpNameClient;
        _tmpNameClient = _cursor.getString(_cursorIndexOfNameClient);
        _item.setNameClient(_tmpNameClient);
        final String _tmpClientType;
        _tmpClientType = _cursor.getString(_cursorIndexOfClientType);
        _item.setClientType(_tmpClientType);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _item.setAddress(_tmpAddress);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _item.setPhone(_tmpPhone);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Client_Entity> fil(final String phrase) {
    final String _sql = "select * from Client_Entity where nameClient like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (phrase == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phrase);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "clientID");
      final int _cursorIndexOfNameClient = CursorUtil.getColumnIndexOrThrow(_cursor, "nameClient");
      final int _cursorIndexOfClientType = CursorUtil.getColumnIndexOrThrow(_cursor, "clientType");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final List<Client_Entity> _result = new ArrayList<Client_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Client_Entity _item;
        _item = new Client_Entity();
        final int _tmpClientID;
        _tmpClientID = _cursor.getInt(_cursorIndexOfClientID);
        _item.setClientID(_tmpClientID);
        final String _tmpNameClient;
        _tmpNameClient = _cursor.getString(_cursorIndexOfNameClient);
        _item.setNameClient(_tmpNameClient);
        final String _tmpClientType;
        _tmpClientType = _cursor.getString(_cursorIndexOfClientType);
        _item.setClientType(_tmpClientType);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _item.setAddress(_tmpAddress);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _item.setPhone(_tmpPhone);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Client_Entity> viewClient() {
    final String _sql = "select * from Client_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "clientID");
      final int _cursorIndexOfNameClient = CursorUtil.getColumnIndexOrThrow(_cursor, "nameClient");
      final int _cursorIndexOfClientType = CursorUtil.getColumnIndexOrThrow(_cursor, "clientType");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final List<Client_Entity> _result = new ArrayList<Client_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Client_Entity _item;
        _item = new Client_Entity();
        final int _tmpClientID;
        _tmpClientID = _cursor.getInt(_cursorIndexOfClientID);
        _item.setClientID(_tmpClientID);
        final String _tmpNameClient;
        _tmpNameClient = _cursor.getString(_cursorIndexOfNameClient);
        _item.setNameClient(_tmpNameClient);
        final String _tmpClientType;
        _tmpClientType = _cursor.getString(_cursorIndexOfClientType);
        _item.setClientType(_tmpClientType);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _item.setAddress(_tmpAddress);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _item.setPhone(_tmpPhone);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
