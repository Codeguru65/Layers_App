package com.example.dailythings;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class dailyDAO_Impl implements dailyDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FeedEntity> __insertionAdapterOfFeedEntity;

  public dailyDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFeedEntity = new EntityInsertionAdapter<FeedEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `FeedEntity` (`id`,`feed_type`,`quantity`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FeedEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getFeed_type() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFeed_type());
        }
        stmt.bindLong(3, value.getQuantity());
      }
    };
  }

  @Override
  public void saveTask(final FeedEntity feed) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFeedEntity.insert(feed);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
