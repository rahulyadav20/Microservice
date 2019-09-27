package com.mettalica.model.response;

import com.mettalica.model.Location;
import lombok.Data;

import java.util.List;

@Data
public class GetAllLocationsResponse extends BaseResponse {

    List<Location> locations;
}
