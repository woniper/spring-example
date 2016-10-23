package net.woniper.querydsl.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "foo_id")
    private Long id;

    @Column(name = "bar")
    private String bar;

    public Foo() {}

    public Foo(String bar) {
        setBar(bar);
    }

    public Long getId() {
        return id;
    }

    public Foo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBar() {
        return bar;
    }

    public Foo setBar(String bar) {
        this.bar = bar;
        return this;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", bar='" + bar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Foo)) return false;

        Foo foo = (Foo) o;

        if (getId() != null ? !getId().equals(foo.getId()) : foo.getId() != null) return false;
        return getBar() != null ? getBar().equals(foo.getBar()) : foo.getBar() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getBar() != null ? getBar().hashCode() : 0);
        return result;
    }
}
