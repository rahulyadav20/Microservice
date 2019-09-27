package com.metallica.client.model.response;

import com.metallica.client.model.entity.Party;
import com.metallica.model.response.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetAllPartiesResponse extends BaseResponse {

    List<Party> parties;
}
