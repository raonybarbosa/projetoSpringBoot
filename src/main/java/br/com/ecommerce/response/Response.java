package br.com.ecommerce.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Error erros;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Response(Error erros) {
        this.erros = erros;
    }

    public Response(T data) {
        this.data = data;
    }
}
