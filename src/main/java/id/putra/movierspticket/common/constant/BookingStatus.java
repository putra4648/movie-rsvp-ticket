package id.putra.movierspticket.common.constant;

import lombok.Getter;

@Getter
public enum BookingStatus {
    REQUESTED,
    PENDING,
    CONFIRMED,
    CHECKED_IN,
    CANCELED,
    ABANDONED,

}
