package com.akurakuu.createelectricdrive.blocks;

import net.neoforged.neoforge.energy.EnergyStorage;

public class BlockCapability extends EnergyStorage {
    public BlockCapability(int capacity) {
        super(capacity);
    }

    public BlockCapability(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public BlockCapability(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    public BlockCapability(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }

    @Override
    public int receiveEnergy(int toReceive, boolean simulate) {
        return super.receiveEnergy(toReceive, simulate);
    }

    public void setEnergy(int energy) {
        super.energy = energy;
    }

    public void consumeEnergy(int energy) {
        if (super.energy - energy <= 0) {
            super.energy = 0;
        } else {
            super.energy -= energy;
        }
    }
}
