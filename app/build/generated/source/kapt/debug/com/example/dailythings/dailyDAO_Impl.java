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
        return "INSERT OR ABORT INTO `FeedEntity` (`date`,`feed_type5kg`,`feed_type20kg`,`feed_type50kg`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FeedEntity value) {
        stmt.bindLong(1, value.getDate());
        stmt.bindLong(2, value.getFeed_type5kg());
        stmt.bindLong(3, value.getFeed_type20kg());
        stmt.bindLong(4, value.getFeed_type50kg());
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
