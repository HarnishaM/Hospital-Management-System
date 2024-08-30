import java.util.Objects;

public class Bed {
    private int bedNumber;
    private boolean occupied;

    // Constructors
    public Bed(int bedNumber) {
        this.bedNumber = bedNumber;
        this.occupied = false; // Initially, the bed is unoccupied
    }

    // Getters and Setters
    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    // toString Method
    @Override
    public String toString() {
        return "Bed{" +
                "bedNumber=" + bedNumber +
                ", occupied=" + occupied +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bed bed = (Bed) o;
        return bedNumber == bed.bedNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bedNumber);
    }
}
