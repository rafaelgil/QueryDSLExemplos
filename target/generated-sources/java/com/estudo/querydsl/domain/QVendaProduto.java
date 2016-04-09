package com.estudo.querydsl.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVendaProduto is a Querydsl query type for VendaProduto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVendaProduto extends EntityPathBase<VendaProduto> {

    private static final long serialVersionUID = -190413931L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVendaProduto vendaProduto = new QVendaProduto("vendaProduto");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QProduto produto;

    public final NumberPath<java.math.BigDecimal> quantidade = createNumber("quantidade", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public final QVenda venda;

    public QVendaProduto(String variable) {
        this(VendaProduto.class, forVariable(variable), INITS);
    }

    public QVendaProduto(Path<? extends VendaProduto> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QVendaProduto(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QVendaProduto(PathMetadata metadata, PathInits inits) {
        this(VendaProduto.class, metadata, inits);
    }

    public QVendaProduto(Class<? extends VendaProduto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.produto = inits.isInitialized("produto") ? new QProduto(forProperty("produto")) : null;
        this.venda = inits.isInitialized("venda") ? new QVenda(forProperty("venda"), inits.get("venda")) : null;
    }

}

