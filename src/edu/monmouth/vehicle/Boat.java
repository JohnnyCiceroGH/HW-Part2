package edu.monmouth.vehicle;
import java.util.Objects;

public class Boat implements Vehicle {

    private int boatLength;
    private PowerTypes powerSource;

    public Boat(PowerTypes powerSource, int boatLength) throws BoatException {
        setPowerSource(powerSource);
        setBoatLength(boatLength);
    }

    public int getBoatLength() {
        return boatLength;
    }

    public void setBoatLength(int boatLength) throws BoatException {
        if (boatLength < VehicleConstants.MIN_BOAT_LENGTH
                || boatLength > VehicleConstants.MAX_BOAT_LENGTH) {

            throw new BoatException(
                    "Invalid boat length: " + boatLength
                    + ". Boat length must be between "
                    + VehicleConstants.MIN_BOAT_LENGTH
                    + " and "
                    + VehicleConstants.MAX_BOAT_LENGTH + ".");
        }

        this.boatLength = boatLength;
    }

    @Override
    public void go() {
    }

    @Override
    public void stop() {
    }

    @Override
    public PowerTypes powerBy() {
        return powerSource;
    }

    public void setPowerSource(PowerTypes powerSource) {
        this.powerSource = powerSource;
    }

    public PowerTypes getPowerSource() {
        return powerSource;
    }

    @Override
    public String toString() {
        return "Boat [powerSource=" + powerSource
                + ", boatLength=" + boatLength + "]";
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Boat other = (Boat) o;

        return boatLength == other.boatLength
                && powerSource == other.powerSource;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boatLength, powerSource);
    }
}