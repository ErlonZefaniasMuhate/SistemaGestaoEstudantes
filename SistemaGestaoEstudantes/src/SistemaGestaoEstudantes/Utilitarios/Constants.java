/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * The Constants class represents a collection of enums separated by categories
 * and provides methods for printing enum values and retrieving enums by index
 * using the reflection API.
 * <h2>Enums and Categories:</h2>
 * <p>
 * The class holds a collection of enums (inner classes) that are categorized
 * based on their functionality and purpose. Some enums contain descriptions,
 * details, and an index. Users can manually select values from these enums.</p>
 * <h2>Enum Operations:</h2>
 * <p>
 * The inner class <code>EnumOperations</code> defines an interface that
 * provides methods for printing all enum values along with their index and
 * retrieving an enum by its index. The enums in Constants override these
 * methods to implement the desired functionality.</p>
 * <h2>Reflection API Usage:</h2>
 * <p>
 * The Constants class utilizes the reflection API to invoke the
 * <code>printAll</code> and <code>getByIndex</code> methods defined in all the
 * enums that implement the EnumOperations interface. These methods are executed
 * dynamically at runtime, allowing for flexible handling of enum values.</p>
 * <p>
 * <strong>Note:</strong> The Constants class serves as a centralized repository
 * for categorized enums and provides an inner interface with convenient methods
 * for accessing and manipulating these enum values.</p>
 * <h3>Usage:</h3>
 * <pre>{@code
 * 
 * // Accessing enum values
 * Category1Enum value1 = Constants.Category1Enum.ENUM1;
 * Category2Enum value2 = Constants.Category2Enum.ENUM2;
 * 
 * // Printing all enum values and getting the highest index
 * int highIndex = Constants.executePrintAllMethod(Category1Enum.class);
 * int anotherHighIndex = Constants.executePrintAllMethod(Category2Enum.class);
 * 
 * // Retrieving enum by index
 * Category1Enum retrievedEnum = Constants.executeGetByIndexMethod(Category1Enum.class, 2);
 * }</pre>
 * 
 * @author Muhate, Erlon Zefanias
 * @since 1.0
 */
public abstract class Constants {

    /**
     * Enum que representa os tipos de docentes em um sistema de gestão de
     * estudantes.
     */
    public enum TituloDoDocente implements EnumOperations {
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

        @Override
        public int printAll() {
            int highIndex = 0;
            for (var typeToPrint : TituloDoDocente.values()) {
                System.out.println(typeToPrint.index + ". " + typeToPrint.descricao);
                highIndex++;
            }
            return highIndex;
        }

        @Override
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
    public enum TipoDeAvaliacao implements EnumOperations {
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

        @Override
        public int printAll() {
            int highIndex = 0;
            for (var examType : TipoDeAvaliacao.values()) {
                System.out.println(examType.index + ". " + examType.descricao);
                highIndex++;
            }
            return highIndex;
        }

        @Override
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
    public enum TipoDeDisciplina implements EnumOperations {
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

        @Override
        public int printAll() {
            int highIndex = 0;
            for (var subjectType : TipoDeDisciplina.values()) {
                System.out.println(subjectType.index + ". " + subjectType.descricao);
                highIndex++;
            }
            return highIndex;
        }

        @Override
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
    public enum NiveisDeAcesso implements EnumOperations {
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

        @Override
        public int printAll() {
            int highIndex = 0;
            for (var levelToPrint : NiveisDeAcesso.values()) {
                System.out.println(levelToPrint.index + ". " + levelToPrint.descricao);
                highIndex++;
            }
            return highIndex;
        }

        @Override
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
    public enum RegimeDeEstudo implements EnumOperations {
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

        @Override
        public int printAll() {
            int highIndex = 0;
            for (var periodToPrint : RegimeDeEstudo.values()) {
                System.out.println(periodToPrint.indice + ". " + periodToPrint.descricao);
                highIndex++;
            }
            return highIndex;
        }

