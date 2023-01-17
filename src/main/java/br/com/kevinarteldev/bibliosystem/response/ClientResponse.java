package br.com.kevinarteldev.bibliosystem.response;

import br.com.kevinarteldev.bibliosystem.request.ClientCreateRequest;
import lombok.Data;

@Data
public class ClientResponse extends ClientCreateRequest {
    private Integer id;
}
