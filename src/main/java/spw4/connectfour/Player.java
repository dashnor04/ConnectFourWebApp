package spw4.connectfour;

public class Player {
    private String name;
    private Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Player() {
        this.name  = "Player";
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
