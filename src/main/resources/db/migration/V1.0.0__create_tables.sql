create table accounts
(
    id             varchar(255) not null,
    created_at     timestamp(6) not null,
    created_by     varchar(255),
    modified_by    varchar(255),
    updated_at     timestamp(6),
    deleted_at     timestamp(6),
    is_deleted     boolean,
    account_number varchar(255),
    company_id     varchar(255),
    primary key (id)
);
create table bank_transfers
(
    id          varchar(255) not null,
    created_at  timestamp(6) not null,
    created_by  varchar(255),
    modified_by varchar(255),
    updated_at  timestamp(6),
    deleted_at  timestamp(6),
    is_deleted  boolean,
    amount      numeric(38, 2),
    source_id   varchar(255),
    target_id   varchar(255),
    primary key (id)
);
create table companies
(
    id                varchar(255) not null,
    created_at        timestamp(6) not null,
    created_by        varchar(255),
    modified_by       varchar(255),
    updated_at        timestamp(6),
    deleted_at        timestamp(6),
    is_deleted        boolean,
    fecha_de_adhesion timestamp(6),
    cuit              varchar(255),
    razon_social      varchar(255),
    primary key (id)
);
alter table if exists accounts add constraint FKpduos3mohw3vep07cj5fwplb7 foreign key (company_id) references companies;
alter table if exists bank_transfers add constraint FK2kv4c26lbe18b0rihjnwt4rot foreign key (source_id) references accounts;
alter table if exists bank_transfers add constraint FKsiagb7pwmuyxojdupj6eempw8 foreign key (target_id) references accounts;