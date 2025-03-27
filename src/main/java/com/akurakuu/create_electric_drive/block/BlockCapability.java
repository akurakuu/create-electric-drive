package com.akurakuu.create_electric_drive.block;

import net.neoforged.neoforge.energy.EnergyStorage;

public class BlockCapability extends EnergyStorage {
    private boolean canReceive;
    private boolean canExtract;

    public BlockCapability(
            int capacity,
            int maxReceive,
            int maxExtract,
            boolean canReceive,
            boolean canExtract
    ) {
        super(capacity, maxReceive, maxExtract);
        this.canReceive = canReceive;
        this.canExtract = canExtract;
    }

    @Override
    public boolean canExtract() {
        return canExtract;
    }

    @Override
    public boolean canReceive() {
        return canReceive;
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
