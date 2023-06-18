/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

/**
 *
 * @author Erlon Z. Muhate 
 * Enumeração que representa as constantes do sistema.
 * <p>
 * As constantes são usadas para representar diferentes tipos de avaliação,
 * docentes, disciplinas, regimes de estudo e níveis de acesso de
 * administradores.
 */
public class Constants {
    /**
     * Enum que representa os tipos de docentes em um sistema de gestão de estudantes.
     */
    public enum TipoDeDocente {
        /**
         * Representa um tipo de docente regente.
         */
        REGENTE("Regente", "Responsável pela coordenação e direção de disciplinas e cursos."),
        /**
         * Representa um tipo de docente assistente.
         */
        ASSISTENTE("Assistente", "Auxilia na realização de atividades didáticas e de pesquisa.");

        private final String descricao;
        private final String detalhes;

        /**
         * Construtor do TipoDeDocente.
         *
         * @param descricao A descrição do tipo de docente.
         * @param detalhes  Os detalhes sobre o tipo de docente.
         */
        TipoDeDocente(String descricao, String detalhes) {
            this.descricao = descricao;
            this.detalhes = detalhes;
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
    }
    
    /**
     * Enumeração que representa os tipos de avaliação.
     */
    public enum TipoAvaliacao {
        /**
         * Representa um tipo de avaliação de teste.
         */
        TESTE("Teste", "Avaliação realizada em sala de aula para testar o conhecimento dos alunos."),

        /**
         * Representa um tipo de avaliação para trabalho em casa.
         */
        TRABALHO_CASA("Trabalho em Casa", "Atividade avaliativa realizada fora da sala de aula."),

        /**
         * Representa um tipo de avaliação de exame normal.
         */
        EXAME_NORMAL("Exame Normal", "Avaliação final do conteúdo estudado em uma disciplina durante um semestre."),

        /**
         * Representa um tipo de avaliação de exame de recorrência.
         */
        EXAME_RECORRENCIA("Exame de Recorrência", "Avaliação aplicada aos alunos que não obtiveram êxito no exame normal.");

        private final String detalhes;
        private final String descricao;

        /**
         * Construtor do tipo de avaliação.
         *
         * @param detalhes   Os detalhes do tipo de avaliação.
         * @param descricao  A descrição do tipo de avaliação.
         */
        TipoAvaliacao(String detalhes, String descricao) {
            this.detalhes = detalhes;
            this.descricao = descricao;
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
        NUCLEAR("Disciplina Nuclear", "Disciplinas fundamentais e obrigatórias do curso."),

        /**
         * Representa uma disciplina livre.
         *
         * Disciplinas opcionais para o aluno, cuja certificação não depende delas.
         */
        LIVRE("Disciplina Livre", "Disciplinas opcionais, sem impacto na certificação do aluno."),

        /**
         * Representa uma disciplina complementar.
         *
         * Disciplinas complementares são disciplinas obrigatórias que abrangem áreas
         * distintas do curso principal, proporcionando aos estudantes conhecimentos
         * adicionais e aprofundamento em temas complementares ao campo de estudo principal.
         */
        COMPLEMENTAR("Disciplina Complementar", "Disciplinas obrigatórias que ampliam o conhecimento em áreas complementares ao curso principal.");

        private final String descricao;
        private final String detalhes;

        TipoDeDisciplina(String descricao, String detalhes) {
            this.descricao = descricao;
            this.detalhes = detalhes;
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
    }

    /**
     * Enum que representa os níveis de acesso dos administradores no sistema.
     */
    public enum NiveisDeAcesso {
        /**
         * Representa o nível de acesso de super administrador.
         * Os administradores com este nível de acesso têm acesso completo ao sistema.
         */
        SUPER_ADMIN("Super Administrador", "Acesso completo ao sistema."),
        /**
         * Representa o nível de acesso de departamento.
         * Os administradores com este nível de acesso podem fazer alterações no departamento designado.
         */
        DEPARTAMENTO("Departamento", "Permissão para realizar alterações no departamento designado."),
        /**
         * Representa o nível de acesso de curso.
         * Os administradores com este nível de acesso podem fazer alterações no curso designado.
         */
        CURSO("Curso", "Permissão para realizar alterações no curso designado."),
        /**
         * Representa o nível de acesso de turma.
         * Os administradores com este nível de acesso podem fazer alterações na turma designada.
         */
        TURMA("Turma", "Permissão para realizar alterações na turma designada.");

        private final String descricao;
        private final String detalhes;

        NiveisDeAcesso(String descricao, String detalhes) {
            this.descricao = descricao;
            this.detalhes = detalhes;
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
    }

    /**
     * Enum que representa os regimes de estudo disponíveis no sistema educacional.
     */
    public enum RegimeDeEstudo {
        NOCTURNO("Regime Noturno", "Os estudantes frequentam as aulas predominantemente durante a noite."),
        DIURNO("Regime Diurno", "Os estudantes frequentam as aulas predominantemente durante o dia."),
        A_DISTANCIA("Regime a Distância", "Os estudantes têm a flexibilidade de estudar de forma remota, utilizando recursos online e materiais disponibilizados pela instituição.");

        private final String descricao;
        private final String detalhes;

        RegimeDeEstudo(String descricao, String detalhes) {
            this.descricao = descricao;
            this.detalhes = detalhes;
        }

        /**
         * Obtém a descrição do regime de estudo.
         *
         * @return a descrição do regime de estudo.
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * Obtém os detalhes do regime de estudo.
         *
         * @return os detalhes do regime de estudo.
         */
        public String getDetalhes() {
            return detalhes;
        }
    }

    public enum TipoDeEmail{
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
     * Enumeração dos possíveis estados de um usuário em um sistema de gestão de estudantes.
     */
    public enum EstadoUsuario {
        /**
         * Representa um usuário ativo no sistema.
         */
        ATIVO("Ativo"),
        /**
         * Representa um usuário inativo no sistema.
         */
        INATIVO("Inativo"),
        /**
         * Representa um usuário possui cadastro pendente e aguarda aprovação.
         */
        PENDENTE("Pendente"),
        /**
         * Representa um usuário graduado, que concluiu os requisitos
         * acadêmicos.
         */
        GRADUADO("Graduado"),
        /**
         * Representa um usuário com matrícula trancada temporariamente.
         */
        TRANCADO("Trancado"),
        /**
         * Representa um usuário transferido para outra instituição.
         */
        TRANSFERIDO("Transferido"),
        /**
         * Representa um usuário com matrícula cancelada permanentemente.
         */
        CANCELADO("Cancelado"),
        /**
         * Representa um usuário inadimplente, com pendências financeiras.
         */
        INADIMPLENTE("Inadimplente"),
        /**
         * Representa um usuário ex-aluno, que já foi estudante mas não está
         * mais matriculado.
         */
        EX_ALUNO("Ex-aluno");

        private final String status;
        
        private EstadoUsuario(String status) {
            this.status = status;
        }
        
        public String getStatus() {
            return status;
        }
    }    
}
