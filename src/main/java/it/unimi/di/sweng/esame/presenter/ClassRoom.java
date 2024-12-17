package it.unimi.di.sweng.esame.presenter;

public record ClassRoom(String name, String classRoom) {
    public ClassRoom {
        if (name.isBlank() || classRoom.isBlank() || !classRoom.matches("C\\d\\d")) {
            throw new IllegalArgumentException("Illegal classroom format");
        }
    }
}
