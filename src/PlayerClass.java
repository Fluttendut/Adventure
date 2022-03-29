public abstract class PlayerClass {
    private int dexterity;
    private int strength;
    private int intellect;
    private int wisdom;
    private int charisma;
    private int constitution;

    private int ac;
    private int hitPointsmodifier;

    public PlayerClass(){
        //set default stats

    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHitPointsmodifier() {
        return hitPointsmodifier;
    }

    public void setHitPointsmodifier(int hitPointsmodifier) {
        this.hitPointsmodifier = hitPointsmodifier;
    }

    public int getAc() { return ac; }

    public void setAc(int ac) {this.ac = ac;
    }

    //todo write a tostring?

}
