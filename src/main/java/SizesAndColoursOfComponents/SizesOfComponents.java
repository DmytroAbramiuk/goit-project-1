package SizesAndColoursOfComponents;

public enum SizesOfComponents {
    DEFAULT_PANEL_WIDTH(400),
    DEFAULT_PANEL_HEIGHT(500),
    START_PANEL_BUTTON_HEIGHT(50),
    START_PANEL_BUTTON_WIDTH(170),
    USERNAME_FIELD_WIDTH(170),
    USERNAME_FIELD_HEIGHT(35),
    USER_TEXT_FIELD_WIDTH(200),
    USER_PANEL_WIDTH(360),
    USER_PANEL_HEIGHT(80),
    COMPUTER_PANEL_HEIGHT(40),
    USER_GAME_COMPONENTS_HEIGHT(35),
    SURRENDER_BUTTON_WIDTH(150),
    USER_STEP_BUTTON_WIDTH(80),
    CITIES_LOGO_WIDTH(400),
    FONT_SIZE_12(12),
    FONT_SIZE_15(15),
    FONT_SIZE_20(20),
    FONT_SIZE_50(50);




    private final int value;

    SizesOfComponents(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}