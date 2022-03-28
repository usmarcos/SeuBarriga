##language: pt
#Funcionalidade: Cadastro de contas
#
#  Como um usuário
#  Gostaria de alterar contas
#  Para que eu possa corrigir um dado incorreto
#
#  Contexto:
#    Dado que estou acessando a aplicação
#    Quando informo o usuário "us@us.com"
#    E a senha "us"
#    E seleciono entrar
#    Então visualizo a página inicial
#    Quando seleciono Contas
#    E seleciono Listar
#
#  Esquema do Cenário: Deve validar regras de alteração de contas
#    Quando clico em alterar a "<conta>"
#    Então altero para "<contaAlterada>"
#    E seleciono Salvar
#    Então recebo a "<mensagem>" de alteração
#
#    Exemplos:
#      | conta              | contaAlterada  | mensagem                    |
#      | Conta para alterar | Conta alterada | Conta alterada com sucesso! |
#
#
#
