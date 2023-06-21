/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

/**
 *
 * @author Erlon Z. Muhate Enumeração que representa as constantes do sistema.
 * <p>
 * As constantes são usadas para representar diferentes tipos de avaliação,
 * docentes, disciplinas, regimes de estudo e níveis de acesso de
 * administradores.
 */
public abstract class Constants {
    
    /**
     * Enum que representa os tipos de docentes em um sistema de gestão de
     * estudantes.
     */
    public enum TituloDoDocente {
        /**
         * Representa um tipo de docente regente.
         */
        REGENTE(1, "Regente", "Responsável pela coordenação e direção de disciplinas e cursos."),
        /**
         * Representa um tipo de docente assistente.
         */
        ASSISTENTE(2, "Assistente", "Auxilia na realização de atividades didáticas e de pesquisa.");

        private final String descricao;
        private final String detalhes;
        private final Integer index;

        /**
         * Construtor do TipoDeDocente.
         *
         * @param descricao A descrição do tipo de docente.
         * @param detalhes Os detalhes sobre o tipo de docente.
         */
        TituloDoDocente(Integer index, String descricao, String detalhes) {
            this.descricao = descricao;
            this.detalhes = detalhes;
            this.index = index;
        }

        /**
         * Obtém a descrição do tipo de docente.
         *
         * @return A descrição do tipo de docente.
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * Obtém os detalhes sobre o tipo de docente.
         *
         * @return Os detalhes sobre o tipo de docente.
         */
        public String getDetalhes() {
            return detalhes;
        }

        @Override
        public String toString() {
            return "Titulo do Docente: " + descricao + "\n" + "Detalhes: " + detalhes;
        }

        public int printAll() {
            int highIndex = 0;
            for (var typeToPrint : TituloDoDocente.values()) {
                System.out.println(typeToPrint.index + ". " + typeToPrint.descricao);
                highIndex++;
            }
            return highIndex;
        }

        public TituloDoDocente getByIndex(int index) {
            for (TituloDoDocente docente : TituloDoDocente.values()) {
                if (docente.index == index) {
                    return docente;
                }
            }
            return null;
        }
    }

    /**
     * Enumeração que representa os tipos de avaliação.
     */
    public enum TipoDeAvaliacao {
        /**
         * Representa um tipo de avaliação de teste.
         */
        TESTE(1, "Teste", "Avaliação realizada em sala de aula para testar o conhecimento dos alunos."),
        /**
         * Representa um tipo de avaliação para trabalho em casa.
         */
        TRABALHO_CASA(2, "Trabalho em Casa", "Atividade avaliativa realizada fora da sala de aula."),
        /**
         * Representa um tipo de avaliação de exame normal.
         */
        EXAME_NORMAL(3, "Exame Normal", "Avaliação final do conteúdo estudado em uma disciplina durante um semestre."),
        /**
         * Representa um tipo de avaliação de exame de recorrência.
         */
        EXAME_RECORRENCIA(4, "Exame de Recorrência", "Avaliação aplicada aos alunos que não obtiveram êxito no exame normal.");

        private final String detalhes;
        private final String descricao;
        private final int index;

        /**
         * Construtor do tipo de avaliação.
         *
         * @param detalhes Os detalhes do tipo de avaliação.
         * @param descricao A descrição do tipo de avaliação.
         */
        TipoDeAvaliacao(int index, String detalhes, String descricao) {
            this.detalhes = detalhes;
            this.descricao = descricao;
            this.index = index;
        }

        /**
         * Obtém os detalhes do tipo de avaliação.
         *
         * @return Os detalhes do tipo de avaliação.
         */
        public String getDetalhes() {
            return detalhes;
        }

        /**
         * Obtém a descrição do tipo de avaliação.
         *
         * @return A descrição do tipo de avaliação.
         */
        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return "Tipo de avaliacao: " + getDescricao() + "\n" + "Detalhes: " + getDetalhes();
        }

