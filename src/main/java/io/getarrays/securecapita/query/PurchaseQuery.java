package io.getarrays.securecapita.query;

public class PurchaseQuery {
    //public static final String SELECT_PURCHASE_REQUEST_BY_USER_ID_QUERY ="SELECT * FROM purchaserequests WHERE user_id = :userId";
    public static final String INSERT_PURCHASE_REQUEST_QUERY = "INSERT INTO purchaserequests ( request_name, amount, quantity, receiver_email ,status, signature) VALUES (  :requestName, :amount, :quantity,:receiverEmail, :status, :signature)";
    public static final String SELECT_PURCHASE_REQUEST_QUERY = "SELECT * FROM purchaserequests";
}
