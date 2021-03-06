package sample_project.extensions.java.time.chrono.ChronoLocalDateTime;

import manifold.ext.api.IProxyFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class Date_To_ChronoLocalDateTime implements IProxyFactory<Date, ChronoLocalDateTime<LocalDate>> {
  @Override
  public ChronoLocalDateTime<LocalDate> proxy(Date date, Class<ChronoLocalDateTime<LocalDate>> aClass) {
    return new Proxy(date);
  }

  public static class Proxy implements ChronoLocalDateTime<LocalDate>
  {
    private final LocalDateTime _delegate;

    public Proxy(Date date) {
      _delegate = date.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime();
    }

    @Override
    public LocalDate toLocalDate() {
      return _delegate.toLocalDate();
    }

    @Override
    public LocalTime toLocalTime() {
      return _delegate.toLocalTime();
    }

    @Override
    public boolean isSupported(TemporalField field) {
      return _delegate.isSupported(field);
    }

    @Override
    public long getLong(TemporalField field) {
      return _delegate.getLong(field);
    }

    @Override
    public ChronoLocalDateTime<LocalDate> with(TemporalField field, long newValue) {
      return _delegate.with(field, newValue);
    }

    @Override
    public ChronoLocalDateTime<LocalDate> plus(long amountToAdd, TemporalUnit unit) {
      return _delegate.plus(amountToAdd, unit);
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
      return _delegate.until(endExclusive, unit);
    }

    @Override
    public ChronoZonedDateTime<LocalDate> atZone(ZoneId zone) {
      return _delegate.atZone(zone);
    }
  }
}
