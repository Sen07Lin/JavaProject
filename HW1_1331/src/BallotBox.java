/**
 * BallotBox class represents the Ballot Box object. Wrapper around the
 * ArrayListBag which specifies the bag contains Ballot objects.
 * @author Sen
 * @version 1.0
 */
public class BallotBox {
    private BagInterface<Ballot> ballots;
    /**
     * Constructor of BallotBox.
     */
    public BallotBox() {
        ballots = new ArrayListBag<Ballot>();
    }
    /**
     * getter method for ballots.
     * @return return ballots
     */
    public BagInterface<Ballot> getBallots() {
        return ballots;
    }
    /**
     * setter for ballots.
     * @param ballots the parameter that ballot to be set to.
     */
    public void setBallots(BagInterface<Ballot> ballots) {
        this.ballots = ballots;
    }
    /**
     * add a ballot to the box.
     * @param ballot the ballot to be added into the box
     * @return true if successfully add a ballot
     */
    public boolean add(Ballot ballot) {
        if (ballot != null) {
            return ballots.add(ballot);
        } else {
            return false;
        }
    }
    /**
     * this method get the frequency of a ballot.
     * @param ballot the ballot to be query.
     * @return the number of ballots inside the box for a particular ballot
     */
    public int getFrequencyOf(Ballot ballot) {
        return ballots.getFrequencyOf(ballot);
    }
    /**
     * remove a ballot randomly.
     * @return true if remove successfully
     */
    public Ballot remove() {
        return ballots.remove();
    }
    /**
     * remove one particular ballot from the ballot box.
     * @param ballot the ballot to be queried
     * @return true if found and remove the ballot successfully.
     */
    public boolean remove(Ballot ballot) {
        return ballots.remove(ballot);
    }
    /**
     * checking if contains a particular ballot.
     * @param ballot ballot to be queried
     * @return true if found
     */
    public boolean contains(Ballot ballot) {
        return ballots.contains(ballot);
    }
    /**
     * Creates an array of all entries that are in this bag. It does not destroy
     * or alter the bag in any way. If the bag is actually empty, this will
     * still create an array, but it will have length 0.
     * @return a newly allocated array of all the entries in the bag
     */
    public Ballot[] toArray() {
        Object[] a = ballots.toArray();
        int size = ballots.getCurrentSize();
        Ballot[] b = new Ballot[size];
        for (int i = 0; i < size; i++) {
            b[i] = (Ballot) (a[i]);
        }
        return b;
    }
    /**
     * get number of ballots in the box.
     * @return number of ballots
     */
    public int getCurrentSize() {
        return ballots.getCurrentSize();
    }
    /**
     * clear all the ballots in the ballot box.
     */
    public void clear() {
        ballots.clear();
    }
    /**
     * check if the box is empty.
     * @return true if empty
     */
    public boolean isEmpty() {
        return ballots.isEmpty();
    }
}