        public int printAll() {
            int highIndex = 0;
            for (var examType : TipoDeAvaliacao.values()) {
                System.out.println(examType.index + ". " + examType.descricao);
                highIndex++;
            }
            return highIndex;
        }

        public TipoDeAvaliacao getByIndex(int index) {
            for (var examType : TipoDeAvaliacao.values()) {
                if (examType.index == index) {
                    return examType;
                }
            }
            return null;
        }
    }

    /**
     * Enum que representa os tipos de disciplina em um sistema educacional.
     */
    public enum TipoDeDisciplina {
        /**
         * Representa uma disciplina nuclear.
         *
         * As disciplinas nucleares de um curso são aquelas fundamentais e
         * obrigatórias para a formação acadêmica e profissional na área
         * específica do curso.
         */
        NUCLEAR(1, "Disciplina Nuclear", "Disciplinas fundamentais e obrigatórias do curso."),
        /**
         * Representa uma disciplina livre.
         *
         * Disciplinas opcionais para o aluno, cuja certificação não depende
         * delas.
         */
        LIVRE(2, "Disciplina Livre", "Disciplinas opcionais, sem impacto na certificação do aluno."),
        /**
         * Representa uma disciplina complementar.
         *
         * Disciplinas complementares são disciplinas obrigatórias que abrangem
         * áreas distintas do curso principal, proporcionando aos estudantes
         * conhecimentos adicionais e aprofundamento em temas complementares ao
         * campo de estudo principal.
         */
        COMPLEMENTAR(3, "Disciplina Complementar", "Disciplinas obrigatórias que ampliam o conhecimento em áreas complementares ao curso principal.");

        private final String descricao;
        private final String detalhes;
        private final int index;

        TipoDeDisciplina(int index, String descricao, String detalhes) {
            this.descricao = descricao;
            this.detalhes = detalhes;
            this.index = index;
        }

        /**
         * Obtém a descrição do tipo de disciplina.
         *
         * @return a descrição do tipo de disciplina.
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * Obtém os detalhes do tipo de disciplina.
         *
         * @return os detalhes do tipo de disciplina.
         */
        public String getDetalhes() {
            return detalhes;
        }

        @Override
        public String toString() {
            return "Tipo de disciplina: " + getDescricao() + "\n" + "Detalhes: " + getDetalhes();
        }

        public int printAll() {
            int highIndex = 0;
            for (var subjectType : TipoDeDisciplina.values()) {
                System.out.println(subjectType.index + ". " + subjectType.descricao);
                highIndex++;
            }
            return highIndex;
        }

        public TipoDeDisciplina getByIndex(int index) {
            for (var subjectType : TipoDeDisciplina.values()) {
                if (subjectType.index == index) {
                    return subjectType;
                }
            }
            return null;
        }
    }

    /**
     * Enum que representa os níveis de acesso dos administradores no sistema.
     */
    public enum NiveisDeAcesso {
        /**
         * Representa o nível de acesso de super administrador. Os
         * administradores com este nível de acesso têm acesso completo ao
         * sistema.
         */
        SUPER_ADMIN(1, "Super Administrador", "Acesso completo ao sistema."),
        /**
         * Representa o nível de acesso de departamento. Os administradores com
         * este nível de acesso podem fazer alterações no departamento
         * designado.
         */
        DEPARTAMENTO(2, "Departamento", "Permissão para realizar alterações no departamento designado."),
        /**
         * <p>
         * Representa o nível de acesso de curso.</p>
         * <br>
         * <p>
         * Os administradores com este nível de acesso podem fazer
         * <strong>alterações no curso designado.</strong></p>
         */
        CURSO(3, "Curso", "Permissão para realizar alterações no curso designado."),
        /**
         * Representa o nível de acesso de turma. Os administradores com este
         * nível de acesso podem fazer alterações na turma designada.
         */
        TURMA(4, "Turma", "Permissão para realizar alterações na turma designada.");

        private final String descricao;
        private final String detalhes;
        private final int index;

        NiveisDeAcesso(int index, String descricao, String detalhes) {
            this.descricao = descricao;
            this.detalhes = detalhes;
            this.index = index;
        }

        /**
         * Obtém a descrição do nível de acesso.
         *
         * @return a descrição do nível de acesso.
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * Obtém os detalhes do nível de acesso.
         *
         * @return os detalhes do nível de acesso.
         */
        public String getDetalhes() {
            return detalhes;
        }

        @Override
        public String toString() {
            return "Nivel de acesso: " + getDescricao() + "\n" + "Detalhes: " + getDetalhes();
        }

        public int printAll() {
            int highIndex = 0;
            for (var levelToPrint : NiveisDeAcesso.values()) {
                System.out.println(levelToPrint.index + ". " + levelToPrint.descricao);
                highIndex++;
            }
            return highIndex;
        }

        public NiveisDeAcesso getByIndex(int index) {
            for (var acessLevel : NiveisDeAcesso.values()) {
                if (acessLevel.index == index) {
                    return acessLevel;
                }
            }
            return null;
        }
    }

    /**
     * Enum que representa os regimes de estudo disponíveis no sistema
     * educacional.
     */
    public enum RegimeDeEstudo {
        NOCTURNO(1, "Regime Noturno", "Os estudantes frequentam as aulas predominantemente durante a noite, oferecendo flexibilidade para aqueles que trabalham durante o dia."),
        DIURNO(2, "Regime Diurno", "Os estudantes frequentam as aulas predominantemente durante o dia, permitindo maior interação presencial com professores e colegas."),
        A_DISTANCIA(3, "Regime a Distância", "Os estudantes têm a flexibilidade de estudar de forma remota, utilizando recursos online e materiais disponibilizados pela instituição, permitindo conciliar os estudos com outras responsabilidades.");

        private final int indice;
        private final String descricao;
        private final String detalhes;

        RegimeDeEstudo(int indice, String descricao, String detalhes) {
            this.indice = indice;
            this.descricao = descricao;
            this.detalhes = detalhes;
        }

        /**
         * Obtém o índice do regime de estudo.
         *
         * @return O índice do regime de estudo.
         */
        public int getIndice() {
            return indice;
        }

        /**
         * Obtém a descrição do regime de estudo.
         *
         * @return A descrição do regime de estudo.
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * Obtém os detalhes do regime de estudo.
         *
         * @return Os detalhes do regime de estudo.
         */
        public String getDetalhes() {
            return detalhes;
        }

        /**
         * Retorna uma representação em formato de string do regime de estudo.
         *
         * @return A representação em formato de string do regime de estudo.
         */
        @Override
        public String toString() {
            return "Regime de estudo: " + detalhes + "\n" + "Detalhes: " + descricao;
        }

        public int printAll() {
            int highIndex = 0;
            for (var periodToPrint : RegimeDeEstudo.values()) {
                System.out.println(periodToPrint.indice + ". " + periodToPrint.descricao);
                highIndex++;
            }
            return highIndex;
        }

        public RegimeDeEstudo getByIndex(int index) {
            return values()[index];
        }
    }

    /**
     * Enumeração que representa os possíveis estados de uma disciplina.
     */
    public enum EstadoDaDisciplina {
        /**
         * Estado da disciplina quando realizado o exame normal ou de
         * recorrência com sucesso.
         */
        APROVADO("Aprovado", "Realizou o exame normal ou de recorrência com sucesso."),
        /**
         * Estado da disciplina quando realizado o exame normal ou de
         * recorrência sem sucesso.
         */
        REPROVADO("Reprovado", "Realizou o exame normal ou de recorrência sem sucesso"),
        /**
         * Estado da disciplina quando dispensada.
         */
        DISPENSADO("Dispensado", "Teve media final suficiente para ser dispensado dos exames"),
        /**
         * Estado da disciplina durante o período letivo antes de serem feitas
         * todas as avaliações.
         */
        EM_CURSO("Em Curso", "Período lectivo em curso, ha avaliações por realizar"),
        /**
         * Estado da disciplina não cursada.
         */
        POR_CURSAR("Por Cursar", "Disciplina nao cursada"),
        /**
         * Estado da disciplina quando a média final de frequência for
         * suficiente para realização do exame, mas insuficiente para dispensa
         * do exame.
         */
        ADMITIDO("Admitido", "A média final de frequência e suficiente para realização, mas insuficiente para dispensa do exame."),
        /**
         * Estado da disciplina quando a média final de frequência for
         * insuficiente para realização do exame.
         */
        EXCLUIDO("Excluído", "A média final de frequência e insuficiente para realização do exame.");

        private final String descricao;
        private final String detalhes;

        /**
         * Construtor do EstadoDaDisciplina.
         *
         * @param descricao A descrição do estado.
         */
        EstadoDaDisciplina(String descricao, String detalhes) {
            this.descricao = descricao;
            this.detalhes = detalhes;
        }

        /**
         * Retorna a descrição do estado.
         *
         * @return A descrição do estado.
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * Retorna a representação em string do estado.
         *
         * @return A descrição do estado.
         */
        @Override
        public String toString() {
            return "Estado da disciplina: " + descricao + "\n" + "Detalhes: " + detalhes;
        }
    }

    public enum TipoDeEmail {
        DOMINIO_EMAIL("@uem.ac.mz"),
        STANDARD_EMAIL("nousername@example.com"),
        SUPPORT_EMAIL("support@example.com"),
        ADMIN_EMAIL("admin@example.com"),
        MARKETING_EMAIL("marketing@example.com");

        private final String email;

        private TipoDeEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
    }

    /**
     * Enumeração dos possíveis estados de um usuário em um sistema de gestão de
     * estudantes.
     */
    public enum EstadoUsuario {
        /**
         * Representa um usuário ativo no sistema.
         */
        ATIVO("Ativo", "Usuário ativo no sistema"),
        /**
         * Representa um usuário inativo no sistema.
         */
        INATIVO("Inativo", "Usuário inativo no sistema"),
        /**
         * Representa um usuário possui cadastro pendente e aguarda aprovação.
         */
        PENDENTE("Pendente", "Cadastro pendente,aguarde aprovação"),
        /**
         * Representa um usuário graduado, que concluiu os requisitos
         * acadêmicos.
         */
        GRADUADO("Graduado", "Usuário graduado, que concluiu os requisitos acadêmicos"),
        /**
         * Representa um usuário com matrícula trancada temporariamente.
         */
        TRANCADO("Trancado", "Usuário com matrícula trancada temporariamente"),
        /**
         * Representa um usuário transferido para outra instituição.
         */
        TRANSFERIDO("Transferido", "Usuário transferido para outra instituição"),
        /**
         * Representa um usuário com matrícula cancelada permanentemente.
         */
        CANCELADO("Cancelado", "Usuário com matrícula cancelada permanentemente"),
        /**
         * Representa um usuário inadimplente, com pendências financeiras.
         */
        INADIMPLENTE("Inadimplente", "Usuário com pendências financeiras"),
        /**
         * <p>
         * Representa um usuário ex-aluno, que já foi estudante mas não está
         * mais matriculado.</p>
         */
        EX_ALUNO("Ex-aluno", "O usuário já foi estudante, mas não está mais matriculado");

        private final String status;
        private final String detalhes;

        private EstadoUsuario(String status, String detalhes) {
            this.status = status;
            this.detalhes = detalhes;
        }

        public String getStatus() {
            return status;
        }

        public String getDetalhes() {
            return detalhes;
        }

        @Override
        public String toString() {
            return "Estado do Usuario: " + status + "\n" + "Detalhes: " + detalhes;
        }
    }
}
