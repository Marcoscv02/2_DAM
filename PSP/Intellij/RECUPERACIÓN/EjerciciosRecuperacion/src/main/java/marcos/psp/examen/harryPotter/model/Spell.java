package marcos.psp.examen.harryPotter.model;

public class Spell {
    private String spell;
    private String use;
    private Integer index;

    public Spell() {
    }

    public Spell(String spell, String use, Integer index) {
        this.spell = spell;
        this.use = use;
        this.index = index;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Spell:" + spell +" (" + use +")";
    }
}
