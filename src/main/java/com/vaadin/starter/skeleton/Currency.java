package com.vaadin.starter.skeleton;

public enum Currency {
    USD("$"),
    EUR("€"),
    RUB("\u20BD");

    private final String specialChar;

    Currency(String specialChar) {
        this.specialChar = specialChar;
    }

    @Override
    public String toString() {
        return specialChar;
    }
}
