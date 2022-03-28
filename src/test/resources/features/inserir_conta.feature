#language: pt
Funcionalidade: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#  Contexto será aproveitado nos outros, então torna menos repetitivos
  Contexto:
    Dado que desejo adicionar uma conta


  Esquema do Cenário: Deve validar regras cadastro contas
    Quando adiciono a "<conta>"
    Então recebo a "<mensagem>"

    Exemplos:
      | conta          | mensagem                           |
      | Conta de Teste | Conta adicionada com sucesso!      |
      |                | Informe o nome da conta            |
      | Conta de Teste | Já existe uma conta com esse nome! |