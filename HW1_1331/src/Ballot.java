/**
 * This class represents the ballot. it has name and bribe amount
 * @author Sen
 * @version 1.0
 */
public class Ballot {
    private String name;
    private double bribeAmount;
    /**
     * the default constructor of class Ballot.
     */
    public Ballot() {
        this("", 0);
    }
    /**
     * Constructor for Ballot class.
     * @param name name for the candidate
     * @param bribeAmount amount of bribe money
     */
    public Ballot(String name, double bribeAmount) {
        this.setName(name);
        this.setBribeAmount(bribeAmount);
    }
    /**
     * getter for bribeAmount.
     * @return return the bribeAmount.
     */
    public double getBribeAmount() {
        return bribeAmount;
    }
    /**
     * setter for bribeAmount.
     * @param bribeAmount the amount to set to.
     */
    public void setBribeAmount(double bribeAmount) {
        this.bribeAmount = bribeAmount;
    }
    /**
     * getter method for name.
     * @return name of the candidate
     */
    public String getName() {
        return name;
    }
    /**
     * setter method for name.
     * @param name name to set to.
     */
    public void setName(String name) {
        this.name = name;
    }
    @Override
    /**
     * override the equal method so that ballots can compare.
     * @param o, the object to compare to.
     * @return true if equals
     */
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Ballot)) {
            return false;
        } else {
            Ballot that = (Ballot) o;
            return this.name.equals(that.name);
        }
    }
    @Override
    /**
     * print out the name and bribe amount of a ballot.
     * @return a string of information.
     */
    public String toString() {
        return "Name of the candidate:" + this.name + ", " + "Bribe Amount:"
                + this.bribeAmount;
    }
}
