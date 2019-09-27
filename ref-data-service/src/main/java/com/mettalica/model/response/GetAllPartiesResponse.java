package com.mettalica.model.response;

import com.mettalica.model.Party;
import lombok.Data;

import java.util.List;

@Data
public class GetAllPartiesResponse extends BaseResponse {

    List<Party> parties;
}
