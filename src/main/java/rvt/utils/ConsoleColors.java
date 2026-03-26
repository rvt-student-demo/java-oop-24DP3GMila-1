package rvt.utils;

public enum ConsoleColors {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    BLACK("\u001B[30m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    YELLOW("\u001B[33m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m");

    final String code;
    ConsoleColors(String code) {
        this.code = code;
    }
}
