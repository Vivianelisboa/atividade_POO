#Sistema de Gerenciamento de Filmes — Aplicação dos Princípios GRASP

Este projeto implementa um sistema simples de gerenciamento de filmes, estruturado em MVC e utilizando princípios GRASP para melhorar a organização e a qualidade do código.

Princípios GRASP Utilizados

Controller: Toda a lógica de operações foi centralizada na classe FilmeController, que coordena as ações entre View e Model.
Creator: O controller também é responsável por criar objetos da classe Filme, pois possui as informações necessárias para instanciá-los corretamente.
Baixo Acoplamento: As classes possuem poucas dependências entre si, deixando o sistema mais flexível e fácil de modificar.
Alta Coesão: Cada classe cumpre apenas sua responsabilidade: o Model representa os dados, o Controller gerencia as operações e a View apenas interage com o usuário.
