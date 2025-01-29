public class Rooms {
    private int ID;
    private String name;
    private String description;
    private boolean visited = false;
    private String direction;

    public Rooms(int ID, String name, String description, String direction) {
        this.setID(ID);
        this.setName(name);
        this.setDescription(description);
        this.setDirection(direction);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }
}

