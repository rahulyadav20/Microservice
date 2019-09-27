package com.metallica.client.model.response;

import com.metallica.client.model.entity.Commodity;
import com.metallica.model.response.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetAllCommoditiesResponse extends BaseResponse {

    List<Commodity> commodities;
}
