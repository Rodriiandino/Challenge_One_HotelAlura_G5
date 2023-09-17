package main.hotel.hotelalura.utils;

public enum WayToPay {
    CREDIT_CARD("Tarjeta Crédito"),
    DEBIT_CARD("Tarjeta Débito"),
    CASH("Efectivo");

    private final String displayName;

    WayToPay(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}