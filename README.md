# backend_test_liferay
backend java softwate engineer 


__regras de negócio da aplicação__

 * todos os produtos tem taxa de 10% exceto livros,remédios e comida.
 * caso o produto seja importado recebe 5% adicional ao imposto já acumulado.
 * os impostos são somados antes do faturamento do produto, logo um produto taxável e importado teria 15% de imposto ( 10% normal e 5% de importação).
 * não pode-se aplicar um imposto após o faturamento do produto, tendo ele já recebido taxação anterior ou não.
 * produtos isentos por categoria devem receber imposto de importação (caso sejam importados).
 * regra de arredondamento de cinco centavos pra cima quando o produto for taxado.
 * Após o faturamento deve ser impresso um recibo com os valores dos produtos já tributados, a soma dos tributos e o total da compra tributada. 

__Arquitetura__

* Clean
  * Iniciei o processo que levará o projeto a uma arquitetura limpa e desacoplada, separando as regras do negócio, as entidades, recursos externos (se houverem no futuro) trazendo manutenbilidade e escalabilidade ao projeto.

__Code Design__

* Utilizei alguns dos princípios do ___SOLID___ pensando sempre na manutencão, entendimento e escalabilidade da aplicação.
  * __Responsabilidade única:__ cada objeto no projeto foi pensado para ter apenas uma responsabilidade, como "representar uma entidade de domínio" ou "fazer arredondamento de valores"
  * ![image](https://user-images.githubusercontent.com/6961441/111087037-33c46280-84fe-11eb-96b6-36cbbf154905.png)
  * __Open/close:__ criei os objetos de modo que se por ventura as regras de negócio mudarem não precisaríamos fazer alterações nas classes de serviço, apenas uma extensão das regras recebendo uma nova validação ou removendo-a. Recebemos listas de interaces que tem implementações voltadas a regra, dessa forma a classe de serviço fica fechada para modificação.
  * ![image](https://user-images.githubusercontent.com/6961441/111087415-40e25100-8500-11eb-8a46-9f5d5b3dde8d.png)
  * __segregação de interfaces & inversão de dependencias:__ : as interfaces foram criadas pensando em não haver classes que implementem métodos e recebam atributos que não não vão usar, assim como as implementações dependem das abstrações para serem utilizadas e extendidas no código fazendo que a abstração seja mais importante que a própria implementação.

__metodologia de teste__: 

* __TDD:__ inicialmente criei uma bateria de testes para validar a criação das entidades e posteriormente as regras de tributação, a partir daí fui criando os métodos de validação, tributação, arrendondamento e criação do recibo. Ajustando as regras aos testes já existentes, também criei mock's dos objetos necessários para cada ocasião para agilizar a criação de testes futuramente.
![image](https://user-images.githubusercontent.com/6961441/111087967-894f3e00-8503-11eb-8f04-f6aff14efc09.png)
![image](https://user-images.githubusercontent.com/6961441/111087984-a257ef00-8503-11eb-9786-26a3bfc0971b.png)
![image](https://user-images.githubusercontent.com/6961441/111088020-daf7c880-8503-11eb-9a79-8d712953e68a.png)

__OUTPUTS__

* __OutPut 1 :__
  * ![image](https://user-images.githubusercontent.com/6961441/111088424-db915e80-8505-11eb-89af-39d78b6368e9.png)
* __OutPut 2 :__
  * ![image](https://user-images.githubusercontent.com/6961441/111088460-13000b00-8506-11eb-92dd-c774964195cc.png)
* __OutPut 3 :__
  * ![image](https://user-images.githubusercontent.com/6961441/111088495-3b880500-8506-11eb-8764-5d729a16cf57.png)
