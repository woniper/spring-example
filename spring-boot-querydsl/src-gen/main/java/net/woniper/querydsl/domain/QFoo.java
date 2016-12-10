package net.woniper.querydsl.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFoo is a Querydsl query type for Foo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFoo extends EntityPathBase<Foo> {

    private static final long serialVersionUID = 264316160L;

    public static final QFoo foo = new QFoo("foo");

    public final StringPath bar = createString("bar");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QFoo(String variable) {
        super(Foo.class, forVariable(variable));
    }

    public QFoo(Path<? extends Foo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoo(PathMetadata metadata) {
        super(Foo.class, metadata);
    }

}

