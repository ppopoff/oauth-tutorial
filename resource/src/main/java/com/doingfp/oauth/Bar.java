package com.doingfp.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class Bar {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    public Bar(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public final Bar setId(final long newId) {
        return new Bar(newId, name);
    }

    public final Bar setName(final String newName) {
        return new Bar(id, newName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar foo = (Bar) o;
        return id == foo.id &&
                Objects.equals(name, foo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
