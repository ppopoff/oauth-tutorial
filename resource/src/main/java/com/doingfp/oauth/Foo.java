package com.doingfp.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public final class Foo {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    public Foo(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public final Foo setId(final long newId) {
        return new Foo(newId, name);
    }

    public final Foo setName(final String newName) {
        return new Foo(id, newName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foo foo = (Foo) o;
        return id == foo.id &&
                Objects.equals(name, foo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
