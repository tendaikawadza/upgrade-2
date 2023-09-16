package io.getarrays.securecapita.rowmapper;

import io.getarrays.securecapita.domain.PurchaseRequests;
import io.getarrays.securecapita.domain.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseRowMapper implements RowMapper<PurchaseRequests> {
    @Override
    public PurchaseRequests mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return PurchaseRequests.builder()
                .id(resultSet.getLong("id"))
                .requestName(resultSet.getString("request_name"))
                .requestDate(resultSet.getTimestamp("request_date").toLocalDateTime())
                .amount(resultSet.getInt("amount"))
                .quantity(resultSet.getInt("quantity"))
                .build();
    }
}
