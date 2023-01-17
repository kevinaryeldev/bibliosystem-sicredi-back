package br.com.kevinarteldev.bibliosystem.response;

import br.com.kevinarteldev.bibliosystem.request.CopyCreateRequest;
import lombok.Data;

@Data
public class CopyResponse extends CopyCreateRequest {
    private Integer id;
}