        @Override
        public RegimeDeEstudo getByIndex(int index) {
            for (var regime : RegimeDeEstudo.values()) {
                if (regime.getIndice() == index) {
                    return regime;
                }
            }
            return null;
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
     /**
     * Enumeração que representa os tipos de aula ministrados em uma faculdade.
     */
    public enum TipoAula implements EnumOperations{
        /**
         * Aula Teórica: Aulas tradicionais em sala de aula com foco na apresentação de conceitos e teorias.
         */
        TEORICA(1, "Aula Teórica", "Aulas tradicionais em sala de aula com foco na apresentação de conceitos e teorias."),
        /**
         * Aula Prática: Aulas que oferecem aos alunos a oportunidade de aplicar na prática os conhecimentos adquiridos em aulas teóricas.
         */
        PRATICA(2, "Aula Prática", "Aulas que oferecem aos alunos a oportunidade de aplicar na prática os conhecimentos adquiridos em aulas teóricas."),
        /**
         * Aula Laboratorial: Aulas realizadas em laboratórios equipados com equipamentos especializados, permitindo experimentação e observação direta.
         */
        LABORATORIAL(3, "Aula Laboratorial", "Aulas realizadas em laboratórios equipados com equipamentos especializados, permitindo experimentação e observação direta."),
        /**
         * Aula Online: Aulas ministradas através de plataformas virtuais, que possibilitam aos alunos acessar materiais, assistir a palestras e interagir com professores e colegas pela internet.
         */
        ONLINE(4, "Aula Online", "Aulas ministradas através de plataformas virtuais, que possibilitam aos alunos acessar materiais, assistir a palestras e interagir com professores e colegas pela internet.");

        private int indice;
        private String descricao;
        private String detalhes;

        /**
         * Construtor privado do enum TipoAula.
         *
         * @param indice    O índice do tipo de aula.
         * @param descricao A descrição do tipo de aula.
         * @param detalhes  Os detalhes do tipo de aula.
         */
        TipoAula(int indice, String descricao, String detalhes) {
            this.indice = indice;
            this.descricao = descricao;
            this.detalhes = detalhes;
        }

        /**
         * Obtém o índice do tipo de aula.
         *
         * @return O índice do tipo de aula.
         */
        public int getIndice() {
            return indice;
        }

        /**
         * Obtém a descrição do tipo de aula.
         *
         * @return A descrição do tipo de aula.
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * Obtém os detalhes do tipo de aula.
         *
         * @return Os detalhes do tipo de aula.
         */
        public String getDetalhes() {
            return detalhes;
        }

        /**
         * Imprime todos os tipos de aula no formato "Índice. Detalhes".
         *
         * @return O índice máximo encontrado no enum TipoAula.
         */
        @Override
        public int printAll() {
            int maxIndice = 0;
            for (TipoAula tipo : TipoAula.values()) {
                System.out.println(tipo.getIndice() + ". " + tipo.getDetalhes());
                maxIndice = Math.max(maxIndice, tipo.getIndice());
            }
            return maxIndice;
        }

        /**
         * Obtém o tipo de aula correspondente ao índice fornecido.
         *
         * @param index O índice do tipo de aula.
         * @return O enum TipoAula correspondente ao índice.
         * @throws IllegalArgumentException Se o índice fornecido for inválido.
         */
        @Override
        public TipoAula getByIndex(int index) {
            for (TipoAula tipo : TipoAula.values()) {
                if (tipo.getIndice() == index) {
                    return tipo;
                }
            }
            return null;
        }

        /**
         * Retorna a descrição do tipo de aula.
         *
         * @return A descrição do tipo de aula.
         */
        @Override
        public String toString() {
            return descricao;
        }
    }
    /**
     * Enumeração que representa os tipos de sala.
     */
    public enum TipoDeSala implements EnumOperations {
        /**
         * Representa uma sala de aula.
         */
        SALA_DE_AULA(1, "Sala de Aula", "Espaço destinado às atividades de ensino."),

        /**
         * Representa um laboratório.
         */
        LABORATORIO(2, "Laboratório", "Sala equipada para realização de experimentos e práticas."),

        /**
         * Representa uma sala de informática.
         */
        SALA_DE_INFORMATICA(3, "Sala de Informática", "Espaço com computadores e acesso à Internet."),

        /**
         * Representa um anfiteatro.
         */
        ANFITEATRO(4, "Anfiteatro", "Sala de grande capacidade para palestras e apresentações.");

        private int indice;
        private String descricao;
        private String detalhes;

        /**
         * Construtor da enumeração TipoDeSala.
         *
         * @param indice     O índice da sala.
         * @param descricao  A descrição da sala.
         * @param detalhes   Os detalhes sobre a sala.
         */
        TipoDeSala(int indice, String descricao, String detalhes) {
            this.indice = indice;
            this.descricao = descricao;
            this.detalhes = detalhes;
        }

        /**
         * Retorna a representação textual da sala.
         *
         * @return A representação textual da sala.
         */
        @Override
        public String toString() {
            return "Tipo de Sala: " + descricao + "\nDetalhes: " + detalhes;
        }

        /**
         * Obtém o índice da sala.
         *
         * @return O índice da sala.
         */
        public int getIndice() {
            return indice;
        }

        /**
         * Obtém a descrição da sala.
         *
         * @return A descrição da sala.
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * Obtém os detalhes sobre a sala.
         *
         * @return Os detalhes sobre a sala.
         */
        public String getDetalhes() {
            return detalhes;
        }

        /**
         * Retorna a instância de TipoDeSala correspondente ao índice fornecido.
         *
         * @param index O índice da sala.
         * @return A instância de TipoDeSala correspondente ao índice, ou null se não for encontrado.
         */
        @Override
        public TipoDeSala getByIndex(int index) {
            for (TipoDeSala tipo : TipoDeSala.values()) {
                if (tipo.getIndice() == index) {
                    return tipo;
                }
            }
            return null;
        }

        /**
         * Imprime todas as salas com seus respectivos índices e detalhes.
         *
         * @return O maior índice encontrado.
         */
        @Override
        public int printAll() {
            int maxIndice = 0;
            for (TipoDeSala tipo : TipoDeSala.values()) {
                System.out.println(tipo.getIndice() + ". " + tipo.getDetalhes());
                maxIndice = Math.max(maxIndice, tipo.getIndice());
            }
            return maxIndice;
        }
    }


    /**
     * Represents some common operations found among the enum types.
     */
    public static interface EnumOperations {

        /**
         * Prints all enum values and returns the highest index value.
         *
         * @return the highest index value among the enum values
         */
        int printAll();

        /**
         * Retrieves the Enum object associated with the given index.
         *
         * @param index the index value to retrieve the Enum object
         * @return the Enum object associated with the index, or null if not
         * found
         */
        Enum<?> getByIndex(int index);
    }

    /**
     * Executes the "printAll" method on the provided enum type and returns the
     * highest index value.
     *
     * @param enumType the enum type on which the method should be executed
     * @return the highest index value returned by the "printAll" method
     */
    public static int executePrintAllMethod(Class<?> enumType) {
        int highIndex = 0;

        try {
            // Get all declared methods of the enumType
            Method[] methods = enumType.getDeclaredMethods();
            for (Method method : methods) {
                // Check if the method name is "printAll"
                if (method.getName().equals("printAll")) {
                    Object[] args = {};  // No arguments required since printAll is non-static

                    // Get the first enum constant of the enumType
                    Object enumInstance = enumType.getEnumConstants()[0];

                    // Invoke the printAll method on the enumInstance
                    highIndex = (int) method.invoke(enumInstance, args);
                    break;
                }
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // Exception handling, do nothing in this case
        }

        return highIndex;
    }

    /**
     * Executes the "getByIndex" method on the provided enum type with the given
     * index and returns the corresponding enum instance.
     *
     * @param enumType the enum type on which the method should be executed
     * @param index the index value to pass to the "getByIndex" method
     * @return the enum instance returned by the "getByIndex" method, or null if
     * an exception occurs
     */
    public static Enum<?> executeGetByIndexMethod(Class<?> enumType, int index) {
        try {
            // Get all declared methods of the enumType
            Method[] methods = enumType.getDeclaredMethods();
            for (Method method : methods) {
                // Check if the method name is "getByIndex"
                if (method.getName().equals("getByIndex")) {
                    Object[] args = {index};  // Pass the index as an argument to the method

                    // Get the first enum constant of the enumType
                    Object enumInstance = enumType.getEnumConstants()[0];

                    // Invoke the getByIndex method on the enumInstance
                    Enum<?> enumToReturn = (Enum<?>) method.invoke(enumInstance, args);
                    return enumToReturn;
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e) {
            // Exception handling, do nothing in this case
        }
        return null;
    }
}
