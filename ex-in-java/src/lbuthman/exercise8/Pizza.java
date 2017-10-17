package lbuthman.exercise8;

public enum Pizza {

    SMALL(6), MEDIUM(8), LARGE(10);

    public int pieces;

    Pizza(int pieces) {
        this.pieces = pieces;
    }
}
