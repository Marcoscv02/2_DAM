package marcos.psp.examen.harryPotter.model;

import java.util.Arrays;

public class Character {
    private String fullName;
    private String nickname;
    private String hogwartsHouse;
    private String interpretedBy;
    private String[] children;
    private String image;
    private String birthdate;
    private Integer index;

    public Character() {
    }

    public Character(String fullName, String nickname, String hogwartsHouse, String interpretedBy, String[] children, String image, String birthdate, Integer index) {
        this.fullName = fullName;
        this.nickname = nickname;
        this.hogwartsHouse = hogwartsHouse;
        this.interpretedBy = interpretedBy;
        this.children = children;
        this.image = image;
        this.birthdate = birthdate;
        this.index = index;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHogwartsHouse() {
        return hogwartsHouse;
    }

    public void setHogwartsHouse(String hogwartsHouse) {
        this.hogwartsHouse = hogwartsHouse;
    }

    public String getInterpretedBy() {
        return interpretedBy;
    }

    public void setInterpretedBy(String interpretedBy) {
        this.interpretedBy = interpretedBy;
    }

    public String[] getChildren() {
        return children;
    }

    public void setChildren(String[] children) {
        this.children = children;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Character: " + nickname + " (" + fullName + ", "+birthdate+"), hogwartsHouse: " + hogwartsHouse + ", interpreted by: " + interpretedBy +", childrens " + Arrays.toString(children);
    }
}
