package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

public record ClassRoom(String name, String classRoom) implements Comparable<ClassRoom> {
    public ClassRoom {
        if (name.isBlank() || classRoom.isBlank() || !classRoom.matches("C\\d\\d")) {
            throw new IllegalArgumentException("Illegal classroom format");
        }
    }

    @Override
    public int compareTo(@NotNull ClassRoom o) {
        if (classRoom.equals(o.classRoom)) return name.compareTo(o.name);
        return classRoom.compareTo(o.classRoom);
    }
}
