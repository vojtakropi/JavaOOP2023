package cz.cvut.vk.model;

public class ScoreboardDto {

    private long id;

    private String name;

    private long time;

    public ScoreboardDto(long id, String name, long time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public ScoreboardDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
