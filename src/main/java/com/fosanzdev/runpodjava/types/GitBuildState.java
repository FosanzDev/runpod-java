package com.fosanzdev.runpodjava.types;

public enum GitBuildState {
    PENDING,
    BUILDING,
    UPLOADING,
    COMPLETED,
    FAILED,
    CANCELLED,
    TESTING,
    TEST_FAILED
}