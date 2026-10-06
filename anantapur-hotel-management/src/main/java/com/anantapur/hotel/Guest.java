package com.anantapur.hotel;

public record Guest(String name, String phone) {
    @Override
    public String toString() {
        return name + " (" + phone + ")";
    }
}
