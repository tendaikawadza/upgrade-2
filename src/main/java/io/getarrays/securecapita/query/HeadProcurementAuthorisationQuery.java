package io.getarrays.securecapita.query;

public class HeadProcurementAuthorisationQuery {
    public static final String INSERT_PURCHASE_REQUEST_QUERY = "INSERT INTO purchaserequests ( request_name, amount, quantity, receiver_email ,status, signature) VALUES (  :requestName, :amount, :quantity,:receiverEmail, :status, :signature)";
}
