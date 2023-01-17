package br.com.kevinarteldev.bibliosystem.service;

import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.request.CopyCreateRequest;
import br.com.kevinarteldev.bibliosystem.response.CopyResponse;
import br.com.kevinarteldev.bibliosystem.repository.CopyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CopyService {
    private final ObjectMapper objectMapper;
    private final CopyRepository copyRepository;
    public void delete(Integer id){
    }
    public void edit(Integer id, CopyCreateRequest fonteOrigem){
    }
    public CopyResponse create(CopyCreateRequest fonteOrigem) {
        return null;
    }

    public PageResponse<CopyResponse> list(int i, int i1) {
        return new PageResponse<>();
    }
}
