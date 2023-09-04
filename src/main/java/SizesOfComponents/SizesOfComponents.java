package SizesOfComponents;

public enum SizesOfComponents {
    PANEL_WIDTH(400),
    PANEL_HEIGHT(500),
    START_PANEL_BUTTON_HEIGHT(50),
    START_PANEL_BUTTON_WIDTH(170),
    USERNAME_FIELD_WIDTH(170),
    USERNAME_FIELD_HEIGHT(35),
    USER_TEXT_FIELD_WIDTH(200),
    USER_GAME_COMPONENTS_HEIGHT(35),
    USER_STEP_BUTTON_WIDTH(80);

    private final int value;

    SizesOfComponents(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}