# http-error-response
Http error response example using Spring boot

Exemplo de como construir um mecanismo de uso do padrão da [RFC 7807](https://tools.ietf.org/rfc/rfc7807.txt).

### Como foi feito

* HTTP Status Code 4XX e 5XX são representados por Exceptions Runtime
`public class BadRequestException extends HttpResponseException {`

* Foi criada a classe `HttpResponseException` para abstrair a lógica do construtor e da criação do objeto de resposta dos erros
* A classe `RestExceptionHandler` fica responsável por tratar a hieraraquia de classes e responder ao client nos casos de erro
* O chamador para montar precisa apenas lançar a Exception com os dados que deseja a apresentar no response, considerando os detalhes da RFC, exemplos:

	* Sem passar field `instance`
`throw new ConflictException("Usuario já existe", Optional.empty(), Resources.USERS);`
	* Passando field `instance`
`throw new BadRequestException("Dados inválidos", Optional.of(List.of("id", "name", "age")), Resources.USERS);`

