package io.getarrays.securecapita.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;


@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class PurchaseRequests {
    private Long id;
    private String requestName;
    private LocalDateTime requestDate;
    private int amount;
    private int quantity;
    private String receiverEmail;
    private String signature;
    private String status;
}
