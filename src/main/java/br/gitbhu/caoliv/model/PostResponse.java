package br.gitbhu.caoliv.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {
    private String mensagem;
    private LocalDateTime dateTime;

    public static PostResponse fromEntity(Posts posts){
        var response = new PostResponse();
        response.setMensagem(posts.getMensagem());
        response.setDateTime(posts.getDateTime());
        return response;
    }
}
