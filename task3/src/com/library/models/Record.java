package com.library.models;

import java.time.LocalDate;

public record Record(int recordId , String userName , int itemId , LocalDate borrowDate) {
}
