package com.redhat.developers;

import java.util.List;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Entity;

@Entity
public class Fruit extends PanacheEntity {
    public String name;
    public String season;

    public static Uni<List<Fruit>> findBySeason(String season) {
        return find("season", season).list();
    }
}
