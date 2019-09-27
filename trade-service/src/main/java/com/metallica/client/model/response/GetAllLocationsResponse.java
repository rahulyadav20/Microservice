package com.metallica.client.model.response;

import com.metallica.client.model.entity.Location;
import com.metallica.model.response.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetAllLocationsResponse extends BaseResponse {

    List<Location> locations;
}
