package marcos.psp.examen.harryPotter.model;

import java.util.Arrays;

public class House {
    private String house;
    private String emoji;
    private String founder;
    private String[] colors;
    private String animal;
    private Integer index;

    public House() {
    }

    public House(String house, String emoji, String founder, String[] colors, String animal, Integer index) {
        this.house = house;
        this.emoji = emoji;
        this.founder = founder;
        this.colors = colors;
        this.animal = animal;
        this.index = index;
    }

    public java.lang.String getHouse() {
        return house;
    }

    public void setHouse(java.lang.String house) {
        this.house = house;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public java.lang.String getFounder() {
        return founder;
    }

    public void setFounder(java.lang.String founder) {
        this.founder = founder;
    }

    public java.lang.String[] getColors() {
        return colors;
    }

    public void setColors(java.lang.String[] colors) {
        this.colors = colors;
    }

    public java.lang.String getAnimal() {
        return animal;
    }

    public void setAnimal(java.lang.String animal) {
        this.animal = animal;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "House:" + house + " " + emoji + ", founder: " + founder + ", colors " + Arrays.toString(colors) + ", animal: " + animal ;
    }
}
