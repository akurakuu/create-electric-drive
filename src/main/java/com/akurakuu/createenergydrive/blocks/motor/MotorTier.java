package com.akurakuu.createenergydrive.blocks.motor;

import java.util.List;

public class MotorTier<T> {
    public T basic;
    public T enhanced;
    public T advanced;
    public T innovative;
    public T ultimate;

    public MotorTier(
            T basic,
            T enhanced,
            T advanced,
            T innovative,
            T ultimate
    ) {
        this.basic = basic;
        this.enhanced = enhanced;
        this.advanced = advanced;
        this.innovative = innovative;
        this.ultimate = ultimate;
    }

    public List<T> toList() {
        return List.of(
                this.basic,
                this.enhanced,
                this.advanced,
                this.innovative,
                this.ultimate
        );
    }

    public static <T> MotorTier<T> ofList(List<T> list) {
        if (list == null || list.size() != 5) {
            throw new IllegalArgumentException("List must contain exactly 5 elements");
        }

        return new MotorTier<>(
                list.get(0),
                list.get(1),
                list.get(2),
                list.get(3),
                list.get(4)
        );
    }
}
