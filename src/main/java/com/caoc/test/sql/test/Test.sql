-- auto-generated definition
create table stage_order
(
    order_no                 varchar(45)                            not null comment '订单号'
        primary key,
    uid                      char(36)                               null comment '用户uid',
    card_id                  char(50)                               null,
    principle                int                                    null comment '本金',
    stage                    int                                    null comment '分期数',
    status                   varchar(45)                            null comment '还款状态',
    fee_rate                 decimal(9, 6)                          null comment '总手续费费率',
    cooperator_fee_rate      decimal(9, 6)                          null comment '合作方手续费率',
    interest_rate            decimal(9, 6)                          null comment '逾期手续费率',
    cooperator_interest_rate decimal(9, 6)                          null comment '合作方逾期手续费率',
    late_fee_rate            decimal(9, 6)                          null comment '滞纳金费率',
    cooperator_late_fee_rate decimal(9, 6)                          null comment '合作方滞纳金费率',
    exceed_status            varchar(45)                            null comment '逾期状态',
    cut_day_exceed_status    varchar(45)                            null,
    exceed_day               int                                    null comment '逾期天数',
    first_interest_date      date                                   null,
    created_at               datetime    default CURRENT_TIMESTAMP  null comment '创建时间',
    updated_at               datetime    default CURRENT_TIMESTAMP  null on update CURRENT_TIMESTAMP comment '更新时间',
    trans_log_id             char(36)                               null,
    early_settlement         varchar(20)                            null,
    contract_no              varchar(30)                            null,
    cus_order_no             varchar(45)                            null,
    bank                     varchar(45)                            null comment '订单路由的银行',
    account_no               char(36)                               null,
    business_type            varchar(45) default 'BALANCE_TRANSFER' null,
    refund                   tinyint(1)  default 0                  null,
    product                  varchar(45)                            null,
    creation_serial          varchar(100)                           null comment '创建订单查询流水',
    ext                      varchar(300)                           null,
    channel                  varchar(50)                            null,
    annual_fee_rate          decimal(9, 6)                          null comment '年化利率',
    inc_id                   bigint                                 null comment '自增id'
);

create index idx_account_no
    on stage_order (account_no);

create index idx_created_at
    on stage_order (created_at);

create index idx_creation_serial
    on stage_order (creation_serial);

create index idx_cus_order_no
    on stage_order (cus_order_no);

create index idx_status
    on stage_order (status);

create index idx_trans_log_id
    on stage_order (trans_log_id);

create index idx_uid
    on stage_order (uid);

z