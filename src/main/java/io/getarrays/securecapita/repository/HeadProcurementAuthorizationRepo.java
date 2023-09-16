package io.getarrays.securecapita.repository;

import io.getarrays.securecapita.domain.HeadProcurementAuthorisation;
import io.getarrays.securecapita.domain.PurchaseRequests;

import java.util.List;

public interface HeadProcurementAuthorizationRepo<T extends HeadProcurementAuthorisation> {


      //  List<T> list();
        T create(T data);
//
//        T get(Long id);

    }
