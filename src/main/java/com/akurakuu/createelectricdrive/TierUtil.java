package com.akurakuu.createelectricdrive;

import java.util.List;
import java.util.Objects;

public record TierUtil<T>(T basic, T enhanced, T advanced, T innovative, T ultimate) {
    public TierUtil(
            T basic,
            T enhanced,
            T advanced,
            T innovative,
            T ultimate
    ) {
        this.basic = Objects.requireNonNull(basic, "Basic tier cannot be null");
        this.enhanced = Objects.requireNonNull(enhanced, "Enhanced tier cannot be null");
        this.advanced = Objects.requireNonNull(advanced, "Advanced tier cannot be null");
        this.innovative = Objects.requireNonNull(innovative, "Innovative tier cannot be null");
        this.ultimate = Objects.requireNonNull(ultimate, "Ultimate tier cannot be null");
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

    public static <T> TierUtil<T> ofList(List<T> list) {
        if (list == null || list.size() != 5) {
            throw new IllegalArgumentException("List must contain exactly 5 elements");
        }

        return new TierUtil<>(
                list.get(0),
                list.get(1),
                list.get(2),
                list.get(3),
                list.get(4)
        );
    }

    public T getFromTier(Tier tier) {
        return switch (tier) {
            case Basic -> basic;
            case Enhanced -> enhanced;
            case Advanced -> advanced;
            case Innovative -> innovative;
            case Ultimate -> ultimate;
        };
    }

    public enum Tier {
        Basic,
        Enhanced,
        Advanced,
        Innovative,
        Ultimate,
    }
}
