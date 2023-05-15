# Sistema de Gerenciamento de Instituição de Ensino
O objetivo deste programa é gerenciar as informações dos estudantes, professores, disciplinas, turmas, matrículas e avaliações de uma instituição de ensino.

# Funcionalidades
O programa oferece as seguintes funcionalidades:

*Cadastro de alunos, professores, disciplinas e turmas;
*Matrícula de alunos em turmas;
*Registro de notas e faltas dos alunos nas avaliações;
*Consulta de informações dos alunos, professores, disciplinas e turmas;
-Geração de relatórios e estatísticas sobre desempenho dos alunos;
-Autenticação e autorização de usuários;
-Registro de eventos e erros;
-Armazenamento das informações em arquivos de texto ou objetos.

#Arquitetura do Programa
Cada entidade do modelo (Aluno, Professor, Disciplina, Turma, Matrícula, Avaliação) terá uma classe Controller e uma classe DAO que serão combinadas em uma única classe. As classes DAO serão responsáveis por realizar a leitura e escrita dos dados no arquivo ou objeto de armazenamento, enquanto as classes Controller serão responsáveis por gerenciar a lógica de negócios relacionada à entidade. Além disso, haverá uma classe de conexão com o arquivo ou objeto de armazenamento para fornecer acesso aos dados por meio das classes DAO.

##Interface de Usuário
Não haverá interface gráfica de usuário (GUI), portanto, todas as interações com o sistema serão realizadas por meio de entrada e saída de texto pelo console.

#Tecnologias Utilizadas
Programa desenvolvimento da linguagem de programação Java.

#Desenvolvido por: 
-Erlon Zefanias [Github de Erlon](https://github.com/ErlonZefaniasMuhate) 
-Glen Jonas [Github de Glen](https://github.com/contribuidor)
-Leuso Nguenha [Github de Leuso](https://github.com/leusonguenha)

##[Consulte o diagrama uml do sistema](https://github.com/ErlonZefaniasMuhate/SistemaGestaoEstudantes/blob/main/Diagrams/Diagrama1.0.drawio)
