package id.putra.movierspticket.common.converter;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration, Long> {

    @Override
    public Long convertToDatabaseColumn(Duration attribute) {
        return attribute.toMinutes();
    }

    @Override
    public Duration convertToEntityAttribute(Long durationInMinutes) {
        return Duration.of(durationInMinutes, ChronoUnit.MINUTES);
    }

}
