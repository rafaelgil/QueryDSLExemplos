package com.estudo.querydsl.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVenda is a Querydsl query type for Venda
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVenda extends EntityPathBase<Venda> {

    private static final long serialVersionUID = -2128838972L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVenda venda = new QVenda("venda");

    public final QCliente cliente;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DatePath<java.util.Date> lancamento = createDate("lancamento", java.util.Date.class);

    public QVenda(String variable) {
        this(Venda.class, forVariable(variable), INITS);
    }

    public QVenda(Path<? extends Venda> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QVenda(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QVenda(PathMetadata metadata, PathInits inits) {
        this(Venda.class, metadata, inits);
    }

    public QVenda(Class<? extends Venda> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cliente = inits.isInitialized("cliente") ? new QCliente(forProperty("cliente")) : null;
    }

}

