package io.getarrays.securecapita.repository.implementation;

import io.getarrays.securecapita.domain.HeadProcurementAuthorisation;
import io.getarrays.securecapita.domain.PurchaseRequests;
import io.getarrays.securecapita.query.PurchaseQuery;
import io.getarrays.securecapita.repository.HeadProcurementAuthorizationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class HeadProcuementAuthorisationImpl implements HeadProcurementAuthorizationRepo<HeadProcurementAuthorisation> {

    private final NamedParameterJdbcTemplate jdbc;
    @Override
    public HeadProcurementAuthorisation create(HeadProcurementAuthorisation headProcurementAuthorisation) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(headProcurementAuthorisation);
        jdbc.update(HeadProcurementAuthorisationQuery.INSERT_HeadProcurementAuthorisation_QUERY,parameters, holder);
        return headProcurementAuthorisation;
    }

    private SqlParameterSource getSqlParameterSource(HeadProcurementAuthorisation headProcurementAuthorisation) {
        return new MapSqlParameterSource()

                .addValue("requestName", purchaseRequests.getRequestName())
                .addValue("amount", purchaseRequests.getAmount())
                .addValue("quantity",purchaseRequests.getQuantity())
                .addValue("receiverEmail",purchaseRequests.getReceiverEmail())
                .addValue("status",purchaseRequests.getStatus())
                .addValue("signature", purchaseRequests.getSignature());
    }






}
