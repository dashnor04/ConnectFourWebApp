package spw4.connectfour;

public class Player {
    private Color color;

    public Player() {
        this.color = Color.WHITE;
    }

    public void setColor (String color) {
        switch (color) {
            case "RED":
                this.color = Color.RED;
                break;
            case "YELLOW":
                this.color = Color.YELLOW;
                break;
        }
    }

    public Color getColor() {
        return this.color;
    }
}
