package dev.jacekorjason.consoleapi;

public record ConsoleAPI(int indent) {
    public String positionCursor(int lines) {
        return "%n".repeat(lines) + " ".repeat(indent);
    }
}
