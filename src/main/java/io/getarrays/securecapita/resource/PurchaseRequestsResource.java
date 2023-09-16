package io.getarrays.securecapita.resource;

import io.getarrays.securecapita.domain.HttpResponse;
import io.getarrays.securecapita.domain.PurchaseRequests;
import io.getarrays.securecapita.dto.UserDTO;
import io.getarrays.securecapita.event.NewUserEvent;
import io.getarrays.securecapita.service.PurchaseRequestsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

import static io.getarrays.securecapita.enumeration.EventType.PROFILE_PICTURE_UPDATE;
import static io.getarrays.securecapita.utils.UserUtils.getAuthenticatedUser;
import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/purchase")
@RequiredArgsConstructor
@Slf4j
public class PurchaseRequestsResource {

    private final PurchaseRequestsService purchaseRequestsService;

    @PostMapping("/create")
    public ResponseEntity<PurchaseRequests> createPurchase(@RequestBody PurchaseRequests purchaseRequests) {
        log.info("Payload: {}",purchaseRequests.toString());
        return ResponseEntity.ok(
                purchaseRequestsService.createPurchaseRequest(purchaseRequests)
        );
    }


    @GetMapping(path = "/get/{id}")
    public ResponseEntity<PurchaseRequests> findById(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(purchaseRequestsService.getPurchaseRequestById(userId));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<PurchaseRequests>> findAll() {
        return ResponseEntity.ok(purchaseRequestsService.getAllPurchaseRequests());
    }
    @PatchMapping("/update/signature")
    public ResponseEntity<HttpResponse> updateSignatureImage(Authentication authentication, @RequestParam("image") MultipartFile image) throws InterruptedException {

        PurchaseRequests purchaseRequests = purchaseRequestsService.loadImage(authentication, image);

        // Validate the image file
        if (image.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Image file is required.")
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build()
            );
        }

        try {

            purchaseRequestsService.saveImage(purchaseRequests, image);

            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Signature image updated.")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Failed to update signature image.")
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build()
            );
        }
    }





}
