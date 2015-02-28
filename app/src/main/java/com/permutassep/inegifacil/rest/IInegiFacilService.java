package com.permutassep.inegifacil.rest;

import com.permutassep.inegifacil.model.City;
import com.permutassep.inegifacil.model.Town;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface  IInegiFacilService {

    @GET("/cities/{id}")
    void getCities(@Path("id") String id, Callback<ArrayList<City>> callback);

    @GET("/towns/{stateId}/{cityId}")
    void getTowns(@Path("stateId") String stateId, @Path("cityId") String cityId, Callback<ArrayList<Town>> callback);
}
